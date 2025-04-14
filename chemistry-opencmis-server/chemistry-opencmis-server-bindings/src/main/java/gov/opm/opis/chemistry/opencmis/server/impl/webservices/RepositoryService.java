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
import static gov.opm.opis.chemistry.opencmis.commons.impl.WSConverter.convertExtensionHolder;
import static gov.opm.opis.chemistry.opencmis.commons.impl.WSConverter.convertTypeContainerList;
import static gov.opm.opis.chemistry.opencmis.commons.impl.WSConverter.setExtensionValues;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData;
import gov.opm.opis.chemistry.opencmis.commons.data.RepositoryInfo;
import gov.opm.opis.chemistry.opencmis.commons.definitions.TypeDefinition;
import gov.opm.opis.chemistry.opencmis.commons.definitions.TypeDefinitionContainer;
import gov.opm.opis.chemistry.opencmis.commons.definitions.TypeDefinitionList;
import gov.opm.opis.chemistry.opencmis.commons.enums.CmisVersion;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisException;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisExtensionType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisRepositoryEntryType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisRepositoryInfoType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisTypeContainer;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisTypeDefinitionListType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisTypeDefinitionType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.RepositoryServicePort;
import gov.opm.opis.chemistry.opencmis.commons.server.CmisService;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.xml.ws.Holder;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.soap.MTOM;

/**
 * CMIS Repository Service.
 */
@MTOM
@WebService(endpointInterface = "gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.RepositoryServicePort")
public class RepositoryService extends AbstractService implements RepositoryServicePort {
    @Resource
    public WebServiceContext wsContext;

    @Override
    public List<CmisRepositoryEntryType> getRepositories(CmisExtensionType extension) throws CmisException {
        CmisService service = null;
        try {
            service = getServiceForRepositoryInfo(wsContext, null);

            if (stopBeforeService(service)) {
                return null;
            }

            List<RepositoryInfo> infoDataList = service.getRepositoryInfos(convert(extension));

            if (stopAfterService(service)) {
                return null;
            }

            if (infoDataList == null) {
                return null;
            }

            List<CmisRepositoryEntryType> result = new ArrayList<CmisRepositoryEntryType>();
            for (RepositoryInfo infoData : infoDataList) {
                CmisRepositoryEntryType entry = new CmisRepositoryEntryType();
                entry.setRepositoryId(infoData.getId());
                entry.setRepositoryName(infoData.getName());

                result.add(entry);
            }

            return result;
        } catch (Exception e) {
            throw convertException(e);
        } finally {
            closeService(service);
        }
    }

    @Override
    public CmisRepositoryInfoType getRepositoryInfo(String repositoryId, CmisExtensionType extension)
            throws CmisException {
        CmisService service = null;
        CmisVersion cmisVersion = null;
        try {
            service = getServiceForRepositoryInfo(wsContext, repositoryId);
            cmisVersion = getCmisVersion(wsContext);

            if (stopBeforeService(service)) {
                return null;
            }

            RepositoryInfo serviceResult = service.getRepositoryInfo(repositoryId, convert(extension));

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

    @Override
    public CmisTypeDefinitionListType getTypeChildren(String repositoryId, String typeId,
            Boolean includePropertyDefinitions, BigInteger maxItems, BigInteger skipCount, CmisExtensionType extension)
            throws CmisException {
        CmisService service = null;
        try {
            service = getService(wsContext, repositoryId);

            if (stopBeforeService(service)) {
                return null;
            }

            TypeDefinitionList serviceResult = service.getTypeChildren(repositoryId, typeId,
                    includePropertyDefinitions, maxItems, skipCount, convert(extension));

            if (stopAfterService(service)) {
                return null;
            }

            return convert(serviceResult);
        } catch (Exception e) {
            throw convertException(e);
        } finally {
            closeService(service);
        }
    }

    @Override
    public CmisTypeDefinitionType getTypeDefinition(String repositoryId, String typeId, CmisExtensionType extension)
            throws CmisException {
        CmisService service = null;
        try {
            service = getService(wsContext, repositoryId);

            if (stopBeforeService(service)) {
                return null;
            }

            TypeDefinition serviceResult = service.getTypeDefinition(repositoryId, typeId, convert(extension));

            if (stopAfterService(service)) {
                return null;
            }

            return convert(serviceResult);
        } catch (Exception e) {
            throw convertException(e);
        } finally {
            closeService(service);
        }
    }

    @Override
    public List<CmisTypeContainer> getTypeDescendants(String repositoryId, String typeId, BigInteger depth,
            Boolean includePropertyDefinitions, CmisExtensionType extension) throws CmisException {
        CmisService service = null;
        try {
            service = getService(wsContext, repositoryId);

            if (stopBeforeService(service)) {
                return null;
            }

            List<TypeDefinitionContainer> serviceResult = service.getTypeDescendants(repositoryId, typeId, depth,
                    includePropertyDefinitions, convert(extension));

            if (stopAfterService(service)) {
                return null;
            }

            List<CmisTypeContainer> result = new ArrayList<CmisTypeContainer>();
            convertTypeContainerList(serviceResult, result);

            return result;
        } catch (Exception e) {
            throw convertException(e);
        } finally {
            closeService(service);
        }
    }

    @Override
    public void createType(String repositoryId, Holder<CmisTypeDefinitionType> type, CmisExtensionType extension)
            throws CmisException {
        CmisService service = null;
        try {
            service = getService(wsContext, repositoryId);

            if (stopBeforeService(service)) {
                return;
            }

            TypeDefinition serviceResult = service.createType(repositoryId, convert(type.value), convert(extension));

            if (stopAfterService(service)) {
                return;
            }

            type.value = convert(serviceResult);
        } catch (Exception e) {
            throw convertException(e);
        } finally {
            closeService(service);
        }
    }

    @Override
    public void updateType(String repositoryId, Holder<CmisTypeDefinitionType> type, CmisExtensionType extension)
            throws CmisException {
        CmisService service = null;
        try {
            service = getService(wsContext, repositoryId);

            if (stopBeforeService(service)) {
                return;
            }

            TypeDefinition serviceResult = service.updateType(repositoryId, convert(type.value), convert(extension));

            if (stopAfterService(service)) {
                return;
            }

            type.value = convert(serviceResult);
        } catch (Exception e) {
            throw convertException(e);
        } finally {
            closeService(service);
        }
    }

    @Override
    public void deleteType(String repositoryId, String typeId, Holder<CmisExtensionType> extension)
            throws CmisException {

        CmisService service = null;
        try {
            service = getService(wsContext, repositoryId);

            ExtensionsData extData = convertExtensionHolder(extension);

            if (stopBeforeService(service)) {
                return;
            }

            service.deleteType(repositoryId, typeId, extData);

            if (stopAfterService(service)) {
                return;
            }

            setExtensionValues(extData, extension);
        } catch (Exception e) {
            throw convertException(e);
        } finally {
            closeService(service);
        }
    }
}
