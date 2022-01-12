package com.zeus.domain.repository;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, January 2022
 * Time: 9:45 AM
 * Project: Zeus
 * Package Name: com.zeus.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternalListTypeRepositoryTestClass {

    private String testClassName;

    private List<InternalListTypeRepositoryTestMethod> testMethods;

    @Override
    public String toString() {
        return "InternalListTypeRepositoryTestClass{" +
                "testClassName='" + testClassName + '\'' +
                '}';
    }
}
