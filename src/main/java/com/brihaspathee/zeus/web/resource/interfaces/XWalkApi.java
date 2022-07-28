package com.brihaspathee.zeus.web.resource.interfaces;

import com.brihaspathee.zeus.web.request.XWalkRequest;
import com.brihaspathee.zeus.web.response.ApiExceptionList;
import com.brihaspathee.zeus.web.response.InternalRefDataResponse;
import com.brihaspathee.zeus.web.response.XWalkResponse;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
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

    /**
     * POST Api to crosswalk external ref data to internal ref data
     * @param xWalkRequest
     * @return
     */
    @Operation(
            method = "POST",
            description = "Retrieves the internal ref data code for the external ref data code provided",
            tags = {"X-Walk"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The internal ref data code was retrieved for the external ref data code",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = XWalkResponse.class))
                    }),
            @ApiResponse(responseCode = "404",
                    description = "The external ref data code provided was not found",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiExceptionList.class))
                    })
    })
    @PostMapping("/internal")
    ResponseEntity<ZeusApiResponse<XWalkResponse>> getInternalRefData(@RequestBody XWalkRequest xWalkRequest);

    /**
     * POST Api to crosswalk internal ref data to external ref data
     * @param xWalkRequest
     * @return
     */
    @PostMapping("/external")
    ResponseEntity<ZeusApiResponse<XWalkResponse>> getExternalRefData(@RequestBody XWalkRequest xWalkRequest);


}
