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
 * Time: 6:18 AM
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
@Table(name = "internal_list_type")
public class InternalListType {

    @Id
    @GeneratedValue
    @Column(name="internal_list_type_sk", nullable = false, updatable = false)
    private Long internalListTypeSK;

    @Column(name = "internal_list_type_name", nullable = false, length = 100)
    private String internalListTypeName;

    @Column(name = "internal_list_type_desc", nullable = true, length = 100)
    private String internalListTypeDesc;

    @OneToMany(mappedBy = "internalListType")
    private List<InternalListDetail> internalListDetails;

    @OneToMany(mappedBy = "internalListType")
    private List<ListTypeXWalk> xWalkList;

    @CreationTimestamp
    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = true)
    private LocalDateTime updatedDate;

    @Override
    public String toString() {
        return "InternalListType{" +
                "internalListTypeSK=" + internalListTypeSK +
                ", internalListTypeName='" + internalListTypeName + '\'' +
                ", internalListTypeDesc='" + internalListTypeDesc + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternalListType that = (InternalListType) o;
        return internalListTypeSK.equals(that.internalListTypeSK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalListTypeSK);
    }
}
