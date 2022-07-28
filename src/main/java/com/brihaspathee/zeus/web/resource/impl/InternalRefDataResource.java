package com.brihaspathee.zeus.web.resource.impl;

import com.brihaspathee.zeus.constants.ApiResponseConstants;
import com.brihaspathee.zeus.reference.data.model.InternalListTypeDto;
import com.brihaspathee.zeus.reference.data.model.InternalListTypesDto;
import com.brihaspathee.zeus.service.interfaces.InternalListTypeService;
import com.brihaspathee.zeus.service.interfaces.InternalRefDataService;
import com.brihaspathee.zeus.web.request.InternalRefDataRequestList;
import com.brihaspathee.zeus.web.resource.interfaces.InternalRefDataApi;
import com.brihaspathee.zeus.web.response.InternalRefDataResponseList;
import com.brihaspathee.zeus.web.request.InternalRefDataRequest;
import com.brihaspathee.zeus.web.response.InternalRefDataResponse;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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

    /**
     * Service that is used to serve the requests received to the api
     */
    private final InternalRefDataService internalRefDataService;

    /**
     * Service that is used to serve the requests received to the api
     */
    private final InternalListTypeService internalListTypeService;

    /**
     * The POST API endpoint to validate the internal reference data list code
     * @param internalRefDataRequest
     * @return
     */
    @Override
    public ResponseEntity<ZeusApiResponse<InternalRefDataResponse>> validateReferenceData(InternalRefDataRequest internalRefDataRequest) {
        InternalRefDataResponse internalRefDataResponse = internalRefDataService.validateReferenceData(internalRefDataRequest);
        ZeusApiResponse<InternalRefDataResponse> apiResponse = ZeusApiResponse.<InternalRefDataResponse>builder()
                .response(internalRefDataResponse)
                .message(ApiResponseConstants.SUCCESS)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    /**
     * Validate all the codes against the internal reference data
     * @param internalRefDataRequestList
     * @return
     */
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

    /**
     * Operation to get all the internal list codes
     * @param listTypeName
     * @return
     */
    @Override
    public ResponseEntity<ZeusApiResponse<InternalListTypeDto>> getInternalRefData(String listTypeName) {
        InternalListTypeDto internalListTypeDto = internalRefDataService.getInternalRefDataCodesByListType(listTypeName);
        ZeusApiResponse<InternalListTypeDto> apiResponse = ZeusApiResponse.<InternalListTypeDto>builder()
                .reason(ApiResponseConstants.SUCCESS_REASON)
                .timestamp(LocalDateTime.now())
                .developerMessage(ApiResponseConstants.SUCCESS)
                .message(ApiResponseConstants.SUCCESS)
                .statusCode(200)
                .status(HttpStatus.OK)
                .response(internalListTypeDto)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    /**
     * Returns all the internal list types that are present in the system
     * @return
     */
    @Override
    public ResponseEntity<ZeusApiResponse<InternalListTypesDto>> getAllInternalListTypes() {
        InternalListTypesDto internalListTypesDto =
                internalListTypeService.getAllInternalListTypes();
        ZeusApiResponse<InternalListTypesDto> apiResponse = ZeusApiResponse.<InternalListTypesDto>builder()
                .response(internalListTypesDto)
                .message(ApiResponseConstants.SUCCESS)
                .statusCode(200)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
