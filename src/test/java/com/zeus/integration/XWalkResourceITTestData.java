package com.zeus.integration;

import com.zeus.web.request.TestInternalXWalkRequest;
import lombok.*;

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
public class XWalkResourceITTestData {

    private TestInternalXWalkRequest testInternalXWalkRequest;

    @Override
    public String toString() {
        return "TestDataDto{" +
                "testInternalXWalk=" + testInternalXWalkRequest +
                '}';
    }
}
