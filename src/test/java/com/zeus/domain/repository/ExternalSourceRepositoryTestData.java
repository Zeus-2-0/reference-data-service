package com.zeus.domain.repository;

import com.zeus.domain.entity.TestExternalSource;
import lombok.*;

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
public class ExternalSourceRepositoryTestData {

    private TestExternalSource testExternalSource;

    @Override
    public String toString() {
        return "ExternalSourceRepositoryTestData{" +
                "testExternalSource=" + testExternalSource +
                '}';
    }
}
