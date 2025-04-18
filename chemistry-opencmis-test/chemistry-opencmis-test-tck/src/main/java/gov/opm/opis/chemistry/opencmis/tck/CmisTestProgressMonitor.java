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
package gov.opm.opis.chemistry.opencmis.tck;

/**
 * CMIS Progress Monitor.
 */
public interface CmisTestProgressMonitor {

    /**
     * Called before a new group run starts.
     */
    void startGroup(CmisTestGroup group);

    /**
     * Called after a group run ended.
     */
    void endGroup(CmisTestGroup group);

    /**
     * Called before a new test run starts.
     */
    void startTest(CmisTest test);

    /**
     * Called after a test run ended.
     */
    void endTest(CmisTest test);

    /**
     * Called when a group or test wants to print out a message.
     */
    void message(String msg);
}
