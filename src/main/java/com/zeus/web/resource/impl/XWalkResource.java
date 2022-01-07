package com.zeus.web.resource.impl;

import com.zeus.service.interfaces.XWalkService;
import com.zeus.web.request.InternalXWalkRequest;
import com.zeus.web.resource.interfaces.XWalkApi;
import com.zeus.web.response.XWalkResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 12:55 PM
 * Project: Zeus
 * Package Name: com.zeus.web.resource.impl
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequiredArgsConstructor
public class XWalkResource implements XWalkApi {

    private final XWalkService xWalkService;

    @Override
    public ResponseEntity<XWalkResponse> getInternalRefData(InternalXWalkRequest internalXWalkRequest) {
        XWalkResponse xWalkResponse = xWalkService.getInternalRefDataCode(internalXWalkRequest);
        return ResponseEntity.ok(xWalkResponse);
    }
}
