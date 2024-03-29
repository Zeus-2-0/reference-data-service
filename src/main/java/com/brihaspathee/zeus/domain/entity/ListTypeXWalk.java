package com.brihaspathee.zeus.domain.entity;

import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import jakarta.persistence.*;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 30, December 2021
 * Time: 6:28 AM
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
@Table(name = "intrnl_extrnl_type_xwalk")
public class ListTypeXWalk {

    /**
     * Primary key of the table
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(Types.LONGVARCHAR)
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "list_type_xwalk_sk", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID listTypeXWalkSK;

    @ManyToOne
    @JoinColumn(name = "external_list_type_sk", nullable = false)
    private ExternalListType externalListType;

    @ManyToOne
    @JoinColumn(name = "internal_list_type_sk", nullable = false)
    private InternalListType internalListType;

    @OneToMany(mappedBy = "listTypeXWalk")
    private List<ListDetailXWalk> detailXWalkList;

    @CreationTimestamp
    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = true)
    private LocalDateTime updatedDate;

    @Override
    public String toString() {
        return "ListTypeXWalk{" +
                "listTypeXWalkSK=" + listTypeXWalkSK +
                ", externalListType=" + externalListType +
                ", internalListType=" + internalListType +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListTypeXWalk that = (ListTypeXWalk) o;
        return listTypeXWalkSK.equals(that.listTypeXWalkSK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listTypeXWalkSK);
    }
}
