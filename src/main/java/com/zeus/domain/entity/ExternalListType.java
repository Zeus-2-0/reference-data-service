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
@Table(name = "external_list_type")
public class ExternalListType {

    @Id
    @GeneratedValue
    @Column(name = "external_list_type_sk", nullable = false, updatable = false)
    private Long externalListTypeSK;

    @Column(name = "external_list_type_name", nullable = false, unique = true, length = 100)
    private String externalListTypeName;

    @Column(name = "external_list_type_desc", nullable = false, length = 100)
    private String externalListTypeDesc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "external_source_sk")
    private ExternalSource externalSource;

    @OneToMany(mappedBy = "externalListType")
    private List<ExternalListDetail> externalListDetailList;

    @OneToMany(mappedBy = "externalListType")
    private List<ListTypeXWalk> xWalkList;

    @CreationTimestamp
    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = true)
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
