package com.zeus.integration;

import com.zeus.web.request.TestInternalRefDataRequest;
import lombok.*;

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
public class InternalRefDataResourceTestData {

    private TestInternalRefDataRequest testInternalRefDataRequest;

    @Override
    public String toString() {
        return "InternalRefDataResourceTestData{" +
                "testInternalRefDataRequest=" + testInternalRefDataRequest +
                '}';
    }
}
