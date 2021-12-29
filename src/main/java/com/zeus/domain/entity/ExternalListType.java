package com.zeus.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, December 2021
 * Time: 4:57 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExternalListType {

    @Id
    @GeneratedValue
    private Long externalListTypeSK;

    private String externalListTypeName;

    private String externalListTypeDesc;

    @ManyToOne(fetch = FetchType.EAGER)
    private ExternalSource externalSource;

    @OneToMany(mappedBy = "externalListType")
    private List<ExternalListDetail> externalListDetailList;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Override
    public String toString() {
        return "ExternalListType{" +
                "externalListTypeSK=" + externalListTypeSK +
                ", externalListTypeName='" + externalListTypeName + '\'' +
                ", externalListTypeDesc='" + externalListTypeDesc + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalListType that = (ExternalListType) o;
        return externalListTypeSK.equals(that.externalListTypeSK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalListTypeSK);
    }
}
