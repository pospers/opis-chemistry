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
package gov.opm.opis.chemistry.opencmis.commons.server;

/**
 * This class contains information about an arbitrary Atom link. This data is
 * used to generate the appropriate additional links in AtomPub entries and
 * feeds.
 */
public interface LinkInfo {

    /**
     * Returns the link rel attribute.
     */
    String getRel();

    /**
     * Returns the link href attribute.
     */
    String getHref();

    /**
     * Returns the link type attribute.
     */
    String getType();

    /**
     * Returns the link id attribute.
     */
    String getId();
}
