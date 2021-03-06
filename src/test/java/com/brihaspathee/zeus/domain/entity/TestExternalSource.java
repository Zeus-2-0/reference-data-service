package com.brihaspathee.zeus.domain.entity;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, January 2022
 * Time: 11:27 AM
 * Project: Zeus
 * Package Name: com.zeus.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestExternalSource {

    private Long externalSourceSK;

    private String externalSourceCode;

    private String externalSourceName;

    private String externalSourceDesc;

    private boolean found;
}
