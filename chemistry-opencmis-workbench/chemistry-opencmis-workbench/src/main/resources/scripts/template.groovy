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

import gov.opm.opis.chemistry.opencmis.commons.*
import gov.opm.opis.chemistry.opencmis.commons.data.*
import gov.opm.opis.chemistry.opencmis.commons.enums.*
import gov.opm.opis.chemistry.opencmis.client.api.*
import gov.opm.opis.chemistry.opencmis.client.util.*

// println session.repositoryInfo.name
//
// def rootFolder = session.rootFolder
// println rootFolder.name
// 
// rootFolder.getChildren().each { child ->
//    println "${child.name} (${child.id}) [${child.type.id}]"
// }