package com.zeus.domain.repository;

import com.zeus.domain.entity.TestInternalListType;
import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, January 2022
 * Time: 9:59 AM
 * Project: Zeus
 * Package Name: com.zeus.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternalListTypeRepositoryTestData {

    private TestInternalListType testInternalListType;

    @Override
    public String toString() {
        return "InternalListTypeRepositoryTestData{" +
                "testInternalListType=" + testInternalListType +
                '}';
    }
}
