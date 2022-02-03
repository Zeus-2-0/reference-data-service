package com.brihaspathee.zeus.domain.entity;

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
@Table(name = "external_list_dtl")
public class ExternalListDetail {

    @Id
    @GeneratedValue
    @Column(name = "external_list_dtl_sk", nullable = false, updatable = false)
    private Long externalListDetailSK;

    @Column(name = "external_list_code", nullable = false, length = 100)
    private String externalListCode;

    @Column(name = "external_list_desc", nullable = true, length = 100)
    private String externalListDesc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "external_list_type_sk")
    private ExternalListType externalListType;

    @OneToMany(mappedBy = "externalListDetail")
    private List<ListDetailXWalk> detailXWalkList;

    @CreationTimestamp
    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = true)
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
