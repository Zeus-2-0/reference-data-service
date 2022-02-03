package com.brihaspathee.zeus.service.impl;

import com.brihaspathee.zeus.domain.entity.InternalListDetail;
import com.brihaspathee.zeus.domain.entity.InternalListType;
import com.brihaspathee.zeus.exception.InternalListTypeNotFoundException;
import com.brihaspathee.zeus.domain.repository.InternalListTypeRepository;
import com.brihaspathee.zeus.mapper.interfaces.InternalRefDataMapper;
import com.brihaspathee.zeus.service.interfaces.InternalRefDataService;
import com.brihaspathee.zeus.web.model.InternalRefData;
import com.brihaspathee.zeus.web.request.InternalRefDataRequest;
import com.brihaspathee.zeus.web.response.InternalRefDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 2:15 PM
 * Project: Zeus
 * Package Name: com.zeus.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Service
@RequiredArgsConstructor
public class InternalRefDataServiceImpl implements InternalRefDataService {

    private final InternalListTypeRepository typeRepository;

    private final InternalRefDataMapper internalRefDataMapper;

    @Override
    public InternalRefDataResponse validateReferenceData(InternalRefDataRequest internalRefDataRequest) {
        Optional<InternalListType> internalListType = typeRepository.findInternalListTypeByInternalListTypeName(internalRefDataRequest.getInternalListTypeName());
        if(internalListType.isEmpty()){
            throw new InternalListTypeNotFoundException("An internal list type with name " + internalRefDataRequest.getInternalListTypeName() + " is not found");
        }else{
            InternalListType listType = internalListType.get();
            boolean isValid = listType.getInternalListDetails().stream().anyMatch(internalListDetail -> {
               return internalListDetail.getInternalListCode().equals(internalRefDataRequest.getInternalListCode());
            });
            return InternalRefDataResponse.builder()
                    .internalListCode(internalRefDataRequest.getInternalListCode())
                    .internalListTypeName(internalRefDataRequest.getInternalListTypeName())
                    .valid(isValid)
                    .build();
        }
    }

    @Override
    public List<InternalRefData> getInternalRefDataCodesByListType(String listTypeName) {
        Optional<InternalListType> optionalInternalListType = typeRepository.findInternalListTypeByInternalListTypeName(listTypeName);
        if(optionalInternalListType.isEmpty()){
            throw new InternalListTypeNotFoundException("An internal list type with name " + listTypeName + " is not found");
        }else{
            InternalListType internalListType = optionalInternalListType.get();
            List<InternalListDetail> internalListDetails = internalListType.getInternalListDetails();
            return  internalRefDataMapper.mapInternalRefDataList(internalListDetails);
        }
    }
}
