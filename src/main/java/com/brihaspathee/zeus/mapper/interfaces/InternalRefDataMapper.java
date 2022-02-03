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

    InternalRefData mapInternalRefData(InternalListDetail internalListDetail);

    List<InternalRefData> mapInternalRefDataList(List<InternalListDetail> internalListDetails);
}
