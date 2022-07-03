package com.brihaspathee.zeus.mapper.interfaces;

import com.brihaspathee.zeus.domain.entity.InternalListDetail;
import com.brihaspathee.zeus.web.model.InternalRefData;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, January 2022
 * Time: 3:57 PM
 * Project: Zeus
 * Package Name: com.zeus.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface InternalRefDataMapper {

    /**
     * Map the internal list detail to internal ref data
     * @param internalListDetail
     * @return
     */
    InternalRefData mapInternalRefData(InternalListDetail internalListDetail);

    /**
     * Map the internal ref data to internal list detail
     * @param internalRefData
     * @return
     */
    InternalListDetail mapInternalListDetail(InternalRefData internalRefData);

    /**
     * Maps the list of internal list details to internal ref data list
     * @param internalListDetails
     * @return
     */
    List<InternalRefData> mapInternalRefDataList(List<InternalListDetail> internalListDetails);

    /**
     * Maps the list of internal ref data list to internal list details
     * @param internalRefDataList
     * @return
     */
    List<InternalListDetail> mapInternalListDetails(List<InternalRefData> internalRefDataList);
}
