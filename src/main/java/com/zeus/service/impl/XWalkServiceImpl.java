package com.zeus.service.impl;

import com.zeus.domain.entity.*;
import com.zeus.domain.exception.*;
import com.zeus.domain.repository.ExternalListTypeRepository;
import com.zeus.domain.repository.InternalListTypeRepository;
import com.zeus.service.interfaces.XWalkService;
import com.zeus.web.request.InternalXWalkRequest;
import com.zeus.web.response.XWalkResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 12:56 PM
 * Project: Zeus
 * Package Name: com.zeus.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class XWalkServiceImpl implements XWalkService {

    private final ExternalListTypeRepository externalListTypeRepository;

    @Override
    public XWalkResponse getInternalRefDataCode(InternalXWalkRequest internalXWalkRequest) {
        String externalListTypeName = internalXWalkRequest.getExternalListTypeName();
        String externalCode = internalXWalkRequest.getExternalListCode();
        String externalSourceName = internalXWalkRequest.getExternalSourceName();
        ExternalListType externalList = getExternalListType(externalListTypeName);
        validateExternalSource(externalSourceName, externalList);
        List<ExternalListDetail> externalListDetailList = externalList.getExternalListDetailList();
        ExternalListDetail externalListCode = validateAndReturnExternalCode(externalCode, externalListDetailList);
        List<ListDetailXWalk> detailXWalkList = externalListCode.getDetailXWalkList();
        log.info("Cross walk size: {}",detailXWalkList.size());
        return getxWalkResponse(internalXWalkRequest, externalListTypeName, externalCode, detailXWalkList);

    }

    private XWalkResponse getxWalkResponse(InternalXWalkRequest internalXWalkRequest, String externalListTypeName, String externalCode, List<ListDetailXWalk> detailXWalkList) {
        if(detailXWalkList.size() == 0){
            throw new NoMatchingInternalRefDataCodeException("There is no matching internal ref data code for external code " + externalCode);
        }else if(detailXWalkList.size() > 1){
            throw new MultipleInternalCodeMatchingException("There are multiple internal reference data code matching for external code " + externalCode);
        } else{
            ListDetailXWalk detailXWalk = detailXWalkList.get(0);
            InternalListDetail internalListDetail = detailXWalk.getInternalListDetail();
            return XWalkResponse.builder()
                    .externalListCode(externalCode)
                    .externalListTypeName(externalListTypeName)
                    .internalListCode(internalListDetail.getInternalListCode())
                    .internalListTypeName(internalListDetail.getInternalListType().getInternalListTypeName())
                    .externalSourceName(internalXWalkRequest.getExternalSourceName())
                    .build();
        }
    }

    private ExternalListDetail validateAndReturnExternalCode(String externalCode, List<ExternalListDetail> externalListDetailList) {
        Optional<ExternalListDetail> externalListCode = externalListDetailList.stream().filter(externalListDetail -> {
           return externalListDetail.getExternalListCode().equals(externalCode);
        }).findFirst();
        if(externalListCode.isEmpty()){
            throw new InvalidCodeException("The code provided is not valid");
        }
        return externalListCode.get();
    }

    private void validateExternalSource(String externalSourceName, ExternalListType externalList) {
        if(!externalList.getExternalSource().getExternalSourceName().equals(externalSourceName)){
            throw new NotMatchingExternalSourceException("The source provided is not matching with the source of the external list type");
        }
    }

    private ExternalListType getExternalListType(String externalListTypeName) {
        ExternalListType externalList;
        Optional<ExternalListType> externalListType = externalListTypeRepository.findExternalListTypeByExternalListTypeName(externalListTypeName);
        if(externalListType.isEmpty()){
            throw new ExternalListTypeNotFoundException("External List with name " + externalListTypeName + " not found");
        }else{
            externalList = externalListType.get();
        }
        return externalList;
    }
}
