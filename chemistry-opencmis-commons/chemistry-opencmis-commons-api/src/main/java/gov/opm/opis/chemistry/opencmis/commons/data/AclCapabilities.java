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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import gov.opm.opis.chemistry.opencmis.commons.definitions.PermissionDefinition;
import gov.opm.opis.chemistry.opencmis.commons.enums.AclPropagation;
import gov.opm.opis.chemistry.opencmis.commons.enums.SupportedPermissions;

/**
 * Acl Capabilities.
 * 
 * @cmis 1.0
 */
public interface AclCapabilities extends Serializable, ExtensionsData {

    SupportedPermissions getSupportedPermissions();

    AclPropagation getAclPropagation();

    List<PermissionDefinition> getPermissions();

    Map<String, PermissionMapping> getPermissionMapping();

}
