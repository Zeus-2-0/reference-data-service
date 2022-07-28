package com.brihaspathee.zeus.service.interfaces;

import com.brihaspathee.zeus.reference.data.model.InternalListTypeDto;
import com.brihaspathee.zeus.web.request.InternalRefDataRequest;
import com.brihaspathee.zeus.web.response.InternalRefDataResponse;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 2:08 PM
 * Project: Zeus
 * Package Name: com.zeus.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface InternalRefDataService {

    /**
     * Validates if the internal codes provided in the request are valid or not
     * @param internalRefDataRequest
     * @return
     */
    InternalRefDataResponse validateReferenceData(InternalRefDataRequest internalRefDataRequest);
    /**
     * Gets all the internal code for the internal list type provided if one exists
     * @param listTypeName
     * @return
     */
    InternalListTypeDto getInternalRefDataCodesByListType(String listTypeName);
}
