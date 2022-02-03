package com.brihaspathee.zeus.web.resource.impl;

import com.brihaspathee.zeus.constants.ApiResponseConstants;
import com.brihaspathee.zeus.service.interfaces.InternalRefDataService;
import com.brihaspathee.zeus.web.request.InternalRefDataRequestList;
import com.brihaspathee.zeus.web.resource.interfaces.InternalRefDataApi;
import com.brihaspathee.zeus.web.response.InternalRefDataList;
import com.brihaspathee.zeus.web.response.InternalRefDataResponseList;
import com.brihaspathee.zeus.web.model.InternalRefData;
import com.brihaspathee.zeus.web.request.InternalRefDataRequest;
import com.brihaspathee.zeus.web.response.InternalRefDataResponse;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 3:05 PM
 * Project: Zeus
 * Package Name: com.zeus.web.resource.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class InternalRefDataResource implements InternalRefDataApi {

    private final InternalRefDataService internalRefDataService;

    @Override
    public ResponseEntity<ZeusApiResponse<InternalRefDataResponse>> validateReferenceData(InternalRefDataRequest internalRefDataRequest) {
        InternalRefDataResponse internalRefDataResponse = internalRefDataService.validateReferenceData(internalRefDataRequest);
        ZeusApiResponse<InternalRefDataResponse> apiResponse = ZeusApiResponse.<InternalRefDataResponse>builder()
                .response(internalRefDataResponse)
                .message(ApiResponseConstants.SUCCESS)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ZeusApiResponse<InternalRefDataResponseList>> validateReferenceDataList(InternalRefDataRequestList internalRefDataRequestList) {
        List<InternalRefDataResponse> internalRefDataResponses = internalRefDataRequestList
                .getInternalRefDataRequestList()
                .stream()
                .map(internalRefDataService :: validateReferenceData)
                .collect(Collectors.toList());
        InternalRefDataResponseList internalRefDataResponseList = InternalRefDataResponseList.builder()
                .responseList(internalRefDataResponses)
                .build();
        ZeusApiResponse<InternalRefDataResponseList> apiResponse = ZeusApiResponse.<InternalRefDataResponseList>builder()
                .response(internalRefDataResponseList)
                .message("Success")
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<InternalRefDataList> getInternalRefData(String listTypeName) {
        List<InternalRefData> internalRefData = internalRefDataService.getInternalRefDataCodesByListType(listTypeName);
        InternalRefDataList internalRefDataList = InternalRefDataList.builder()
                .internalRefDataList(internalRefData)
                .build();
        return ResponseEntity.ok(internalRefDataList);
    }
}
