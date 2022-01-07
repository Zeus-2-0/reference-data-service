package com.zeus.web.request;

import com.zeus.web.response.InternalRefDataResponse;
import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 07, January 2022
 * Time: 1:40 PM
 * Project: Zeus
 * Package Name: com.zeus.web.request
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestInternalRefDataRequest {

    private boolean exceptionExpected;

    private String exceptionCode;

    private String exceptionMessage;

    private String httpStatusCode;

    private InternalRefDataRequest internalRefDataRequest;

    private InternalRefDataResponse expectedResponse;

    @Override
    public String toString() {
        return "TestInternalRefDataRequest{" +
                "exceptionExpected=" + exceptionExpected +
                ", exceptionCode='" + exceptionCode + '\'' +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                ", httpStatusCode='" + httpStatusCode + '\'' +
                ", internalRefDataRequest=" + internalRefDataRequest +
                ", expectedResponse=" + expectedResponse +
                '}';
    }
}
