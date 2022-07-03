package com.brihaspathee.zeus.web.resource.interfaces;

import com.brihaspathee.zeus.web.request.XWalkRequest;
import com.brihaspathee.zeus.web.response.XWalkResponse;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 11:28 AM
 * Project: Zeus
 * Package Name: com.zeus.web.resource.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/ref-data/x-walk")
public interface XWalkApi {

    @PostMapping("/internal")
    ResponseEntity<ZeusApiResponse<XWalkResponse>> getInternalRefData(@RequestBody XWalkRequest xWalkRequest);

    @PostMapping("/external")
    ResponseEntity<ZeusApiResponse<XWalkResponse>> getExternalRefData(@RequestBody XWalkRequest xWalkRequest);


}
