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
package gov.opm.opis.chemistry.opencmis.client.bindings.spi.atompub.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Doc.
 */
public class ServiceDoc extends AtomBase {

    private static final long serialVersionUID = 1L;

    private final List<RepositoryWorkspace> workspaces = new ArrayList<RepositoryWorkspace>();

    public ServiceDoc() {
    }

    @Override
    public String getType() {
        return "Service Document";
    }

    public List<RepositoryWorkspace> getWorkspaces() {
        return workspaces;
    }

    public void addWorkspace(RepositoryWorkspace ws) {
        if (ws != null) {
            workspaces.add(ws);
        }
    }

    @Override
    public String toString() {
        return "Service Doc: " + workspaces;
    }
}
