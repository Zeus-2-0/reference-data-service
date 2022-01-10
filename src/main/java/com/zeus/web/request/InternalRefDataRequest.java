package com.zeus.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 2:00 PM
 * Project: Zeus
 * Package Name: com.zeus.web.request
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class InternalRefDataRequest {

    @JsonProperty(required = true)
    @Schema(description = "The internal ref data code that needs to be validated", example = "SSN")
    @NotNull
    @NotBlank
    private String internalListCode;

    @JsonProperty(required = true)
    @Schema(description = "The internal list that the code belongs to", example = "Identifier")
    @NotBlank
    @NotNull
    private String internalListTypeName;

    @Override
    public String toString() {
        return "InternalRefDataRequest{" +
                "internalListCode='" + internalListCode + '\'' +
                ", internalListTypeName='" + internalListTypeName + '\'' +
                '}';
    }
}
