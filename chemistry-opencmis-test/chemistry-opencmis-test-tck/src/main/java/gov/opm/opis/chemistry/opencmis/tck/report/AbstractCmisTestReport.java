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
package gov.opm.opis.chemistry.opencmis.tck.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import gov.opm.opis.chemistry.opencmis.commons.impl.IOUtils;
import gov.opm.opis.chemistry.opencmis.tck.CmisTestGroup;
import gov.opm.opis.chemistry.opencmis.tck.CmisTestReport;

/**
 * Base class for reports.
 */
public abstract class AbstractCmisTestReport implements CmisTestReport {

    @Override
    public abstract void createReport(Map<String, String> parameters, List<CmisTestGroup> groups, Writer writer)
            throws Exception;

    @Override
    public void createReport(Map<String, String> parameters, List<CmisTestGroup> groups, File file) throws Exception {
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), IOUtils.UTF8);
        try {
            createReport(parameters, groups, writer);
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }
}
