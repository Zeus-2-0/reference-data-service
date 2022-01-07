package com.zeus.web.resource.interfaces;

import com.zeus.web.request.InternalRefDataRequest;
import com.zeus.web.response.InternalRefDataResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 3:02 PM
 * Project: Zeus
 * Package Name: com.zeus.web.resource.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/internal/refdata")
public interface InternalRefDataApi {

    /**
     * The POST API endpoint to validate the internal reference data list code
     * @param internalRefDataRequest
     * @return
     */
    @PostMapping
    ResponseEntity<InternalRefDataResponse> validateReferenceData(@RequestBody InternalRefDataRequest internalRefDataRequest);
}
