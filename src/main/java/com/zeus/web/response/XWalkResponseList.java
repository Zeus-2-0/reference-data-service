package com.zeus.web.response;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, January 2022
 * Time: 2:13 PM
 * Project: Zeus
 * Package Name: com.zeus.web.response
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XWalkResponseList {

    private List<XWalkResponse> xWalkResponses;

    @Override
    public String toString() {
        return "XWalkResponseList{" +
                "xWalkResponses=" + xWalkResponses +
                '}';
    }
}
