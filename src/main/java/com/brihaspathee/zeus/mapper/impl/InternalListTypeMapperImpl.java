package com.brihaspathee.zeus.mapper.impl;

import com.brihaspathee.zeus.domain.entity.InternalListType;
import com.brihaspathee.zeus.mapper.interfaces.InternalListTypeMapper;
import com.brihaspathee.zeus.mapper.interfaces.InternalRefDataMapper;
import com.brihaspathee.zeus.web.model.InternalListTypeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, July 2022
 * Time: 7:36 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class InternalListTypeMapperImpl implements InternalListTypeMapper {

    /**
     * Maps the internal list detail to internal ref data mapper object and vice versa
     */
    private final InternalRefDataMapper internalRefDataMapper;

    /**
     * The internal list type dto object is converted to internal list type
     * @param internalListTypeDto
     * @return
     */
    @Override
    public InternalListType internalListTypeDtoToInternalListType(InternalListTypeDto internalListTypeDto) {
        if(internalListTypeDto == null){
            return null;
        }
        InternalListType internalListType = InternalListType.builder()
                .internalListTypeSK(internalListTypeDto.getInternalListTypeSK())
                .internalListTypeName(internalListTypeDto.getInternalListTypeName())
                .internalListTypeDesc(internalListTypeDto.getInternalListTypeDesc())
                .build();
        if (internalListTypeDto.getInternalRefDataList() != null &&
            !internalListTypeDto.getInternalRefDataList().isEmpty()){
            internalListType.setInternalListDetails(internalRefDataMapper.mapInternalListDetails(internalListTypeDto.getInternalRefDataList()));
        }
        return internalListType;
    }

    /**
     * The internal list type object is converted to internal list type dto
     * @param internalListType
     * @return
     */
    @Override
    public InternalListTypeDto internalListTypeToInternalListTypeDto(InternalListType internalListType) {
        if(internalListType == null){
            return null;
        }
        InternalListTypeDto internalListTypeDto = InternalListTypeDto.builder()
                .internalListTypeSK(internalListType.getInternalListTypeSK())
                .internalListTypeName(internalListType.getInternalListTypeName())
                .internalListTypeDesc(internalListType.getInternalListTypeDesc())
                .build();
        if (internalListType.getInternalListDetails() != null &&
                !internalListType.getInternalListDetails().isEmpty()){
            internalListTypeDto.setInternalRefDataList(internalRefDataMapper.mapInternalRefDataList(internalListType.getInternalListDetails()));
        }
        return internalListTypeDto;
    }

    /**
     * The internal list type dtos are converted to internal list types
     * @param internalListTypeDtos
     * @return
     */
    @Override
    public List<InternalListType> internalListTypeDtosToInternalListTypes(List<InternalListTypeDto> internalListTypeDtos) {
        return internalListTypeDtos.stream().map(this::internalListTypeDtoToInternalListType).collect(Collectors.toList());
    }

    /**
     * The internal list types are converted to internal list type dtos
     * @param internalListTypes
     * @return
     */
    @Override
    public List<InternalListTypeDto> internalListTypesToInternalListTypeDtos(List<InternalListType> internalListTypes) {
        return internalListTypes.stream().map(this::internalListTypeToInternalListTypeDto).collect(Collectors.toList());
    }
}
