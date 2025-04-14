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
import java.util.ArrayList;
import java.util.List;

import gov.opm.opis.chemistry.opencmis.client.bindings.spi.BindingSession;
import gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectData;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectInFolderContainer;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectInFolderList;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectList;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectParentData;
import gov.opm.opis.chemistry.opencmis.commons.enums.IncludeRelationships;
import gov.opm.opis.chemistry.opencmis.commons.exceptions.CmisRuntimeException;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisException;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisObjectInFolderContainerType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisObjectParentsType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.EnumIncludeRelationships;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.NavigationServicePort;
import gov.opm.opis.chemistry.opencmis.commons.spi.NavigationService;

/**
 * Navigation Service Web Services client.
 */
public class NavigationServiceImpl extends AbstractWebServicesService implements NavigationService {

    private final AbstractPortProvider portProvider;

    /**
     * Constructor.
     */
    public NavigationServiceImpl(BindingSession session, AbstractPortProvider portProvider) {
        setSession(session);
        this.portProvider = portProvider;
    }

    @Override
    public ObjectInFolderList getChildren(String repositoryId, String folderId, String filter, String orderBy,
            Boolean includeAllowableActions, IncludeRelationships includeRelationships, String renditionFilter,
            Boolean includePathSegment, BigInteger maxItems, BigInteger skipCount, ExtensionsData extension) {
        NavigationServicePort port = portProvider.getNavigationServicePort(getCmisVersion(repositoryId), "getChildren");

        try {
            return convert(port.getChildren(repositoryId, folderId, filter, orderBy, includeAllowableActions,
                    convert(EnumIncludeRelationships.class, includeRelationships), renditionFilter, includePathSegment,
                    maxItems, skipCount, convert(extension)));
        } catch (CmisException e) {
            throw convertException(e);
        } catch (Exception e) {
            throw new CmisRuntimeException("Error: " + e.getMessage(), e);
        } finally {
            portProvider.endCall(port);
        }
    }

    @Override
    public List<ObjectInFolderContainer> getDescendants(String repositoryId, String folderId, BigInteger depth,
            String filter, Boolean includeAllowableActions, IncludeRelationships includeRelationships,
            String renditionFilter, Boolean includePathSegment, ExtensionsData extension) {
        NavigationServicePort port = portProvider.getNavigationServicePort(getCmisVersion(repositoryId),
                "getDescendants");

        try {
            List<CmisObjectInFolderContainerType> containerList = port.getDescendants(repositoryId, folderId, depth,
                    filter, includeAllowableActions, convert(EnumIncludeRelationships.class, includeRelationships),
                    renditionFilter, includePathSegment, convert(extension));

            // no list?
            if (containerList == null) {
                return null;
            }

            // convert list
            List<ObjectInFolderContainer> result = new ArrayList<ObjectInFolderContainer>();
            for (CmisObjectInFolderContainerType container : containerList) {
                result.add(convert(container));
            }

            return result;
        } catch (CmisException e) {
            throw convertException(e);
        } catch (Exception e) {
            throw new CmisRuntimeException("Error: " + e.getMessage(), e);
        } finally {
            portProvider.endCall(port);
        }
    }

    @Override
    public ObjectData getFolderParent(String repositoryId, String folderId, String filter, ExtensionsData extension) {
        NavigationServicePort port = portProvider.getNavigationServicePort(getCmisVersion(repositoryId),
                "getFolderParent");

        try {
            return convert(port.getFolderParent(repositoryId, folderId, filter, convert(extension)));
        } catch (CmisException e) {
            throw convertException(e);
        } catch (Exception e) {
            throw new CmisRuntimeException("Error: " + e.getMessage(), e);
        } finally {
            portProvider.endCall(port);
        }
    }

    @Override
    public List<ObjectInFolderContainer> getFolderTree(String repositoryId, String folderId, BigInteger depth,
            String filter, Boolean includeAllowableActions, IncludeRelationships includeRelationships,
            String renditionFilter, Boolean includePathSegment, ExtensionsData extension) {
        NavigationServicePort port = portProvider.getNavigationServicePort(getCmisVersion(repositoryId),
                "getFolderTree");

        try {
            List<CmisObjectInFolderContainerType> containerList = port.getFolderTree(repositoryId, folderId, depth,
                    filter, includeAllowableActions, convert(EnumIncludeRelationships.class, includeRelationships),
                    renditionFilter, includePathSegment, convert(extension));

            // no list?
            if (containerList == null) {
                return null;
            }

            // convert list
            List<ObjectInFolderContainer> result = new ArrayList<ObjectInFolderContainer>();
            for (CmisObjectInFolderContainerType container : containerList) {
                result.add(convert(container));
            }

            return result;
        } catch (CmisException e) {
            throw convertException(e);
        } catch (Exception e) {
            throw new CmisRuntimeException("Error: " + e.getMessage(), e);
        } finally {
            portProvider.endCall(port);
        }
    }

    @Override
    public List<ObjectParentData> getObjectParents(String repositoryId, String objectId, String filter,
            Boolean includeAllowableActions, IncludeRelationships includeRelationships, String renditionFilter,
            Boolean includeRelativePathSegment, ExtensionsData extension) {
        NavigationServicePort port = portProvider.getNavigationServicePort(getCmisVersion(repositoryId),
                "getObjectParents");

        try {
            List<CmisObjectParentsType> parentsList = port.getObjectParents(repositoryId, objectId, filter,
                    includeAllowableActions, convert(EnumIncludeRelationships.class, includeRelationships),
                    renditionFilter, includeRelativePathSegment, convert(extension));

            // no list?
            if (parentsList == null) {
                return null;
            }

            // convert list
            List<ObjectParentData> result = new ArrayList<ObjectParentData>();
            for (CmisObjectParentsType parent : parentsList) {
                result.add(convert(parent));
            }

            return result;
        } catch (CmisException e) {
            throw convertException(e);
        } catch (Exception e) {
            throw new CmisRuntimeException("Error: " + e.getMessage(), e);
        } finally {
            portProvider.endCall(port);
        }
    }

    @Override
    public ObjectList getCheckedOutDocs(String repositoryId, String folderId, String filter, String orderBy,
            Boolean includeAllowableActions, IncludeRelationships includeRelationships, String renditionFilter,
            BigInteger maxItems, BigInteger skipCount, ExtensionsData extension) {
        NavigationServicePort port = portProvider.getNavigationServicePort(getCmisVersion(repositoryId),
                "getCheckedOutDocs");

        try {
            return convert(port.getCheckedOutDocs(repositoryId, folderId, filter, orderBy, includeAllowableActions,
                    convert(EnumIncludeRelationships.class, includeRelationships), renditionFilter, maxItems,
                    skipCount, convert(extension)));
        } catch (CmisException e) {
            throw convertException(e);
        } catch (Exception e) {
            throw new CmisRuntimeException("Error: " + e.getMessage(), e);
        } finally {
            portProvider.endCall(port);
        }
    }
}
