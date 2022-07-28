package com.brihaspathee.zeus.web.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 2:02 PM
 * Project: Zeus
 * Package Name: com.zeus.web.response
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternalRefDataResponse {

    /**
     * The internal list code that was provided in the request
     */
    @Schema(description = "The internal ref data code that was validated", example = "SSN")
    private String internalListCode;

    /**
     * The internal list type that was provided
     */
    @Schema(description = "The internal list type that  the code was validated against", example = "Identifier")
    private String internalListTypeName;

    /**
     * Identifies if the code provided is valid or not
     */
    @Schema(description = "Indicates if the code provided is valid or not", example = "True")
    private boolean valid;

    /**
     * the toString method
     * @return
     */
    @Override
    public String toString() {
        return "InternalRefDataResponse{" +
                ", internalListCode='" + internalListCode + '\'' +
                ", internalListTypeName='" + internalListTypeName + '\'' +
                ", valid=" + valid +
                '}';
    }
}
