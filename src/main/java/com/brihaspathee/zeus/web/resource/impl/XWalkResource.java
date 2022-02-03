package com.brihaspathee.zeus.web.resource.impl;

import com.brihaspathee.zeus.service.interfaces.XWalkService;
import com.brihaspathee.zeus.web.resource.interfaces.XWalkApi;
import com.brihaspathee.zeus.web.response.XWalkResponse;
import com.brihaspathee.zeus.web.request.XWalkRequest;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
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
    public ResponseEntity<ZeusApiResponse<XWalkResponse>> getInternalRefData(XWalkRequest xWalkRequest) {
        XWalkResponse xWalkResponse = xWalkService.getInternalRefDataCode(xWalkRequest);
        ZeusApiResponse<XWalkResponse> apiResponse = ZeusApiResponse.<XWalkResponse>builder()
                .response(xWalkResponse)
                .message("Success")
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ZeusApiResponse<XWalkResponse>> getExternalRefData(XWalkRequest xWalkRequest) {
        XWalkResponse xWalkResponse = xWalkService.getExternalRefDataCode(xWalkRequest);
        ZeusApiResponse<XWalkResponse> apiResponse = ZeusApiResponse.<XWalkResponse>builder()
                .response(xWalkResponse)
                .message("Success")
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
