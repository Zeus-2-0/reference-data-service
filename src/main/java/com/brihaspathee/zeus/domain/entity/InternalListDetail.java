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
 * Date: 30, December 2021
 * Time: 6:24 AM
 * Project: Zeus
 * Package Name: com.zeus.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "internal_list_dtl")
public class InternalListDetail {

    @Id
    @GeneratedValue
    @Column(name="internal_list_dtl_sk", nullable = false, updatable = false)
    private Long internalListDetailSK;

    @Column(name = "internal_list_code", nullable = false)
    private String internalListCode;

    @Column(name = "internal_list_code_desc", nullable = true)
    private String internalListCodeDesc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "internal_list_type_sk", nullable = false)
    private InternalListType internalListType;

    @OneToMany(mappedBy = "internalListDetail")
    private List<ListDetailXWalk> codeXWalkList;

    @CreationTimestamp
    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = true)
    private LocalDateTime updatedDate;

    @Override
    public String toString() {
        return "InternalListDetail{" +
                "internalListDetailSK=" + internalListDetailSK +
                ", internalListCode='" + internalListCode + '\'' +
                ", internalListCodeDesc='" + internalListCodeDesc + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternalListDetail that = (InternalListDetail) o;
        return internalListDetailSK.equals(that.internalListDetailSK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalListDetailSK);
    }
}
