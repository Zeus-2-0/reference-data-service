package com.brihaspathee.zeus.service.impl;

import com.brihaspathee.zeus.domain.entity.*;
import com.brihaspathee.zeus.domain.repository.ExternalListTypeRepository;
import com.brihaspathee.zeus.domain.repository.ExternalSourceRepository;
import com.brihaspathee.zeus.domain.repository.InternalListTypeRepository;
import com.brihaspathee.zeus.exception.*;
import com.brihaspathee.zeus.service.interfaces.XWalkService;
import com.brihaspathee.zeus.web.request.XWalkRequest;
import com.brihaspathee.zeus.web.response.XWalkResponse;
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

    private final ExternalSourceRepository externalSourceRepository;

    private final InternalListTypeRepository internalListTypeRepository;

    @Override
    public XWalkResponse getInternalRefDataCode(XWalkRequest XWalkRequest) {
        String externalListTypeName = XWalkRequest.getListTypeName();
        String externalCode = XWalkRequest.getListCode();
        String externalSourceName = XWalkRequest.getExternalSourceName();
        ExternalListType externalList = getExternalListType(externalListTypeName);
        validateExternalSource(externalSourceName, externalList);
        List<ExternalListDetail> externalListDetailList = externalList.getExternalListDetailList();
        ExternalListDetail externalListCode = validateAndReturnExternalCode(externalCode, externalListDetailList);
        List<ListDetailXWalk> detailXWalkList = externalListCode.getDetailXWalkList();
        log.info("Cross walk size: {}",detailXWalkList.size());
        return getInternalXWalkResponse(XWalkRequest, externalListTypeName, externalCode, detailXWalkList);

    }

    @Override
    public XWalkResponse getExternalRefDataCode(XWalkRequest XWalkRequest) {
        String internalListTypeName = XWalkRequest.getListTypeName();
        String internalCode = XWalkRequest.getListCode();
        String externalSourceName = XWalkRequest.getExternalSourceName();
        validateExternalSource(externalSourceName);
        InternalListType internalListType = getInternalListType(internalListTypeName);
        List<InternalListDetail> internalListDetails = internalListType.getInternalListDetails();
        InternalListDetail internalListDetail = validateAndReturnInternalCode(internalCode, internalListDetails);
        List<ListDetailXWalk> detailXWalkList = internalListDetail.getCodeXWalkList();
        return getExternalXWalkResponse(XWalkRequest, internalListTypeName, internalCode, detailXWalkList);
    }

    private XWalkResponse getInternalXWalkResponse(XWalkRequest XWalkRequest, String externalListTypeName, String externalCode, List<ListDetailXWalk> detailXWalkList) {
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
                    .externalSourceName(XWalkRequest.getExternalSourceName())
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

    private void validateExternalSource(String externalSourceName) {
        Optional<ExternalSource> externalSource = externalSourceRepository.findExternalSourceByExternalSourceName(externalSourceName);
        if(externalSource.isEmpty()){
            throw new ExternalSourceNotFoundException("External Source " + externalSourceName + " not found");
        }
    }

    private InternalListType getInternalListType(String internalListTypeName) {
        InternalListType internalList;
        Optional<InternalListType> internalListType = internalListTypeRepository.findInternalListTypeByInternalListTypeName(internalListTypeName);
        if(internalListType.isEmpty()){
            throw new InternalListTypeNotFoundException("Internal List with name " + internalListTypeName + " not found");
        }else{
            internalList = internalListType.get();
        }
        return internalList;
    }

    private InternalListDetail validateAndReturnInternalCode(String internalCode, List<InternalListDetail> internalListDetailList) {
        Optional<InternalListDetail> internalListCode = internalListDetailList.stream().filter(internalListDetail -> {
            return internalListDetail.getInternalListCode().equals(internalCode);
        }).findFirst();
        if(internalListCode.isEmpty()){
            throw new InvalidCodeException("The code provided is not valid");
        }
        return internalListCode.get();
    }

    private XWalkResponse getExternalXWalkResponse(XWalkRequest XWalkRequest, String internalListTypeName, String internalCode, List<ListDetailXWalk> detailXWalkList) {
        if(detailXWalkList.size() == 0){
            throw new NoMatchingExternalRefDataCodeException("There is no matching external ref data code for internal code " + internalCode);
        }else if(detailXWalkList.size() > 1){
            throw new MultipleExternalCodeMatchingException("There are multiple external reference data code matching for inter code " + internalCode);
        } else{
            ListDetailXWalk detailXWalk = detailXWalkList.get(0);
            ExternalListDetail externalListDetail = detailXWalk.getExternalListDetail();
            return XWalkResponse.builder()
                    .externalListCode(externalListDetail.getExternalListCode())
                    .externalListTypeName(externalListDetail.getExternalListType().getExternalListTypeName())
                    .internalListCode(internalCode)
                    .internalListTypeName(internalListTypeName)
                    .externalSourceName(XWalkRequest.getExternalSourceName())
                    .build();
        }
    }


}
