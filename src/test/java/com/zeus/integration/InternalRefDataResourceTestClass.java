package com.zeus.integration;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 07, January 2022
 * Time: 1:58 PM
 * Project: Zeus
 * Package Name: com.zeus.integration
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternalRefDataResourceTestClass {

    private String testClassName;

    private List<InternalRefDataResourceTestMethod> testMethods;

    @Override
    public String toString() {
        return "InternalRefDataResourceTestClass{" +
                "testClassName='" + testClassName + '\'' +
                ", testMethods=" + testMethods +
                '}';
    }
}
