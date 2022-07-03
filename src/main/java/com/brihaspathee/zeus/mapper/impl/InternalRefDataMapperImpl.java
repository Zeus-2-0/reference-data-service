package com.brihaspathee.zeus.mapper.impl;

import com.brihaspathee.zeus.domain.entity.InternalListDetail;
import com.brihaspathee.zeus.domain.entity.InternalListType;
import com.brihaspathee.zeus.web.model.InternalListTypeDto;
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

    /**
     * Map the internal list detail to internal ref data
     * @param internalListDetail
     * @return
     */
    @Override
    public InternalRefData mapInternalRefData(InternalListDetail internalListDetail) {

        if(internalListDetail == null){
            return null;
        }
        InternalRefData internalRefData = InternalRefData.builder()
                .listTypeDto(InternalListTypeDto.builder()
                        .internalListTypeName(internalListDetail.getInternalListType().getInternalListTypeName())
                        .internalListTypeDesc(internalListDetail.getInternalListType().getInternalListTypeDesc())
                        .build())
                .listCode(internalListDetail.getInternalListCode())
                .listCodeDesc(internalListDetail.getInternalListCodeDesc())
                .build();
        return internalRefData;
    }

    /**
     * Map the internal ref data to internal list detail
     * @param internalRefData
     * @return
     */
    @Override
    public InternalListDetail mapInternalListDetail(InternalRefData internalRefData) {
        if(internalRefData == null){
            return null;
        }
        InternalListDetail internalListDetail = InternalListDetail.builder()
                .internalListCode(internalRefData.getListCode())
                .internalListCodeDesc(internalRefData.getListCodeDesc())
                .internalListType(InternalListType.builder()
                        .internalListTypeName(internalRefData.getListTypeDto().getInternalListTypeName())
                        .internalListTypeDesc(internalRefData.getListTypeDto().getInternalListTypeDesc())
                        .build())
                .build();
        return internalListDetail;
    }

    /**
     * Maps the list of internal list details to internal ref data list
     * @param internalListDetails
     * @return
     */
    @Override
    public List<InternalRefData> mapInternalRefDataList(List<InternalListDetail> internalListDetails) {
        return internalListDetails.stream().map(this::mapInternalRefData).collect(Collectors.toList());
    }

    /**
     * Maps the list of internal ref data list to internal list details
     * @param internalRefDataList
     * @return
     */
    @Override
    public List<InternalListDetail> mapInternalListDetails(List<InternalRefData> internalRefDataList) {
        return internalRefDataList.stream().map(this::mapInternalListDetail).collect(Collectors.toList());
    }
}
