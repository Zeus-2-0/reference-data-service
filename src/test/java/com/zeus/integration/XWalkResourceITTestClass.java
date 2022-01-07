package com.zeus.integration;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, January 2022
 * Time: 12:31 PM
 * Project: Zeus
 * Package Name: com.zeus.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XWalkResourceITTestClass {

    private String testClassName;

    private List<XWalkResourceITTestMethod> testMethods;

    @Override
    public String toString() {
        return "TestClassDto{" +
                "testClassName='" + testClassName + '\'' +
                ", testMethods=" + testMethods +
                '}';
    }
}
