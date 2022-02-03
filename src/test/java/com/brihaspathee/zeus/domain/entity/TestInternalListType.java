package com.brihaspathee.zeus.domain.entity;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, January 2022
 * Time: 9:35 AM
 * Project: Zeus
 * Package Name: com.zeus.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestInternalListType {

    private Long internalListTypeSK;

    private String internalListTypeName;

    private String internalListTypeDesc;

    private boolean found;
}
