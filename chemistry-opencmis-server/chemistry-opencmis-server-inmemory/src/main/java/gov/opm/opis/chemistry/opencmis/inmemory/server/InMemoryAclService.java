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
package gov.opm.opis.chemistry.opencmis.inmemory.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.opm.opis.chemistry.opencmis.commons.data.Acl;
import gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData;
import gov.opm.opis.chemistry.opencmis.commons.enums.AclPropagation;
import gov.opm.opis.chemistry.opencmis.commons.impl.server.ObjectInfoImpl;
import gov.opm.opis.chemistry.opencmis.commons.server.CallContext;
import gov.opm.opis.chemistry.opencmis.commons.server.ObjectInfoHandler;
import gov.opm.opis.chemistry.opencmis.inmemory.TypeValidator;
import gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api.DocumentVersion;
import gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api.ObjectStore;
import gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api.StoreManager;
import gov.opm.opis.chemistry.opencmis.inmemory.storedobj.api.StoredObject;

public class InMemoryAclService extends InMemoryAbstractServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(InMemoryAclService.class.getName());

    public InMemoryAclService(StoreManager storeManager) {
        super(storeManager);
    }

    public Acl getAcl(CallContext context, String repositoryId, String objectId, Boolean onlyBasicPermissions,
            ExtensionsData extension, ObjectInfoHandler objectInfos) {
        LOG.debug("start getAcl()");
        int aclId;
        StoredObject so = validator.getAcl(context, repositoryId, objectId, extension);
        ObjectStore objectStore = fStoreManager.getObjectStore(repositoryId);
        if (so instanceof DocumentVersion) {
            aclId = ((DocumentVersion) so).getParentDocument().getAclId();
        } else {
            aclId = so.getAclId();
        }

        Acl acl = objectStore.getAcl(aclId);

        if (context.isObjectInfoRequired()) {
            ObjectInfoImpl objectInfo = new ObjectInfoImpl();
            fAtomLinkProvider.fillInformationForAtomLinks(context, repositoryId, so, objectInfo);
            objectInfos.addObjectInfo(objectInfo);
        }

        return acl;
    }

    public Acl applyAcl(CallContext context, String repositoryId, String objectId, Acl aclAdd, Acl aclRemove,
            AclPropagation aclPropagation, ExtensionsData extension, ObjectInfoHandler objectInfos) {

        Acl addAces = TypeValidator.expandAclMakros(context.getUsername(), aclAdd);
        Acl removeAces = TypeValidator.expandAclMakros(context.getUsername(), aclRemove);

        StoredObject so = validator.applyAcl(context, repositoryId, objectId, aclPropagation, extension);
        Acl acl = fStoreManager.getObjectStore(repositoryId).applyAcl(so, addAces, removeAces, aclPropagation,
                context.getUsername());

        if (context.isObjectInfoRequired()) {
            ObjectInfoImpl objectInfo = new ObjectInfoImpl();
            fAtomLinkProvider.fillInformationForAtomLinks(context, repositoryId, so, objectInfo);
            objectInfos.addObjectInfo(objectInfo);
        }
        return acl;
    }

    public Acl applyAcl(CallContext context, String repositoryId, String objectId, Acl acesParam,
            AclPropagation aclPropagation) {

        Acl aces = TypeValidator.expandAclMakros(context.getUsername(), acesParam);

        StoredObject so = validator.applyAcl(context, repositoryId, objectId);
        return fStoreManager.getObjectStore(repositoryId).applyAcl(so, aces, aclPropagation, context.getUsername());
    }

}
