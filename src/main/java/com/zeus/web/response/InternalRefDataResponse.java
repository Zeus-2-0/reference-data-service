package com.zeus.web.response;

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

    private ResponseMetadata responseMetadata;

    private String internalListCode;

    private String internalListTypeName;

    private boolean valid;

    @Override
    public String toString() {
        return "InternalRefDataResponse{" +
                "responseMetadata=" + responseMetadata +
                ", internalListCode='" + internalListCode + '\'' +
                ", internalListTypeName='" + internalListTypeName + '\'' +
                ", valid=" + valid +
                '}';
    }
}
