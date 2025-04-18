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
package gov.opm.opis.chemistry.opencmis.client.runtime.objecttype;

import java.io.Serializable;
import java.util.List;

import gov.opm.opis.chemistry.opencmis.client.api.ItemIterable;
import gov.opm.opis.chemistry.opencmis.client.api.ObjectType;
import gov.opm.opis.chemistry.opencmis.client.api.Session;
import gov.opm.opis.chemistry.opencmis.client.api.Tree;

/**
 * Helper for object types, containing session-related info.
 * <p>
 * This is needed because Java doesn't support multiple inheritance.
 */
public class ObjectTypeHelper implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Session session;
    private final ObjectType objectType;
    private ObjectType baseType;
    private ObjectType parentType;

    public ObjectTypeHelper(Session session, ObjectType objectType) {
        assert session != null;
        assert objectType != null;

        this.session = session;
        this.objectType = objectType;
    }

    public Session getSession() {
        return session;
    }

    public boolean isBaseType() {
        return objectType.getParentTypeId() == null || objectType.getParentTypeId().length() == 0;
    }

    public ObjectType getBaseType() {
        if (isBaseType()) {
            return null;
        }
        if (baseType != null) {
            return baseType;
        }
        if (objectType.getBaseTypeId() == null) {
            return null;
        }
        baseType = session.getTypeDefinition(objectType.getBaseTypeId().value());
        return baseType;
    }

    public ObjectType getParentType() {
        if (parentType != null) {
            return parentType;
        }
        if (objectType.getParentTypeId() == null || objectType.getParentTypeId().length() == 0) {
            return null;
        }
        parentType = session.getTypeDefinition(objectType.getParentTypeId());
        return parentType;
    }

    public ItemIterable<ObjectType> getChildren() {
        return session.getTypeChildren(objectType.getId(), true);
    }

    public List<Tree<ObjectType>> getDescendants(int depth) {
        return session.getTypeDescendants(objectType.getId(), depth, true);
    }
}
