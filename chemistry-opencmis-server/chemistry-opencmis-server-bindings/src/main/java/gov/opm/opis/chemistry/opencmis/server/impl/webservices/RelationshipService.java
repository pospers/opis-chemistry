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
package gov.opm.opis.chemistry.opencmis.server.impl.webservices;

import static gov.opm.opis.chemistry.opencmis.commons.impl.WSConverter.convert;

import java.math.BigInteger;

import gov.opm.opis.chemistry.opencmis.commons.data.ObjectList;
import gov.opm.opis.chemistry.opencmis.commons.enums.CmisVersion;
import gov.opm.opis.chemistry.opencmis.commons.enums.RelationshipDirection;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisException;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisExtensionType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisObjectListType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.EnumRelationshipDirection;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.RelationshipServicePort;
import gov.opm.opis.chemistry.opencmis.commons.server.CmisService;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.soap.MTOM;

/**
 * CMIS Relationship Service.
 */
@MTOM
@WebService(endpointInterface = "gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.RelationshipServicePort")
public class RelationshipService extends AbstractService implements RelationshipServicePort {
    @Resource
    public WebServiceContext wsContext;

    @Override
    public CmisObjectListType getObjectRelationships(String repositoryId, String objectId,
            Boolean includeSubRelationshipTypes, EnumRelationshipDirection relationshipDirection, String typeId,
            String filter, Boolean includeAllowableActions, BigInteger maxItems, BigInteger skipCount,
            CmisExtensionType extension) throws CmisException {
        CmisService service = null;
        CmisVersion cmisVersion = null;
        try {
            service = getService(wsContext, repositoryId);
            cmisVersion = getCmisVersion(wsContext);

            if (stopBeforeService(service)) {
                return null;
            }

            ObjectList serviceResult = service.getObjectRelationships(repositoryId, objectId,
                    includeSubRelationshipTypes, convert(RelationshipDirection.class, relationshipDirection), typeId,
                    filter, includeAllowableActions, maxItems, skipCount, convert(extension));

            if (stopAfterService(service)) {
                return null;
            }

            return convert(serviceResult, cmisVersion);
        } catch (Exception e) {
            throw convertException(e);
        } finally {
            closeService(service);
        }
    }
}
