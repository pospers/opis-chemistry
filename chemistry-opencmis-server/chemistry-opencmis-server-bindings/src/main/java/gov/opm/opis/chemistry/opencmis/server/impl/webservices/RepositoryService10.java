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

import java.math.BigInteger;

import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisException;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisExtensionType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisFaultType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.CmisTypeDefinitionType;
import gov.opm.opis.chemistry.opencmis.commons.impl.jaxb.EnumServiceException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.Holder;
import jakarta.xml.ws.soap.MTOM;

/**
 * CMIS 1.0 Repository Service. Excludes CMIS 1.1 operations.
 */
@MTOM
@WebService(endpointInterface = "gov.opm.opis.chemistry.opencmis.server.impl.webservices.RepositoryServicePort10")
public class RepositoryService10 extends RepositoryService implements RepositoryServicePort10 {

    @Override
    @WebMethod(exclude = true)
    public void createType(String repositoryId, Holder<CmisTypeDefinitionType> type, CmisExtensionType extension)
            throws CmisException {
        CmisFaultType fault = new CmisFaultType();
        fault.setCode(BigInteger.ZERO);
        fault.setMessage("This is a CMIS 1.0 endpoint.");
        fault.setType(EnumServiceException.NOT_SUPPORTED);

        throw new CmisException(fault.getMessage(), fault);
    }

    @Override
    @WebMethod(exclude = true)
    public void updateType(String repositoryId, Holder<CmisTypeDefinitionType> type, CmisExtensionType extension)
            throws CmisException {
        CmisFaultType fault = new CmisFaultType();
        fault.setCode(BigInteger.ZERO);
        fault.setMessage("This is a CMIS 1.0 endpoint.");
        fault.setType(EnumServiceException.NOT_SUPPORTED);

        throw new CmisException(fault.getMessage(), fault);
    }

    @Override
    @WebMethod(exclude = true)
    public void deleteType(String repositoryId, String typeId, Holder<CmisExtensionType> extension)
            throws CmisException {
        CmisFaultType fault = new CmisFaultType();
        fault.setCode(BigInteger.ZERO);
        fault.setMessage("This is a CMIS 1.0 endpoint.");
        fault.setType(EnumServiceException.NOT_SUPPORTED);

        throw new CmisException(fault.getMessage(), fault);
    }
}
