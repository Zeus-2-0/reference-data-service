package com.zeus.domain.repository;

import com.zeus.domain.entity.TestExternalListType;
import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, January 2022
 * Time: 2:06 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalListTypeRepositoryTestData {

    private TestExternalListType testExternalListType;

    @Override
    public String toString() {
        return "ExternalListTypeRepositoryTestData{" +
                "testExternalListType=" + testExternalListType +
                '}';
    }
}
