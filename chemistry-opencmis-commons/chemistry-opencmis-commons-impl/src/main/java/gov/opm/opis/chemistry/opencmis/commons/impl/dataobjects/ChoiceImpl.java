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

import java.util.ArrayList;
import java.util.List;

import gov.opm.opis.chemistry.opencmis.commons.definitions.Choice;

/**
 * Choice implementation.
 */
public class ChoiceImpl<T> implements Choice<T> {

    private static final long serialVersionUID = 1L;

    private String displayName;
    private List<T> value;
    private List<Choice<T>> choice;

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public List<T> getValue() {
        if (value == null) {
            value = new ArrayList<T>(0);
        }

        return value;
    }

    public void setValue(List<T> value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = new ArrayList<T>(1);
        this.value.add(value);
    }

    @Override
    public List<Choice<T>> getChoice() {
        if (choice == null) {
            choice = new ArrayList<Choice<T>>(0);
        }

        return choice;
    }

    public void setChoice(List<Choice<T>> choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "Choice [displayName=" + displayName + ", value=" + value + ", choice=" + choice + "]";
    }
}
