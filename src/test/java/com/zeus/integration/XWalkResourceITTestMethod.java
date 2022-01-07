package com.zeus.integration;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, January 2022
 * Time: 1:03 PM
 * Project: Zeus
 * Package Name: com.zeus.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XWalkResourceITTestMethod {

    private String testMethodName;

    private List<XWalkResourceITTestData> testData;

    @Override
    public String toString() {
        return "TestMethodDto{" +
                "testMethodName='" + testMethodName + '\'' +
                ", testData=" + testData +
                '}';
    }
}
