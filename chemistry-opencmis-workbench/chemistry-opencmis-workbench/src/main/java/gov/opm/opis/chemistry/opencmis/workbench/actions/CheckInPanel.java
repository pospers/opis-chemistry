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
package gov.opm.opis.chemistry.opencmis.workbench.actions;

import java.io.FileNotFoundException;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import gov.opm.opis.chemistry.opencmis.client.api.Document;
import gov.opm.opis.chemistry.opencmis.commons.data.ContentStream;
import gov.opm.opis.chemistry.opencmis.commons.enums.Action;
import gov.opm.opis.chemistry.opencmis.commons.impl.IOUtils;
import gov.opm.opis.chemistry.opencmis.workbench.model.ClientModel;
import gov.opm.opis.chemistry.opencmis.workbench.swing.ActionPanel;

public class CheckInPanel extends ActionPanel {

    private static final long serialVersionUID = 1L;

    private JCheckBox majorBox;
    private JTextField filenameField;

    public CheckInPanel(ClientModel model) {
        super("Check-in Object", "Check-in", model);
    }

    @Override
    protected void createActionComponents() {
        majorBox = new JCheckBox("major version", true);
        addActionComponent(majorBox);

        filenameField = new JTextField(30);
        addActionComponent(createFilenamePanel(filenameField));
    }

    @Override
    public boolean isAllowed() {
        if ((getObject() == null) || !(getObject() instanceof Document)) {
            return false;
        }

        if ((getObject().getAllowableActions() == null)
                || (getObject().getAllowableActions().getAllowableActions() == null)) {
            return true;
        }

        return getObject().hasAllowableAction(Action.CAN_CHECK_IN);
    }

    @Override
    public void doAction() throws FileNotFoundException {
        ContentStream content = getClientModel().createContentStream(filenameField.getText());

        try {
            ((Document) getObject()).checkIn(majorBox.isSelected(), null, content, null, null, null, null);
        } finally {
            IOUtils.closeQuietly(content);
        }

        reload(false);
    }
}