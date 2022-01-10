package com.zeus.web.request;

import lombok.*;

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

    private String listCode;

    private String listTypeName;

    private String externalSourceName;

    @Override
    public String toString() {
        return "XWalkRequest{" +
                "listCode='" + listCode + '\'' +
                ", externalListTypeName='" + listTypeName + '\'' +
                ", externalSourceName='" + externalSourceName + '\'' +
                '}';
    }
}
