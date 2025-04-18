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
package gov.opm.opis.chemistry.opencmis.inmemory.storedobj.impl;

import java.util.List;

import gov.opm.opis.chemistry.opencmis.commons.data.Acl;
import gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData;
import gov.opm.opis.chemistry.opencmis.commons.data.Properties;
import gov.opm.opis.chemistry.opencmis.commons.definitions.TypeDefinition;
import gov.opm.opis.chemistry.opencmis.commons.enums.AclPropagation;
import gov.opm.opis.chemistry.opencmis.commons.enums.RelationshipDirection;
import gov.opm.opis.chemistry.opencmis.commons.enums.UnfileObject;
import gov.opm.opis.chemistry.opencmis.commons.exceptions.CmisConstraintException;
import gov.opm.opis.chemistry.opencmis.commons.exceptions.CmisInvalidArgumentException;
import gov.opm.opis.chemistry.opencmis.commons.exceptions.CmisNotSupportedException;
import gov.opm.opis.chemistry.opencmis.commons.server.CallContext;
import gov.opm.opis.chemistry.opencmis.commons.spi.Holder;
import gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl;
import gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api.ObjectStore;
import gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api.Policy;
import gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api.StoreManager;
import gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api.StoredObject;

public class InMemoryServiceValidatorImpl extends BaseServiceValidatorImpl {

    public InMemoryServiceValidatorImpl(StoreManager sm) {
        super(sm);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #checkStandardParameters(java.lang.String, java.lang.String)
     */
    @Override
    protected StoredObject checkStandardParameters(String repositoryId, String objectId) {

        StoredObject so = super.checkStandardParameters(repositoryId, objectId);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #checkStandardParametersAllowNull(java.lang.String, java.lang.String)
     */
    @Override
    protected StoredObject checkStandardParametersAllowNull(String repositoryId, String objectId) {

        StoredObject so = super.checkStandardParametersAllowNull(repositoryId, objectId);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #checkExistingObjectId
     * (gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api.ObjectStore,
     * java.lang.String)
     */
    @Override
    protected StoredObject checkExistingObjectId(ObjectStore objStore, String objectId) {

        StoredObject so = super.checkExistingObjectId(objStore, objectId);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #checkParams(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    protected StoredObject[] checkParams(String repositoryId, String objectId1, String objectId2) {

        StoredObject[] sos = super.checkParams(repositoryId, objectId1, objectId2);
        return sos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getRepositoryInfos
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public void getRepositoryInfos(CallContext context, ExtensionsData extension) {

        super.getRepositoryInfos(context, extension);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getRepositoryInfo
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public void getRepositoryInfo(CallContext context, String repositoryId, ExtensionsData extension) {

        super.getRepositoryInfo(context, repositoryId, extension);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getTypeChildren
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public void getTypeChildren(CallContext context, String repositoryId, String typeId, ExtensionsData extension) {

        super.getTypeChildren(context, repositoryId, typeId, extension);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getTypeDescendants
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public void getTypeDescendants(CallContext context, String repositoryId, String typeId, ExtensionsData extension) {

        super.getTypeDescendants(context, repositoryId, typeId, extension);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getTypeDefinition
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public void getTypeDefinition(CallContext context, String repositoryId, String typeId, ExtensionsData extension) {

        super.getTypeDefinition(context, repositoryId, typeId, extension);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getChildren(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getChildren(CallContext context, String repositoryId, String folderId, 
            ExtensionsData extension) {

        StoredObject so = super.getChildren(context, repositoryId, folderId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getDescendants(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getDescendants(CallContext context, String repositoryId, String folderId,
            ExtensionsData extension) {

        StoredObject so = super.getDescendants(context, repositoryId, folderId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getFolderTree(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getFolderTree(CallContext context, String repositoryId, String folderId,
            ExtensionsData extension) {

        StoredObject so = super.getFolderTree(context, repositoryId, folderId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getObjectParents
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getObjectParents(CallContext context, String repositoryId, String objectId,
            ExtensionsData extension) {

        StoredObject so = super.getObjectParents(context, repositoryId, objectId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getFolderParent
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getFolderParent(CallContext context, String repositoryId, String folderId,
            ExtensionsData extension) {

        StoredObject so = super.getFolderParent(context, repositoryId, folderId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getCheckedOutDocs
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getCheckedOutDocs(CallContext context, String repositoryId, String folderId,
            ExtensionsData extension) {

        StoredObject so = super.getCheckedOutDocs(context, repositoryId, folderId, extension);
        if (null != so) {
            checkReadAccess(repositoryId, context.getUsername(), so);
        }
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #createDocument(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject createDocument(CallContext context, String repositoryId, String folderId,
            List<String> policyIds, ExtensionsData extension) {

        StoredObject folder = super.createDocument(context, repositoryId, folderId, policyIds, extension);
        if (null != folder) {
            checkWriteAccess(repositoryId, context.getUsername(), folder);
        }
        return folder;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #createDocumentFromSource
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject createDocumentFromSource(CallContext context, String repositoryId, String sourceId,
            String folderId, List<String> policyIds, ExtensionsData extension) {

        StoredObject source = super.createDocumentFromSource(context, repositoryId, sourceId, folderId, policyIds,
                extension);
        checkWriteAccess(repositoryId, context.getUsername(), source);
        return source;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #createFolder(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject createFolder(CallContext context, String repositoryId, String folderId, List<String> policyIds,
            ExtensionsData extension) {

        StoredObject parentFolder = super.createFolder(context, repositoryId, folderId, policyIds, extension);
        checkWriteAccess(repositoryId, context.getUsername(), parentFolder);
        return parentFolder;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #createRelationship
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject[] createRelationship(CallContext context, String repositoryId, String sourceId,
            String targetId, List<String> policyIds, ExtensionsData extension) {

        StoredObject[] sos = super.createRelationship(context, repositoryId, sourceId, targetId, policyIds, extension);
        checkReadAccess(repositoryId, context.getUsername(), sos[0]);
        checkReadAccess(repositoryId, context.getUsername(), sos[1]);
        return sos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #createPolicy(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject createPolicy(CallContext context, String repositoryId, String folderId, Acl addAces,
            Acl removeAces, List<String> policyIds, ExtensionsData extension) {

        if (policyIds != null && policyIds.size() > 0) {
            throw new CmisConstraintException("Applying policies to policies is not supported.");
        }
        if (folderId != null && folderId.length() > 0) {
            throw new CmisConstraintException("Policies cannot be created in folders.");
        }
        if (addAces != null || removeAces != null) {
            throw new CmisConstraintException("ACLs on policies are not suported.");
        }

        super.createPolicy(context, repositoryId, null, null, null, null, extension);
        return null;
    }

    @Override
    public StoredObject createItem(CallContext context, String repositoryId, Properties properties, String folderId,
            List<String> policyIds, Acl addAces, Acl removeAces, ExtensionsData extension) {
        StoredObject folder = super.createItem(context, repositoryId, properties, folderId, policyIds, addAces,
                removeAces, extension);
        if (null != folder) {
            checkWriteAccess(repositoryId, context.getUsername(), folder);
        }
        return folder;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getAllowableActions
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getAllowableActions(CallContext context, String repositoryId, String objectId,
            ExtensionsData extension) {

        StoredObject so = super.getAllowableActions(context, repositoryId, objectId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getObject(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getObject(CallContext context, String repositoryId, String objectId, ExtensionsData extension) {

        StoredObject so = super.getObject(context, repositoryId, objectId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getProperties(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getProperties(CallContext context, String repositoryId, String objectId,
            ExtensionsData extension) {

        StoredObject so = super.getProperties(context, repositoryId, objectId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getRenditions(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getRenditions(CallContext context, String repositoryId, String objectId,
            ExtensionsData extension) {

        StoredObject so = super.getRenditions(context, repositoryId, objectId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getObjectByPath
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getObjectByPath(CallContext context, String repositoryId, String path, 
            ExtensionsData extension) {

        StoredObject so = super.getObjectByPath(context, repositoryId, path, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getContentStream
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getContentStream(CallContext context, String repositoryId, String objectId, String streamId,
            ExtensionsData extension) {

        StoredObject so = super.getContentStream(context, repositoryId, objectId, streamId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #updateProperties
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, gov.opm.opis.chemistry.opencmis.commons.spi.Holder,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject updateProperties(CallContext context, String repositoryId, Holder<String> objectId,
            ExtensionsData extension) {

        StoredObject so = super.updateProperties(context, repositoryId, objectId, extension);
        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #moveObject(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, gov.opm.opis.chemistry.opencmis.commons.spi.Holder,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject[] moveObject(CallContext context, String repositoryId, Holder<String> objectId,
            String targetFolderId, String sourceFolderId, ExtensionsData extension) {

        StoredObject[] sos = super.moveObject(context, repositoryId, objectId, targetFolderId, sourceFolderId,
                extension);
        checkReadAccess(repositoryId, context.getUsername(), sos[0]);
        checkReadAccess(repositoryId, context.getUsername(), sos[1]);
        checkWriteAccess(repositoryId, context.getUsername(), sos[2]);
        return sos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #deleteObject(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.Boolean,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject deleteObject(CallContext context, String repositoryId, String objectId, Boolean allVersions,
            ExtensionsData extension) {

        StoredObject so = super.deleteObject(context, repositoryId, objectId, allVersions, extension);
        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #deleteTree(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.Boolean,
     * gov.opm.opis.chemistry.opencmis.commons.enums.UnfileObject,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject deleteTree(CallContext context, String repositoryId, String folderId, Boolean allVersions,
            UnfileObject unfileObjects, ExtensionsData extension) {

        StoredObject so = super.deleteTree(context, repositoryId, folderId, allVersions, unfileObjects, extension);
        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #setContentStream
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, gov.opm.opis.chemistry.opencmis.commons.spi.Holder,
     * java.lang.Boolean,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject setContentStream(CallContext context, String repositoryId, Holder<String> objectId,
            Boolean overwriteFlag, ExtensionsData extension) {

        StoredObject so = super.setContentStream(context, repositoryId, objectId, overwriteFlag, extension);
        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #deleteContentStream
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, gov.opm.opis.chemistry.opencmis.commons.spi.Holder,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject deleteContentStream(CallContext context, String repositoryId, Holder<String> objectId,
            ExtensionsData extension) {

        StoredObject so = super.deleteContentStream(context, repositoryId, objectId, extension);
        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #checkOut(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, gov.opm.opis.chemistry.opencmis.commons.spi.Holder,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData,
     * gov.opm.opis.chemistry.opencmis.commons.spi.Holder)
     */
    @Override
    public StoredObject checkOut(CallContext context, String repositoryId, Holder<String> objectId,
            ExtensionsData extension, Holder<Boolean> contentCopied) {

        StoredObject so = super.checkOut(context, repositoryId, objectId, extension, contentCopied);
        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #cancelCheckOut(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject cancelCheckOut(CallContext context, String repositoryId, String objectId,
            ExtensionsData extension) {

        StoredObject so = super.cancelCheckOut(context, repositoryId, objectId, extension);
        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #checkIn(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, gov.opm.opis.chemistry.opencmis.commons.spi.Holder,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject checkIn(CallContext context, String repositoryId, Holder<String> objectId, Acl addAces,
            Acl removeAces, List<String> policyIds, ExtensionsData extension) {

        StoredObject so = super.checkIn(context, repositoryId, objectId, addAces, removeAces, policyIds, extension);

        if (null != addAces || null != removeAces) {
            throw new CmisInvalidArgumentException(
                    "version specific ACLs are not supported, addAces and removeAces must be null.");
        }

        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getObjectOfLatestVersion
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getObjectOfLatestVersion(CallContext context, String repositoryId, String objectId,
            String versionSeriesId, ExtensionsData extension) {

        StoredObject so = super.getObjectOfLatestVersion(context, repositoryId, objectId, versionSeriesId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getPropertiesOfLatestVersion
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getPropertiesOfLatestVersion(CallContext context, String repositoryId, String objectId,
            String versionSeriesId, ExtensionsData extension) {

        StoredObject so = super.getPropertiesOfLatestVersion(context, repositoryId, objectId, versionSeriesId,
                extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getAllVersions(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getAllVersions(CallContext context, String repositoryId, String objectId,
            String versionSeriesId, ExtensionsData extension) {

        StoredObject so = super.getAllVersions(context, repositoryId, objectId, versionSeriesId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #query(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public void query(CallContext context, String repositoryId, ExtensionsData extension) {

        super.query(context, repositoryId, extension);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getContentChanges
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public void getContentChanges(CallContext context, String repositoryId, ExtensionsData extension) {

        super.getContentChanges(context, repositoryId, extension);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #addObjectToFolder
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject[] addObjectToFolder(CallContext context, String repositoryId, String objectId, String folderId,
            Boolean allVersions, ExtensionsData extension) {

        StoredObject[] sos = super.addObjectToFolder(context, repositoryId, objectId, folderId, allVersions, extension);
        checkReadAccess(repositoryId, context.getUsername(), sos[0]);
        checkWriteAccess(repositoryId, context.getUsername(), sos[1]);
        return sos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #removeObjectFromFolder
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject[] removeObjectFromFolder(CallContext context, String repositoryId, String objectId,
            String folderId, ExtensionsData extension) {

        StoredObject[] sos = super.removeObjectFromFolder(context, repositoryId, objectId, folderId, extension);
        checkWriteAccess(repositoryId, context.getUsername(), sos[0]);
        if (null != folderId) {
            checkWriteAccess(repositoryId, context.getUsername(), sos[1]);
        }
        return sos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getObjectRelationships
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.enums.RelationshipDirection,
     * java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getObjectRelationships(CallContext context, String repositoryId, String objectId,
            RelationshipDirection relationshipDirection, String typeId, ExtensionsData extension) {

        StoredObject so = super.getObjectRelationships(context, repositoryId, objectId, relationshipDirection, typeId,
                extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getAcl(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getAcl(CallContext context, String repositoryId, String objectId, ExtensionsData extension) {

        StoredObject so = super.getAcl(context, repositoryId, objectId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #applyAcl(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.enums.AclPropagation,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject applyAcl(CallContext context, String repositoryId, String objectId,
            AclPropagation aclPropagation, ExtensionsData extension) {

        StoredObject so = super.applyAcl(context, repositoryId, objectId, aclPropagation, extension);
        checkAllAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #applyPolicy(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject[] applyPolicy(CallContext context, String repositoryId, String policyId, String objectId,
            ExtensionsData extension) {

        StoredObject[] sos = super.applyPolicy(context, repositoryId, policyId, objectId, extension);
        if (!(sos[0] instanceof Policy)) {
            throw new CmisInvalidArgumentException("applyPolicy failed, " + policyId + " is not a policy id");
        }
        if (sos[1] instanceof Policy) {
            throw new CmisInvalidArgumentException("applyPolicy failed, " + objectId
                    + " is a policy id. Applying policies to policies is not supported.");
        }
        checkAllAccess(repositoryId, context.getUsername(), sos[1]);
        return sos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #removePolicy(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject[] removePolicy(CallContext context, String repositoryId, String policyId, String objectId,
            ExtensionsData extension) {

        StoredObject[] sos = super.removePolicy(context, repositoryId, policyId, objectId, extension);
        checkAllAccess(repositoryId, context.getUsername(), sos[1]);
        return sos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #getAppliedPolicies
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject getAppliedPolicies(CallContext context, String repositoryId, String objectId,
            ExtensionsData extension) {

        StoredObject so = super.getAppliedPolicies(context, repositoryId, objectId, extension);
        checkReadAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #create(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject create(CallContext context, String repositoryId, String folderId, ExtensionsData extension) {

        StoredObject so = super.create(context, repositoryId, folderId, extension);
        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #deleteObjectOrCancelCheckOut
     * (gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String,
     * gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData)
     */
    @Override
    public StoredObject deleteObjectOrCancelCheckOut(CallContext context, String repositoryId, String objectId,
            ExtensionsData extension) {

        StoredObject so = super.deleteObjectOrCancelCheckOut(context, repositoryId, objectId, extension);
        checkWriteAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * gov.opm.opis.chemistry.opencmis.inmemory.server.BaseServiceValidatorImpl
     * #applyAcl(gov.opm.opis.chemistry.opencmis.commons.server.CallContext,
     * java.lang.String, java.lang.String)
     */
    @Override
    public StoredObject applyAcl(CallContext context, String repositoryId, String objectId) {

        StoredObject so = super.applyAcl(context, repositoryId, objectId);
        checkAllAccess(repositoryId, context.getUsername(), so);
        return so;
    }

    @Override
    public void createType(CallContext callContext, String repositoryId, TypeDefinition type, ExtensionsData extension) {
        super.createType(callContext, repositoryId, type, extension);
    }

    @Override
    public TypeDefinition updateType(CallContext callContext, String repositoryId, TypeDefinition type,
            ExtensionsData extension) {
        throw new CmisNotSupportedException("Updating a type definition is not supported.");
    }

    @Override
    public TypeDefinition deleteType(CallContext callContext, String repositoryId, String typeId,
            ExtensionsData extension) {
        return super.deleteType(callContext, repositoryId, typeId, extension);
    }

    private ObjectStoreImpl getObjectStore(String repositoryId) {
        return (ObjectStoreImpl) fStoreManager.getObjectStore(repositoryId);
    }

    private void checkReadAccess(String repositoryId, String principalId, StoredObject so) {
        getObjectStore(repositoryId).checkReadAccess(principalId, so);
    }

    private void checkWriteAccess(String repositoryId, String principalId, StoredObject so) {
        getObjectStore(repositoryId).checkWriteAccess(principalId, so);
    }

    private void checkAllAccess(String repositoryId, String principalId, StoredObject so) {
        getObjectStore(repositoryId).checkAllAccess(principalId, so);
    }

}
