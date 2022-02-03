package com.brihaspathee.zeus.web.request;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 28, January 2022
 * Time: 2:02 PM
 * Project: Zeus
 * Package Name: com.zeus.web.request
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class InternalRefDataRequestList {

    private List<InternalRefDataRequest> internalRefDataRequestList;

    @Override
    public String toString() {
        return "InternalRefDataRequestList{" +
                "internalRefDataRequestList=" + internalRefDataRequestList +
                '}';
    }
}
