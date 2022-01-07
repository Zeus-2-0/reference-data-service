package com.zeus.web.request;

import lombok.*;

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
public class InternalRefDataRequest {

    private String internalListCode;

    private String internalListTypeName;

    @Override
    public String toString() {
        return "InternalRefDataRequest{" +
                "internalListCode='" + internalListCode + '\'' +
                ", internalListTypeName='" + internalListTypeName + '\'' +
                '}';
    }
}
