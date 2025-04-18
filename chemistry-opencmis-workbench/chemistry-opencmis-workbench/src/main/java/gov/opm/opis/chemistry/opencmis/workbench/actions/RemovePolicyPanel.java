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

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gov.opm.opis.chemistry.opencmis.client.runtime.ObjectIdImpl;
import gov.opm.opis.chemistry.opencmis.commons.enums.Action;
import gov.opm.opis.chemistry.opencmis.workbench.model.ClientModel;
import gov.opm.opis.chemistry.opencmis.workbench.swing.ActionPanel;

public class RemovePolicyPanel extends ActionPanel {

    private static final long serialVersionUID = 1L;

    private JTextField policyField;

    public RemovePolicyPanel(ClientModel model) {
        super("Remove Policy", "Remove Policy", model);
    }

    @Override
    protected void createActionComponents() {
        JPanel policyIdPanel = new JPanel(new BorderLayout());
        policyIdPanel.setBackground(Color.WHITE);

        policyIdPanel.add(new JLabel("Policy Id:"), BorderLayout.LINE_START);

        policyField = new JTextField(30);
        policyIdPanel.add(policyField, BorderLayout.CENTER);

        addActionComponent(policyIdPanel);
    }

    @Override
    public boolean isAllowed() {
        if (getObject() == null) {
            return false;
        }

        if ((getObject().getAllowableActions() == null)
                || (getObject().getAllowableActions().getAllowableActions() == null)) {
            return true;
        }

        return getObject().hasAllowableAction(Action.CAN_REMOVE_POLICY);
    }

    @Override
    public void doAction() {
        getObject().removePolicy(new ObjectIdImpl(policyField.getText()), false);
        reload(true);
    }
}
