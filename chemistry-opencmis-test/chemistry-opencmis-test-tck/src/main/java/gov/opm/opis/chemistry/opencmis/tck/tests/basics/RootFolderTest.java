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
package gov.opm.opis.chemistry.opencmis.tck.tests.basics;

import static gov.opm.opis.chemistry.opencmis.tck.CmisTestResultStatus.FAILURE;
import static gov.opm.opis.chemistry.opencmis.tck.CmisTestResultStatus.OK;
import static gov.opm.opis.chemistry.opencmis.tck.CmisTestResultStatus.WARNING;

import java.util.Map;

import gov.opm.opis.chemistry.opencmis.client.api.Folder;
import gov.opm.opis.chemistry.opencmis.client.api.Session;
import gov.opm.opis.chemistry.opencmis.commons.data.RepositoryInfo;
import gov.opm.opis.chemistry.opencmis.commons.enums.Action;
import gov.opm.opis.chemistry.opencmis.commons.enums.BaseTypeId;
import gov.opm.opis.chemistry.opencmis.tck.CmisTestResult;
import gov.opm.opis.chemistry.opencmis.tck.impl.AbstractSessionTest;

/**
 * Basic root folder tests.
 */
public class RootFolderTest extends AbstractSessionTest {

    @Override
    public void init(Map<String, String> parameters) {
        super.init(parameters);
        setName("Root Folder Test");
        setDescription("Checks the root folder and its children for specification compliance.");
    }

    @Override
    public void run(Session session) throws Exception {
        CmisTestResult success;
        CmisTestResult failure;

        // check root folder id
        RepositoryInfo ri = getRepositoryInfo(session);

        success = createResult(OK, "Root folder id: " + ri.getRootFolderId());
        failure = createResult(FAILURE, "Root folder id is not set!");
        addResult(assertStringNotEmpty(ri.getRootFolderId(), success, failure));

        // get the root folder
        Folder rootFolder = session.getRootFolder(SELECT_ALL_NO_CACHE_OC);

        if (rootFolder == null) {
            addResult(createResult(FAILURE, "Root folder is not available!"));
            return;
        }

        // check existence
        failure = createResult(FAILURE, "Root folder doesn't exist?!");
        addResult(assertIsTrue(session.exists(ri.getRootFolderId()), null, failure));

        // check folder object
        addResult(checkObject(session, rootFolder, getAllProperties(rootFolder), "Root folder object spec compliance"));

        // folder and path
        failure = createResult(FAILURE,
                "Root folder id in the repository info doesn't match the root folder object id!");
        addResult(assertEquals(ri.getRootFolderId(), rootFolder.getId(), null, failure));

        failure = createResult(FAILURE, "Root folder is not a cmis:folder!");
        addResult(assertEquals(BaseTypeId.CMIS_FOLDER, rootFolder.getBaseTypeId(), null, failure));

        failure = createResult(FAILURE, "Root folder path is not '/'!");
        addResult(assertEquals("/", rootFolder.getPath(), null, failure));

        failure = createResult(FAILURE, "Root folder has parents!");
        addResult(assertEquals(0, rootFolder.getParents().size(), null, failure));

        // allowable actions
        failure = createResult(FAILURE, "Root folder has CAN_GET_FOLDER_PARENT allowable action!");
        addResult(assertNotAllowableAction(rootFolder, Action.CAN_GET_FOLDER_PARENT, null, failure));

        failure = createResult(WARNING, "Root folder has no CAN_GET_CHILDREN allowable action!");
        addResult(assertAllowableAction(rootFolder, Action.CAN_GET_CHILDREN, null, failure));

        // simple children test
        addResult(checkChildren(session, rootFolder, "Root folder children check"));
    }
}
