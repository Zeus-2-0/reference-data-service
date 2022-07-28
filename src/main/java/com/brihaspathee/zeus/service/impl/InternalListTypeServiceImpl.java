package com.brihaspathee.zeus.service.impl;

import com.brihaspathee.zeus.domain.entity.InternalListType;
import com.brihaspathee.zeus.domain.repository.InternalListTypeRepository;
import com.brihaspathee.zeus.mapper.interfaces.InternalListTypeMapper;
import com.brihaspathee.zeus.reference.data.model.InternalListTypesDto;
import com.brihaspathee.zeus.service.interfaces.InternalListTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, July 2022
 * Time: 8:04 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class InternalListTypeServiceImpl implements InternalListTypeService {

    /**
     * Repository to perform CRUD operations on internal list type
     */
    private final InternalListTypeRepository internalListTypeRepository;

    /**
     * Mapper object to convert the entity to dto and vice verso
     */
    private final InternalListTypeMapper internalListTypeMapper;

    /**
     * Returns all the internal list types
     * @return
     */
    @Override
    public InternalListTypesDto getAllInternalListTypes() {
        List<InternalListType> listTypes = internalListTypeRepository.findAll();
        return InternalListTypesDto.builder()
                .internalListTypes(internalListTypeMapper.internalListTypesToInternalListTypeDtos(listTypes))
                .build();
    }
}
