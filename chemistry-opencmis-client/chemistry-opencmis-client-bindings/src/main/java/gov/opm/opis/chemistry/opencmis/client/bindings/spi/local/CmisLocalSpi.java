/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package gov.opm.opis.chemistry.opencmis.client.bindings.spi.local;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.opm.opis.chemistry.opencmis.client.bindings.spi.BindingSession;
import gov.opm.opis.chemistry.opencmis.client.bindings.spi.CmisSpi;
import gov.opm.opis.chemistry.opencmis.commons.SessionParameter;
import gov.opm.opis.chemistry.opencmis.commons.exceptions.CmisConnectionException;
import gov.opm.opis.chemistry.opencmis.commons.impl.ClassLoaderUtil;
import gov.opm.opis.chemistry.opencmis.commons.server.CmisServiceFactory;
import gov.opm.opis.chemistry.opencmis.commons.spi.AclService;
import gov.opm.opis.chemistry.opencmis.commons.spi.DiscoveryService;
import gov.opm.opis.chemistry.opencmis.commons.spi.MultiFilingService;
import gov.opm.opis.chemistry.opencmis.commons.spi.NavigationService;
import gov.opm.opis.chemistry.opencmis.commons.spi.ObjectService;
import gov.opm.opis.chemistry.opencmis.commons.spi.PolicyService;
import gov.opm.opis.chemistry.opencmis.commons.spi.RelationshipService;
import gov.opm.opis.chemistry.opencmis.commons.spi.RepositoryService;
import gov.opm.opis.chemistry.opencmis.commons.spi.VersioningService;

/**
 * * CMIS local SPI implementation.
 */
public class CmisLocalSpi implements CmisSpi {

    private static final Logger LOG = LoggerFactory.getLogger(CmisLocalSpi.class);

    private final CmisServiceFactory factory;

    private final RepositoryService repositoryService;
    private final NavigationService navigationService;
    private final ObjectService objectService;
    private final VersioningService versioningService;
    private final DiscoveryService discoveryService;
    private final MultiFilingService multiFilingService;
    private final RelationshipService relationshipService;
    private final PolicyService policyService;
    private final AclService aclService;

    /**
     * Constructor.
     */
    public CmisLocalSpi(BindingSession session) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Session {}: Initializing local SPI...", session.getSessionId());
        }

        // get the service factory class name
        String serviceFactoryClassname = (String) session.get(SessionParameter.LOCAL_FACTORY);
        if (serviceFactoryClassname == null) {
            throw new CmisConnectionException("Factory class not set!");
        }

        try {
            // gather parameters from session
            Map<String, String> parameters = new HashMap<String, String>();
            for (String key : session.getKeys()) {
                Object value = session.get(key);
                if (value instanceof String) {
                    parameters.put(key, (String) value);
                }
            }

            // create and initialize factory
            factory = (CmisServiceFactory) ClassLoaderUtil.loadClass(serviceFactoryClassname).getDeclaredConstructor()
                    .newInstance();
            factory.init(parameters);
        } catch (Exception e) {
            throw new CmisConnectionException("Factory cannot be created: " + e.getMessage(), e);
        }

        repositoryService = new RepositoryServiceImpl(session, factory);
        navigationService = new NavigationServiceImpl(session, factory);
        objectService = new ObjectServiceImpl(session, factory);
        versioningService = new VersioningServiceImpl(session, factory);
        discoveryService = new DiscoveryServiceImpl(session, factory);
        multiFilingService = new MultiFilingServiceImpl(session, factory);
        relationshipService = new RelationshipServiceImpl(session, factory);
        policyService = new PolicyServiceImpl(session, factory);
        aclService = new AclServiceImpl(session, factory);
    }

    @Override
    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    @Override
    public NavigationService getNavigationService() {
        return navigationService;
    }

    @Override
    public ObjectService getObjectService() {
        return objectService;
    }

    @Override
    public DiscoveryService getDiscoveryService() {
        return discoveryService;
    }

    @Override
    public VersioningService getVersioningService() {
        return versioningService;
    }

    @Override
    public MultiFilingService getMultiFilingService() {
        return multiFilingService;
    }

    @Override
    public RelationshipService getRelationshipService() {
        return relationshipService;
    }

    @Override
    public PolicyService getPolicyService() {
        return policyService;
    }

    @Override
    public AclService getAclService() {
        return aclService;
    }

    @Override
    public void clearAllCaches() {
    }

    @Override
    public void clearRepositoryCache(String repositoryId) {
    }

    @Override
    public void close() {
        factory.destroy();
    }
}
