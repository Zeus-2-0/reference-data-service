package com.zeus.web.request;

import com.zeus.web.response.XWalkResponse;
import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 3:52 PM
 * Project: Zeus
 * Package Name: com.zeus.web.request
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestInternalXWalkRequest {

    private boolean exceptionExpected;

    private String exceptionCode;

    private String exceptionMessage;

    private String httpStatusCode;

    private InternalXWalkRequest internalXWalkRequest;

    private XWalkResponse expectedXWalkResponse;

    @Override
    public String toString() {
        return "TestInternalXWalk{" +
                "exceptionExpected=" + exceptionExpected +
                ", exceptionCode='" + exceptionCode + '\'' +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                ", httpStatusCode='" + httpStatusCode + '\'' +
                ", internalXWalkRequest=" + internalXWalkRequest +
                ", expectedXWalkResponse=" + expectedXWalkResponse +
                '}';
    }
}
