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
package gov.opm.opis.chemistry.opencmis.client.bindings.spi.http;

import java.math.BigInteger;
import java.util.Map;

import gov.opm.opis.chemistry.opencmis.client.bindings.spi.BindingSession;
import gov.opm.opis.chemistry.opencmis.commons.impl.UrlBuilder;

/**
 * HTTP Invoker Interface.
 */
public interface HttpInvoker {

    /**
     * Executes a HTTP GET request.
     */
    Response invokeGET(UrlBuilder url, BindingSession session);

    /**
     * Executes a HTTP GET request.
     */
    Response invokeGET(UrlBuilder url, BindingSession session, BigInteger offset, BigInteger length);

    /**
     * Executes a HTTP POST request.
     */
    Response invokePOST(UrlBuilder url, String contentType, Output writer, BindingSession session);

    /**
     * Executes a HTTP PUT request.
     */
    Response invokePUT(UrlBuilder url, String contentType, Map<String, String> headers, Output writer,
            BindingSession session);

    /**
     * Executes a HTTP DELETE request.
     */
    Response invokeDELETE(UrlBuilder url, BindingSession session);
}
