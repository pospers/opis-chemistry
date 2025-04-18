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
package gov.opm.opis.chemistry.opencmis.client.bindings.spi.atompub.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Base type for Atom responses.
 */
public abstract class AtomBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<AtomElement> elements = new ArrayList<AtomElement>();

    protected AtomBase() {
    }

    public abstract String getType();

    public List<AtomElement> getElements() {
        return elements;
    }

    public void addElement(AtomElement element) {
        if (element != null) {
            elements.add(element);
        }
    }
}
