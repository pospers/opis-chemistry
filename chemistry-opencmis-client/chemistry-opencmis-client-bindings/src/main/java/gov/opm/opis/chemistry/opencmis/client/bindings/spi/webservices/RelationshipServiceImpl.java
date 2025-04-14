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
package gov.opm.opis.chemistry.opencmis.client.bindings.spi.webservices;

import static gov.opm.opis.chemistry.opencmis.commons.impl.WSConverter.convert;

import java.math.BigInteger;

import gov.opm.opis.chemistry.opencmis.client.bindings.spi.BindingSession;
import gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectList;
import gov.opm.opis.chemistry.opencmis.commons.enums.RelationshipDirection;
import gov.opm.opis.chemistry.opencmis.commons.exceptions.CmisRuntimeException;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisException;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.EnumRelationshipDirection;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.RelationshipServicePort;
import gov.opm.opis.chemistry.opencmis.commons.spi.RelationshipService;

/**
 * Relationship Service Web Services client.
 */
public class RelationshipServiceImpl extends AbstractWebServicesService implements RelationshipService {

    private final AbstractPortProvider portProvider;

    /**
     * Constructor.
     */
    public RelationshipServiceImpl(BindingSession session, AbstractPortProvider portProvider) {
        setSession(session);
        this.portProvider = portProvider;
    }

    @Override
    public ObjectList getObjectRelationships(String repositoryId, String objectId, Boolean includeSubRelationshipTypes,
            RelationshipDirection relationshipDirection, String typeId, String filter, Boolean includeAllowableActions,
            BigInteger maxItems, BigInteger skipCount, ExtensionsData extension) {
        RelationshipServicePort port = portProvider.getRelationshipServicePort(getCmisVersion(repositoryId),
                "getObjectRelationships");

        try {
            return convert(port.getObjectRelationships(repositoryId, objectId, includeSubRelationshipTypes,
                    convert(EnumRelationshipDirection.class, relationshipDirection), typeId, filter,
                    includeAllowableActions, maxItems, skipCount, convert(extension)));
        } catch (CmisException e) {
            throw convertException(e);
        } catch (Exception e) {
            throw new CmisRuntimeException("Error: " + e.getMessage(), e);
        } finally {
            portProvider.endCall(port);
        }
    }
}
