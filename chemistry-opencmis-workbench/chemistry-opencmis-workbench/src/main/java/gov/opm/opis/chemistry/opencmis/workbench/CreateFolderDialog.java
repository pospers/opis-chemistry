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
package gov.opm.opis.chemistry.opencmis.workbench;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gov.opm.opis.chemistry.opencmis.client.api.ObjectId;
import gov.opm.opis.chemistry.opencmis.client.api.ObjectType;
import gov.opm.opis.chemistry.opencmis.commons.definitions.TypeDefinition;
import gov.opm.opis.chemistry.opencmis.commons.enums.BaseTypeId;
import gov.opm.opis.chemistry.opencmis.workbench.icons.NewFolderIcon;
import gov.opm.opis.chemistry.opencmis.workbench.model.ClientModel;
import gov.opm.opis.chemistry.opencmis.workbench.swing.CreateDialog;
import gov.opm.opis.chemistry.opencmis.workbench.worker.LoadFolderWorker;
import gov.opm.opis.chemistry.opencmis.workbench.worker.LoadObjectWorker;

public class CreateFolderDialog extends CreateDialog {

    private static final long serialVersionUID = 1L;

    private JTextField nameField;
    private JComboBox<ObjectTypeItem> typeBox;

    public CreateFolderDialog(Frame owner, ClientModel model) {
        super(owner, "Create Folder", model);
        createGUI();
    }

    private void createGUI() {
        final CreateFolderDialog thisDialog = this;

        if (getClientModel().getCurrentFolder() == null) {
            JOptionPane.showMessageDialog(this, "Please select a folder first.", "No parent folder!",
                    JOptionPane.ERROR_MESSAGE);
            thisDialog.dispose();
            return;
        }

        nameField = new JTextField(60);
        createRow("Name:", nameField, 0);

        ObjectTypeItem[] types = getTypes(BaseTypeId.CMIS_FOLDER.value());
        if (types.length == 0) {
            JOptionPane.showMessageDialog(this, "No creatable type!", "Creatable Types", JOptionPane.ERROR_MESSAGE);
            thisDialog.dispose();
            return;
        }

        typeBox = new JComboBox<ObjectTypeItem>(types);
        typeBox.setSelectedIndex(0);
        typeBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                TypeDefinition type = ((ObjectTypeItem) typeBox.getSelectedItem()).getObjectType();
                updateMandatoryOrOnCreateFields(type);
            }
        });

        ObjectTypeItem type = (ObjectTypeItem) typeBox.getSelectedItem();
        updateMandatoryOrOnCreateFields(type.getObjectType());

        createRow("Type:", typeBox, 1);

        JButton createButton = new JButton("Create Folder", new NewFolderIcon(ClientHelper.BUTTON_ICON_SIZE,
                ClientHelper.BUTTON_ICON_SIZE));
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String name = nameField.getText();
                ObjectType type = ((ObjectTypeItem) typeBox.getSelectedItem()).getObjectType();

                try {
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                    ObjectId objectId = getClientModel().createFolder(name, type.getId(),
                            getMandatoryOrOnCreatePropertyValues(type));

                    if (objectId != null) {
                        LoadObjectWorker.loadObject(getOwner(), getClientModel(), objectId.getId());
                    }

                    thisDialog.setVisible(false);
                    thisDialog.dispose();
                } catch (Exception e) {
                    ClientHelper.showError(null, e);
                } finally {
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    LoadFolderWorker.reloadFolder(getOwner(), getClientModel());
                }
            }
        });
        createActionRow("", createButton, 3);

        getRootPane().setDefaultButton(createButton);

        showDialog();
    }
}
