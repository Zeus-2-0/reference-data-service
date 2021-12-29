package com.zeus.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, December 2021
 * Time: 5:10 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExternalListDetail {

    @Id
    @GeneratedValue
    private Long externalListDetailSK;

    private String externalListCode;

    private String externalListDesc;

    @ManyToOne(fetch = FetchType.EAGER)
    private ExternalListType externalListType;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Override
    public String toString() {
        return "ExternalListDetail{" +
                "externalListDetailSK=" + externalListDetailSK +
                ", externalListCode='" + externalListCode + '\'' +
                ", externalListDesc='" + externalListDesc + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalListDetail that = (ExternalListDetail) o;
        return externalListDetailSK.equals(that.externalListDetailSK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalListDetailSK);
    }
}
