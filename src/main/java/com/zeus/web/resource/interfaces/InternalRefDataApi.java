package com.zeus.web.resource.interfaces;

import com.zeus.web.request.InternalRefDataRequest;
import com.zeus.web.response.ApiExceptionList;
import com.zeus.web.response.InternalRefDataList;
import com.zeus.web.response.InternalRefDataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
@Validated
public interface InternalRefDataApi {

    /**
     * The POST API endpoint to validate the internal reference data list code
     * @param internalRefDataRequest
     * @return
     */
    @Operation(
            method = "POST",
            description = "Validate if the code is present in reference data",
            tags = {"internal-ref-data"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The code was validated against the internal reference data",
                    content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InternalRefDataResponse.class))
                    }),
            @ApiResponse(responseCode = "404",
                    description = "The internal list provided was not found",
                    content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiExceptionList.class))
                    })
    })
    @PostMapping
    ResponseEntity<InternalRefDataResponse> validateReferenceData(@RequestBody @Valid InternalRefDataRequest internalRefDataRequest);

    /**
     * Operation to get all of the internal list codes
     * @param listTypeName
     * @return
     */
    @Operation(
            method = "GET",
            description = "Get all the internal list codes for the given list type",
            tags = {"internal-ref-data"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved all the internal ref data list for the internal list type",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InternalRefDataList.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Unable to find any internal list for the given list type",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiExceptionList.class))
                    }
            )
    }

    )
    @GetMapping(value = "/{listTypeName}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<InternalRefDataList> getInternalRefData(@PathVariable(name = "listTypeName") String listTypeName);
}
