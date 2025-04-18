/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package gov.opm.opis.chemistry.opencmis.client.bindings.spi.local;

import java.util.List;

import gov.opm.opis.chemistry.opencmis.client.bindings.spi.BindingSession;
import gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectData;
import gov.opm.opis.chemistry.opencmis.commons.server.CmisService;
import gov.opm.opis.chemistry.opencmis.commons.server.CmisServiceFactory;
import gov.opm.opis.chemistry.opencmis.commons.spi.PolicyService;

public class PolicyServiceImpl extends AbstractLocalService implements PolicyService {

    /**
     * Constructor.
     */
    public PolicyServiceImpl(BindingSession session, CmisServiceFactory factory) {
        setSession(session);
        setServiceFactory(factory);
    }

    @Override
    public void applyPolicy(String repositoryId, String policyId, String objectId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            if (stopBeforeService(service)) {
                return;
            }

            service.applyPolicy(repositoryId, policyId, objectId, extension);

            if (stopAfterService(service)) {
                return;
            }
        } finally {
            service.close();
        }
    }

    @Override
    public List<ObjectData> getAppliedPolicies(String repositoryId, String objectId, String filter,
            ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            if (stopBeforeService(service)) {
                return null;
            }
            List<ObjectData> serviceResut = service.getAppliedPolicies(repositoryId, objectId, filter, extension);

            if (stopAfterService(service)) {
                return null;
            }

            return serviceResut;
        } finally {
            service.close();
        }
    }

    @Override
    public void removePolicy(String repositoryId, String policyId, String objectId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            if (stopBeforeService(service)) {
                return;
            }

            service.removePolicy(repositoryId, policyId, objectId, extension);

            if (stopAfterService(service)) {
                return;
            }
        } finally {
            service.close();
        }
    }
}
