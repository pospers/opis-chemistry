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
package gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api;

/**
 * Interface representing a policy according to the CMIS specification.
 * 
 */
public interface Relationship {

    /**
     * get the source objects of this relation.
     * 
     * @return list of object ids
     */
    String getSourceObjectId();

    /**
     * get the target objects of this relation.
     * 
     * @return list of object ids
     */
    String getTargetObjectId();
}
