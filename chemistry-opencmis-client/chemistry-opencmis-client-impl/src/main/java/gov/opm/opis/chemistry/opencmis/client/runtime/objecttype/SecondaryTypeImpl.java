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

import java.util.List;

import gov.opm.opis.chemistry.opencmis.client.api.ItemIterable;
import gov.opm.opis.chemistry.opencmis.client.api.ObjectType;
import gov.opm.opis.chemistry.opencmis.client.api.SecondaryType;
import gov.opm.opis.chemistry.opencmis.client.api.Session;
import gov.opm.opis.chemistry.opencmis.client.api.Tree;
import gov.opm.opis.chemistry.opencmis.commons.definitions.SecondaryTypeDefinition;
import gov.opm.opis.chemistry.opencmis.commons.impl.dataobjects.SecondaryTypeDefinitionImpl;

public class SecondaryTypeImpl extends SecondaryTypeDefinitionImpl implements SecondaryType {

    private static final long serialVersionUID = 1L;

    private final ObjectTypeHelper helper;

    public SecondaryTypeImpl(Session session, SecondaryTypeDefinition typeDefinition) {
        assert session != null;
        assert typeDefinition != null;

        initialize(typeDefinition);
        helper = new ObjectTypeHelper(session, this);
    }

    @Override
    public ObjectType getBaseType() {
        return helper.getBaseType();
    }

    @Override
    public ItemIterable<ObjectType> getChildren() {
        return helper.getChildren();
    }

    @Override
    public List<Tree<ObjectType>> getDescendants(int depth) {
        return helper.getDescendants(depth);
    }

    @Override
    public ObjectType getParentType() {
        return helper.getParentType();
    }

    @Override
    public boolean isBaseType() {
        return helper.isBaseType();
    }
}
