package com.zeus.web.response;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, January 2022
 * Time: 3:26 PM
 * Project: Zeus
 * Package Name: com.zeus.web.response
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiExceptionList {

    private List<ApiException> exceptions;

    @Override
    public String toString() {
        return "ApiExceptionList{" +
                "exceptions=" + exceptions +
                '}';
    }
}
