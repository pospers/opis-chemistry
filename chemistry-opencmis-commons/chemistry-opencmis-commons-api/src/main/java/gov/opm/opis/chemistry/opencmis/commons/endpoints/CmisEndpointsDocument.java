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
package gov.opm.opis.chemistry.opencmis.commons.endpoints;

import java.util.List;
import java.util.Map;

/**
 * CMIS endpoints document.
 */
public interface CmisEndpointsDocument extends Map<String, Object> {

    String KEY_ENDPOINTS = "endpoints";

    /**
     * Returns a list of CMIS endpoints.
     * 
     * @return list of endpoints, never {@code null}
     */
    List<CmisEndpoint> getEndpoints();

    /**
     * Returns authentication information sorted by perference.
     * 
     * @return list of authentication information, never {@code null}
     */
    List<CmisAuthentication> getAuthenticationsSortedByPreference();
}
