/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package gov.opm.opis.chemistry.opencmis.server.impl.browser.token;

import gov.opm.opis.chemistry.opencmis.commons.enums.CmisVersion;
import gov.opm.opis.chemistry.opencmis.commons.server.CallContext;
import gov.opm.opis.chemistry.opencmis.commons.server.CmisService;
import gov.opm.opis.chemistry.opencmis.commons.server.CmisServiceFactory;
import gov.opm.opis.chemistry.opencmis.server.impl.CallContextImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SimpleTokenHandler extends AbstractSimpleTokenHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected boolean authenticate(final ServletContext servletContext, final HttpServletRequest request,
            final HttpServletResponse response, final String user, final String password) {

        // get the service factory
        CmisServiceFactory factory = getCmisServiceFactory(servletContext);

        // build a call context
        CallContextImpl context = new CallContextImpl(CallContext.BINDING_BROWSER, CmisVersion.CMIS_1_1, null, null,
                null, null, null, null);
        context.put(CallContext.USERNAME, user);
        context.put(CallContext.PASSWORD, password);

        // call getRepositoryInfos() method
        CmisService service = null;
        try {
            // get the service
            service = factory.getService(context);

            try {
                service.getRepositoryInfos(null);
            } catch (Exception e) {
                // we interpret all exceptions as a login failure
                return false;
            }
        } finally {
            if (service != null) {
                service.close();
            }
        }

        return true;
    }
}
