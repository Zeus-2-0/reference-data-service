package com.brihaspathee.zeus.service.interfaces;

import com.brihaspathee.zeus.web.model.InternalRefData;
import com.brihaspathee.zeus.web.request.InternalRefDataRequest;
import com.brihaspathee.zeus.web.response.InternalRefDataResponse;

import java.util.List;

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

    InternalRefDataResponse validateReferenceData(InternalRefDataRequest internalRefDataRequest);
    List<InternalRefData> getInternalRefDataCodesByListType(String listTypeName);
}
