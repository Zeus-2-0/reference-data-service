package com.brihaspathee.zeus.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 28, January 2022
 * Time: 2:02 PM
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
public class InternalRefDataRequestList {

    /**
     * The list of internal ref data codes that needs to be validated
     */
    @JsonProperty(required = true)
    @Schema(description = "The list of internal ref data codes that needs to be validated")
    @NotNull
    private List<InternalRefDataRequest> internalRefDataRequestList;

    /**
     * the toString method
     * @return
     */
    @Override
    public String toString() {
        return "InternalRefDataRequestList{" +
                "internalRefDataRequestList=" + internalRefDataRequestList +
                '}';
    }
}
