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

import java.util.List;

/**
 * Access Control List (ACL).
 */
public interface Acl extends ExtensionsData {

    /**
     * Returns the list of Access Control Entries (ACEs).
     * 
     * @return the list of ACEs, not {@code null}
     */
    List<Ace> getAces();

    /**
     * Indicates whether this ACL expresses all permissions of the object.
     * 
     * @return {@code true} if the ACL expresses the exact permission set,
     *         {@code false} if there are other permission rules that cannot be
     *         expressed through ACEs, and {@code null} if this in unknown (the
     *         repository did not provide this information)
     */
    Boolean isExact();
}
