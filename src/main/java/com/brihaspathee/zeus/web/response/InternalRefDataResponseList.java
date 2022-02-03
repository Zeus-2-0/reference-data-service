package com.brihaspathee.zeus.web.response;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 28, January 2022
 * Time: 3:24 PM
 * Project: Zeus
 * Package Name: com.zeus.web.response
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternalRefDataResponseList {

    private List<InternalRefDataResponse> responseList;

    @Override
    public String toString() {
        return "InternalRefDataResponseList{" +
                "responseList=" + responseList +
                '}';
    }
}
