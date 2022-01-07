package com.zeus.web.resource.interfaces;

import com.zeus.web.request.InternalXWalkRequest;
import com.zeus.web.response.XWalkResponse;
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
@RequestMapping("/api/v1/xwalk")
public interface XWalkApi {

    @PostMapping("/internal")
    ResponseEntity<XWalkResponse> getInternalRefData(@RequestBody InternalXWalkRequest internalXWalkRequest);
}
