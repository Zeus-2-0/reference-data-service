package com.brihaspathee.zeus.web.response;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 2:04 PM
 * Project: Zeus
 * Package Name: com.zeus.web.response
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XWalkResponse {

    private ResponseMetadata responseMetadata;

    private String internalListCode;

    private String internalListTypeName;

    private String externalListCode;

    private String externalListTypeName;

    private String externalSourceName;

    @Override
    public String toString() {
        return "XWalkResponse{" +
                "responseMetadata=" + responseMetadata +
                ", internalListCode='" + internalListCode + '\'' +
                ", internalListTypeName='" + internalListTypeName + '\'' +
                ", externalListCode='" + externalListCode + '\'' +
                ", externalListTypeName='" + externalListTypeName + '\'' +
                ", externalSourceName='" + externalSourceName + '\'' +
                '}';
    }
}
