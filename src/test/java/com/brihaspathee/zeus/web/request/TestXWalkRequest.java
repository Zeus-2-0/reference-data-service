package com.brihaspathee.zeus.web.request;

import com.brihaspathee.zeus.reference.data.model.XWalkRequest;
import com.brihaspathee.zeus.reference.data.model.XWalkResponse;
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
public class TestXWalkRequest {

    private boolean exceptionExpected;

    private String exceptionCode;

    private String exceptionMessage;

    private String httpStatusCode;

    private XWalkRequest crossWalkRequest;

    private XWalkResponse expectedXWalkResponse;


    @Override
    public String toString() {
        return "TestXWalkRequest{" +
                "exceptionExpected=" + exceptionExpected +
                ", exceptionCode='" + exceptionCode + '\'' +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                ", httpStatusCode='" + httpStatusCode + '\'' +
                ", crossWalkRequest=" + crossWalkRequest +
                ", expectedXWalkResponse=" + expectedXWalkResponse +
                '}';
    }
}
