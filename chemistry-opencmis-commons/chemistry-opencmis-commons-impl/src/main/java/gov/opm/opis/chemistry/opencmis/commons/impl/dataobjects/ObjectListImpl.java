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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import gov.opm.opis.chemistry.opencmis.commons.data.ObjectData;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectList;

/**
 * ObjectList implementation.
 */
public class ObjectListImpl extends AbstractExtensionData implements ObjectList {

    private static final long serialVersionUID = 1L;

    private List<ObjectData> objects;
    private Boolean hasMoreItems = Boolean.FALSE;
    private BigInteger numItems;

    @Override
    public List<ObjectData> getObjects() {
        if (objects == null) {
            objects = new ArrayList<ObjectData>(0);
        }

        return objects;
    }

    public void setObjects(List<ObjectData> objects) {
        this.objects = objects;
    }

    @Override
    public Boolean hasMoreItems() {
        return hasMoreItems;
    }

    public void setHasMoreItems(Boolean hasMoreItems) {
        this.hasMoreItems = hasMoreItems;
    }

    @Override
    public BigInteger getNumItems() {
        return numItems;
    }

    public void setNumItems(BigInteger numItems) {
        this.numItems = numItems;
    }

    @Override
    public String toString() {
        return "Object List [objects=" + objects + ", has more items=" + hasMoreItems + ", num items=" + numItems + "]";
    }
}
