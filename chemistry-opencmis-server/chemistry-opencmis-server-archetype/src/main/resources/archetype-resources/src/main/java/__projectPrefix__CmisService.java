#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import gov.opm.opis.chemistry.opencmis.commons.data.ExtensionsData;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectData;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectInFolderList;
import gov.opm.opis.chemistry.opencmis.commons.data.ObjectParentData;
import gov.opm.opis.chemistry.opencmis.commons.data.RepositoryInfo;
import gov.opm.opis.chemistry.opencmis.commons.definitions.TypeDefinition;
import gov.opm.opis.chemistry.opencmis.commons.definitions.TypeDefinitionList;
import gov.opm.opis.chemistry.opencmis.commons.enums.CapabilityAcl;
import gov.opm.opis.chemistry.opencmis.commons.enums.CapabilityChanges;
import gov.opm.opis.chemistry.opencmis.commons.enums.CapabilityContentStreamUpdates;
import gov.opm.opis.chemistry.opencmis.commons.enums.CapabilityJoin;
import gov.opm.opis.chemistry.opencmis.commons.enums.CapabilityQuery;
import gov.opm.opis.chemistry.opencmis.commons.enums.CapabilityRenditions;
import gov.opm.opis.chemistry.opencmis.commons.enums.IncludeRelationships;
import gov.opm.opis.chemistry.opencmis.commons.impl.dataobjects.RepositoryCapabilitiesImpl;
import gov.opm.opis.chemistry.opencmis.commons.impl.dataobjects.RepositoryInfoImpl;
import gov.opm.opis.chemistry.opencmis.commons.impl.server.AbstractCmisService;
import gov.opm.opis.chemistry.opencmis.commons.server.CallContext;
import gov.opm.opis.chemistry.opencmis.server.support.wrapper.CallContextAwareCmisService;

/**
 * CMIS Service Implementation.
 */
public class ${projectPrefix}CmisService extends AbstractCmisService implements CallContextAwareCmisService {

    private CallContext context;

    // --- Call Context ---

    /**
     * Sets the call context.
     * 
     * This method should only be called by the service factory.
     */
    public void setCallContext(CallContext context) {
        this.context = context;
    }

    /**
     * Gets the call context.
     */
    public CallContext getCallContext() {
        return context;
    }

    // --- CMIS Operations ---

    @Override
    public List<RepositoryInfo> getRepositoryInfos(ExtensionsData extension) {
        // very basic repository info set up
        RepositoryInfoImpl repositoryInfo = new RepositoryInfoImpl();

        repositoryInfo.setId("repository1");
        repositoryInfo.setName("${projectPrefix}");
        repositoryInfo.setDescription("This is my first repository!");

        repositoryInfo.setCmisVersionSupported("1.0");

        repositoryInfo.setProductName("My Document Management System");
        repositoryInfo.setProductVersion("0.1");
        repositoryInfo.setVendorName("My Company");

        repositoryInfo.setRootFolder("1234567890");

        repositoryInfo.setThinClientUri("");

        RepositoryCapabilitiesImpl capabilities = new RepositoryCapabilitiesImpl();
        capabilities.setCapabilityAcl(CapabilityAcl.NONE);
        capabilities.setAllVersionsSearchable(false);
        capabilities.setCapabilityJoin(CapabilityJoin.NONE);
        capabilities.setSupportsMultifiling(false);
        capabilities.setSupportsUnfiling(false);
        capabilities.setSupportsVersionSpecificFiling(false);
        capabilities.setIsPwcSearchable(false);
        capabilities.setIsPwcUpdatable(false);
        capabilities.setCapabilityQuery(CapabilityQuery.NONE);
        capabilities.setCapabilityChanges(CapabilityChanges.NONE);
        capabilities.setCapabilityContentStreamUpdates(CapabilityContentStreamUpdates.ANYTIME);
        capabilities.setSupportsGetDescendants(true);
        capabilities.setSupportsGetFolderTree(true);
        capabilities.setCapabilityRendition(CapabilityRenditions.NONE);

        return Collections.singletonList((RepositoryInfo) repositoryInfo);
    }

    @Override
    public TypeDefinitionList getTypeChildren(String repositoryId, String typeId, Boolean includePropertyDefinitions,
            BigInteger maxItems, BigInteger skipCount, ExtensionsData extension) {
        // TODO implement
        return null;
    }

    @Override
    public TypeDefinition getTypeDefinition(String repositoryId, String typeId, ExtensionsData extension) {
        // TODO implement
        return null;
    }

    @Override
    public ObjectInFolderList getChildren(String repositoryId, String folderId, String filter, String orderBy,
            Boolean includeAllowableActions, IncludeRelationships includeRelationships, String renditionFilter,
            Boolean includePathSegment, BigInteger maxItems, BigInteger skipCount, ExtensionsData extension) {
        // TODO implement
        return null;
    }

    @Override
    public List<ObjectParentData> getObjectParents(String repositoryId, String objectId, String filter,
            Boolean includeAllowableActions, IncludeRelationships includeRelationships, String renditionFilter,
            Boolean includeRelativePathSegment, ExtensionsData extension) {
        // TODO implement
        return null;
    }

    @Override
    public ObjectData getObject(String repositoryId, String objectId, String filter, Boolean includeAllowableActions,
            IncludeRelationships includeRelationships, String renditionFilter, Boolean includePolicyIds,
            Boolean includeAcl, ExtensionsData extension) {
        // TODO implement
        return null;
    }

}
