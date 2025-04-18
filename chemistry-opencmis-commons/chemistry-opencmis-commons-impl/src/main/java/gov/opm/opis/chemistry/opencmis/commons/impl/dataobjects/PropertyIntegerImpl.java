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
import java.util.List;

import gov.opm.opis.chemistry.opencmis.commons.data.MutablePropertyInteger;
import gov.opm.opis.chemistry.opencmis.commons.definitions.PropertyDefinition;

/**
 * Integer property data implementation.
 */
public class PropertyIntegerImpl extends AbstractPropertyData<BigInteger> implements MutablePropertyInteger {

    private static final long serialVersionUID = 1L;

    public PropertyIntegerImpl() {
    }

    public PropertyIntegerImpl(String id, List<BigInteger> values) {
        setId(id);
        setValues(values);
    }

    public PropertyIntegerImpl(String id, BigInteger value) {
        setId(id);
        setValue(value);
    }

    public PropertyIntegerImpl(PropertyDefinition<BigInteger> propDef, List<BigInteger> values) {
        setPropertyDefinition(propDef);
        setValues(values);
    }

    public PropertyIntegerImpl(PropertyDefinition<BigInteger> propDef, BigInteger value) {
        setPropertyDefinition(propDef);
        setValue(value);
    }
}
