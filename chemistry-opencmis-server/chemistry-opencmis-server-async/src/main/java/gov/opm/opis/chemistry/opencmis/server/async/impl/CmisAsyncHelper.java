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
package gov.opm.opis.chemistry.opencmis.server.async.impl;

import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.opm.opis.chemistry.opencmis.commons.exceptions.CmisServiceUnavailableException;
import gov.opm.opis.chemistry.opencmis.commons.server.CmisServiceFactory;
import gov.opm.opis.chemistry.opencmis.server.async.AsyncCmisExecutor;
import gov.opm.opis.chemistry.opencmis.server.async.AsyncCmisServiceFactory;
import gov.opm.opis.chemistry.opencmis.server.impl.CmisRepositoryContextListener;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public final class CmisAsyncHelper {

    private static final Logger LOG = LoggerFactory.getLogger(CmisAsyncHelper.class);

    /**
     * Gets the service factory and get the AsyncCmisExecutor instance.
     */
    public static AsyncCmisExecutor getAsyncCmisExecutor(ServletConfig config, HttpServletRequest request,
            HttpServletResponse response) throws ServletException {
        CmisServiceFactory serviceFactory = CmisRepositoryContextListener.getServiceFactory(config.getServletContext());
        if (!(serviceFactory instanceof AsyncCmisServiceFactory)) {
            throw new ServletException("CMIS service factory does not support asynchronous execution!");
        }

        return ((AsyncCmisServiceFactory) serviceFactory).getAsyncCmisExecutor(request, response);
    }

    /**
     * Executes a request asynchronously.
     */
    public static void executeAsync(AsyncCmisServlet servlet, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AsyncCmisExecutor executor = getAsyncCmisExecutor(servlet.getServletConfig(), request, response);

        if (executor == null) {
            // there is no executor -> execute synchronously
            servlet.executeSync(request, response);
        } else {
            // there is an executor -> start asynchronous execution
            AsyncContext asyncContext = request.startAsync();

            try {
                executor.execute(asyncContext, new CmisRequestRunner(asyncContext, servlet));
            } catch (RejectedExecutionException ree) {
                if (LOG.isWarnEnabled()) {
                    LOG.warn("Submitting async request failed: {}", ree.toString(), ree);
                }

                servlet.sendError(new CmisServiceUnavailableException("CMIS server is busy", ree), request, response);
                asyncContext.complete();
            } catch (Exception e) {
                LOG.error("Executing async request failed: {}", e.toString(), e);

                servlet.sendError(e, request, response);
                asyncContext.complete();
            }
        }
    }

    private CmisAsyncHelper() {
    }
}
