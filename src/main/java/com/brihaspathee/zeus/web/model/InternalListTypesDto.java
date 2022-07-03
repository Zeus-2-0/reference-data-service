package com.brihaspathee.zeus.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, July 2022
 * Time: 7:30 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternalListTypesDto {

    /**
     * The list of all the internal lists
     */
    @JsonProperty(required = false)
    @Schema(description = "Contains the list of all the internal reference data lists")
    private List<InternalListTypeDto> internalListTypes;

    /**
     * The to string method
     * @return
     */
    @Override
    public String toString() {
        return "InternalListTypesDto{" +
                "internalListTypes=" + internalListTypes +
                '}';
    }
}
