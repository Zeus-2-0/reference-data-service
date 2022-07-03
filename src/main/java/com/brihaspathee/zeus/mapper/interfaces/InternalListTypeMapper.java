package com.brihaspathee.zeus.mapper.interfaces;

import com.brihaspathee.zeus.domain.entity.InternalListType;
import com.brihaspathee.zeus.web.model.InternalListTypeDto;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, July 2022
 * Time: 7:32 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface InternalListTypeMapper {

    /**
     * The internal list type dto object is converted to internal list type
     * @param internalListTypeDto
     * @return
     */
    InternalListType internalListTypeDtoToInternalListType(InternalListTypeDto internalListTypeDto);

    /**
     * The internal list type object is converted to internal list type dto
     * @param internalListType
     * @return
     */
    InternalListTypeDto internalListTypeToInternalListTypeDto(InternalListType internalListType);

    /**
     * The internal list type dtos are converted to internal list types
     * @param internalListTypeDtos
     * @return
     */
    List<InternalListType> internalListTypeDtosToInternalListTypes(List<InternalListTypeDto> internalListTypeDtos);

    /**
     * The internal list types are converted to internal list type dtos
     * @param internalListTypes
     * @return
     */
    List<InternalListTypeDto> internalListTypesToInternalListTypeDtos(List<InternalListType> internalListTypes);
}
