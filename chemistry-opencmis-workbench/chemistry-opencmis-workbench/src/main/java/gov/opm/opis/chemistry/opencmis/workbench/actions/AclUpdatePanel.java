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

import gov.opm.opis.chemistry.opencmis.commons.enums.Action;
import gov.opm.opis.chemistry.opencmis.workbench.AclEditorFrame;
import gov.opm.opis.chemistry.opencmis.workbench.model.ClientModel;
import gov.opm.opis.chemistry.opencmis.workbench.swing.ActionPanel;

public class AclUpdatePanel extends ActionPanel {

    private static final long serialVersionUID = 1L;

    public AclUpdatePanel(ClientModel model) {
        super("Change ACL", "Open ACL Editor", model);
    }

    @Override
    protected void createActionComponents() {
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

        return getObject().hasAllowableAction(Action.CAN_APPLY_ACL);
    }

    @Override
    public void doAction() {
        new AclEditorFrame(getClientModel(), getObject());
    }
}
