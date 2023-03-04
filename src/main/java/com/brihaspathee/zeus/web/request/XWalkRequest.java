package com.brihaspathee.zeus.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 2:03 PM
 * Project: Zeus
 * Package Name: com.zeus.web.request
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XWalkRequest {

    /**
     * The list code for which the cross walk value is requested
     */
    @JsonProperty(required = true)
    @Schema(description = "The internal or external ref data code for which the cross walk value is requested", example = "SSN")
    @NotNull
    @NotBlank
    private String listCode;

    /**
     * The name of the list type that the code is associated
     */
    @JsonProperty(required = true)
    @Schema(description = "The name of the list type that the code is associated", example = "Identifier")
    @NotNull
    @NotBlank
    private String listTypeName;

    /**
     * The name of the external source that is involved in the cross-walk
     */
    @JsonProperty(required = true)
    @Schema(description = "The name of the external source that is involved in the cross-walk", example = "Identifier")
    @NotNull
    @NotBlank
    private String externalSourceName;

    /**
     * The toString method
     * @return
     */
    @Override
    public String toString() {
        return "XWalkRequest{" +
                "listCode='" + listCode + '\'' +
                ", externalListTypeName='" + listTypeName + '\'' +
                ", externalSourceName='" + externalSourceName + '\'' +
                '}';
    }
}
