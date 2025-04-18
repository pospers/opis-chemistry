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
package gov.opm.opis.chemistry.opencmis.server.async;

import java.util.concurrent.RejectedExecutionException;

import jakarta.servlet.AsyncContext;

/**
 * Implementations of this interface are responsible for executing a CMIS
 * request asynchronously.
 */
public interface AsyncCmisExecutor {

    /**
     * Executes a CMIS request.
     * 
     * @param asyncContext
     *            the {@link AsyncContext} object
     * @param runnable
     *            the {@link Runnable} that executes the request
     * @throws RejectedExecutionException
     *             if the request could not be scheduled for execution
     */
    void execute(AsyncContext asyncContext, Runnable runnable);
}
