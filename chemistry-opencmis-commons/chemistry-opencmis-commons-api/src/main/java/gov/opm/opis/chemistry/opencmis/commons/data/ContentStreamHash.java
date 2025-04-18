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
package gov.opm.opis.chemistry.opencmis.commons.data;

/**
 * Content hash.
 */
public interface ContentStreamHash {

    /**
     * Returns the content hash property value ({@code cmis:contentStreamHash}).
     * 
     * @return the content hash property value
     */
    String getPropertyValue();

    /**
     * Returns the hash algorithm.
     * 
     * @return the hash algorithm or {@code null} if the property value is
     *         invalid
     */
    String getAlgorithm();

    /**
     * Returns the hash value.
     * 
     * @return the hash value or {@code null} if the property value is invalid
     */
    String getHash();
}
