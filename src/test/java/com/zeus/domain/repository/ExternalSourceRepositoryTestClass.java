package com.zeus.domain.repository;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, January 2022
 * Time: 2:07 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalSourceRepositoryTestClass {

    private String testClassName;

    private List<ExternalSourceRepositoryTestMethod> testMethods;

    @Override
    public String toString() {
        return "ExternalSourceRepositoryTestClass{" +
                "testClassName='" + testClassName + '\'' +
                ", testMethods=" + testMethods +
                '}';
    }
}
