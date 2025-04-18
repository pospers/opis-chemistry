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
package gov.opm.opis.chemistry.opencmis.commons.definitions;

import java.util.List;

/**
 * Relationship Type Definition.
 * 
 * @cmis 1.0
 */
public interface RelationshipTypeDefinition extends TypeDefinition {

    /**
     * Returns the list of type IDs that are allowed as source objects.
     * 
     * @return list of type IDs or {@code null} if all types are allowed
     * 
     * @cmis 1.0
     */
    List<String> getAllowedSourceTypeIds();

    /**
     * Returns the list of type IDs that are allowed as target objects.
     * 
     * @return list of type IDs or {@code null} if all types are allowed
     * 
     * @cmis 1.0
     */
    List<String> getAllowedTargetTypeIds();
}
