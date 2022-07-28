package com.brihaspathee.zeus.web.resource.interfaces;

import com.brihaspathee.zeus.reference.data.model.InternalListTypeDto;
import com.brihaspathee.zeus.reference.data.model.InternalListTypesDto;
import com.brihaspathee.zeus.web.request.InternalRefDataRequestList;
import com.brihaspathee.zeus.web.response.*;
import com.brihaspathee.zeus.web.request.InternalRefDataRequest;
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
@RequestMapping("/api/v1/ref-data/internal")
@Validated
public interface InternalRefDataApi {

    /**
     * The POST API endpoint to validate the internal reference data list code
     * @param internalRefDataRequest
     * @return
     */
    @Operation(
            operationId = "Validate internal REF-DATA code",
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
    ResponseEntity<ZeusApiResponse<InternalRefDataResponse>> validateReferenceData(@RequestBody @Valid InternalRefDataRequest internalRefDataRequest);

    /**
     * Validate all the codes against the internal reference data
     * @param internalRefDataRequestList
     * @return
     */
    @Operation(
            operationId = "Validate internal ref data codes",
            method = "POST",
            description = "Validate if the codes in the list is present in reference data",
            tags = {"internal-ref-data"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The codes were validated against the internal reference data",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InternalRefDataResponseList.class))
                    }),
            @ApiResponse(responseCode = "404",
                    description = "The internal list provided was not found",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiExceptionList.class))
                    })
    })
    @PostMapping("/list")
    ResponseEntity<ZeusApiResponse<InternalRefDataResponseList>> validateReferenceDataList(@RequestBody InternalRefDataRequestList internalRefDataRequestList);

    /**
     * Operation to get all of the internal list codes
     * @param listTypeName
     * @return
     */
    @Operation(
            operationId = "Get codes by List type",
            method = "GET",
            description = "Get all the internal list codes for the given list type",
            tags = {"internal-ref-data"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved all the internal ref data list for the internal list type",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InternalListTypeDto.class))
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
    ResponseEntity<ZeusApiResponse<InternalListTypeDto>> getInternalRefData(@PathVariable(name = "listTypeName") String listTypeName);

    /**
     * Returns all the internal list types that are present in the system
     * @return
     */
    @Operation(
            operationId = "Get All internal list types",
            method = "GET",
            description = "Get all the internal list types",
            tags = {"internal-ref-data"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved all the internal list types",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InternalListTypesDto.class))
                    }
            )
        }

    )
    @GetMapping(path = "/list-types", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ZeusApiResponse<InternalListTypesDto>> getAllInternalListTypes();

    /**
     * Operation to get internal for a list of internal list types
     * @param internalListTypesDto
     * @return
     */
    @Operation(
            operationId = "Get codes for list types",
            method = "GET",
            description = "Get all the internal list codes for multiple list types",
            tags = {"internal-ref-data"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved all the internal ref data list for the internal list types",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InternalListTypeDto.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Unable to find any internal list for the given list types",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiExceptionList.class))
                    }
            )
    }

    )
    @PostMapping(value = "/list-types", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ZeusApiResponse<InternalListTypesDto>> getInternalCodes(@RequestBody InternalListTypesDto internalListTypesDto);


}
