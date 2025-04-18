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
package gov.opm.opis.chemistry.opencmis.commons.impl.dataobjects;

import gov.opm.opis.chemistry.opencmis.commons.definitions.MutableDocumentTypeDefinition;
import gov.opm.opis.chemistry.opencmis.commons.enums.ContentStreamAllowed;

/**
 * Document type definition.
 */
public class DocumentTypeDefinitionImpl extends AbstractTypeDefinition implements MutableDocumentTypeDefinition {

    private static final long serialVersionUID = 1L;

    private ContentStreamAllowed contentStreamAllowed = ContentStreamAllowed.NOTALLOWED;
    private Boolean isVersionable = Boolean.FALSE;

    @Override
    public ContentStreamAllowed getContentStreamAllowed() {
        return contentStreamAllowed;
    }

    @Override
    public void setContentStreamAllowed(ContentStreamAllowed contentStreamAllowed) {
        this.contentStreamAllowed = contentStreamAllowed;
    }

    @Override
    public Boolean isVersionable() {
        return isVersionable;
    }

    @Override
    public void setIsVersionable(Boolean isVersionable) {
        this.isVersionable = isVersionable;
    }
}
