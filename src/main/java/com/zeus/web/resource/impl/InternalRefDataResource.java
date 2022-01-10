package com.zeus.web.resource.impl;

import com.zeus.service.interfaces.InternalRefDataService;
import com.zeus.web.request.InternalRefDataRequest;
import com.zeus.web.resource.interfaces.InternalRefDataApi;
import com.zeus.web.response.InternalRefDataResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public ResponseEntity<InternalRefDataResponse> validateReferenceData(InternalRefDataRequest internalRefDataRequest) {
        InternalRefDataResponse internalRefDataResponse = internalRefDataService.validateReferenceData(internalRefDataRequest);

        return ResponseEntity.ok(internalRefDataResponse);
    }
}
