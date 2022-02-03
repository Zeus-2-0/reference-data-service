package com.brihaspathee.zeus.mapper.impl;

import com.brihaspathee.zeus.domain.entity.InternalListDetail;
import com.brihaspathee.zeus.web.model.InternalRefData;
import com.brihaspathee.zeus.mapper.interfaces.InternalRefDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, January 2022
 * Time: 4:00 PM
 * Project: Zeus
 * Package Name: com.zeus.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
public class InternalRefDataMapperImpl implements InternalRefDataMapper {
    @Override
    public InternalRefData mapInternalRefData(InternalListDetail internalListDetail) {

        if(internalListDetail == null){
            return null;
        }
        InternalRefData internalRefData = InternalRefData.builder()
                .listTypeName(internalListDetail.getInternalListType().getInternalListTypeName())
                .listCode(internalListDetail.getInternalListCode())
                .listCodeDesc(internalListDetail.getInternalListCodeDesc())
                .build();
        return internalRefData;
    }

    @Override
    public List<InternalRefData> mapInternalRefDataList(List<InternalListDetail> internalListDetails) {
        return internalListDetails.stream().map(this::mapInternalRefData).collect(Collectors.toList());
    }
}
