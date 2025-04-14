/*
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
 */
package gov.opm.opis.chemistry.opencmis.server.async.impl.browser;

import java.io.IOException;

import gov.opm.opis.chemistry.opencmis.server.async.impl.AsyncCmisServlet;
import gov.opm.opis.chemistry.opencmis.server.async.impl.CmisAsyncHelper;
import gov.opm.opis.chemistry.opencmis.server.impl.browser.CmisBrowserBindingServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Async CMIS Browser binding servlet.
 */
@WebServlet(asyncSupported = true)
public class AsyncCmisBrowserBindingServlet extends CmisBrowserBindingServlet implements AsyncCmisServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CmisAsyncHelper.executeAsync(this, req, resp);
    }

    @Override
    public void executeSync(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void sendError(Exception ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
        printError(null, ex, request, response);
    }
}
