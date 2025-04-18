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

import java.util.Map;

import gov.opm.opis.chemistry.opencmis.tck.impl.AbstractSessionTestGroup;

/**
 * This test group contains tests that check the CMIS basics such the repository
 * info or types.
 */
public class BasicsTestGroup extends AbstractSessionTestGroup {
    @Override
    public void init(Map<String, String> parameters) throws Exception {
        super.init(parameters);

        setName("Basics Test Group");
        setDescription("Basic tests.");

        addTest(new SecurityTest());
        addTest(new RepositoryInfoTest());
        addTest(new RootFolderTest());
    }
}
