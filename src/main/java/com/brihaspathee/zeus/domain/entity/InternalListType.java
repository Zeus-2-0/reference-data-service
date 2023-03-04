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

    /**
     * Primary key of the table
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(Types.LONGVARCHAR)
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "internal_list_type_sk", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID internalListTypeSK;

    /**
     * The name of the list type
     */
    @Column(name = "internal_list_type_name", nullable = false, length = 100)
    private String internalListTypeName;

    /**
     * A short description of the list type
     */
    @Column(name = "internal_list_type_desc", nullable = true, length = 100)
    private String internalListTypeDesc;

    /**
     * The display name associated with the list type
     */
    @Column(name = "display_name", nullable = false, length = 100)
    private String displayName;

    /**
     * The list of internal codes associated with the list type
     */
    @OneToMany(mappedBy = "internalListType")
    private List<InternalListDetail> internalListDetails;

    /**
     * The cross walk with the external list type
     */
    @OneToMany(mappedBy = "internalListType")
    private List<ListTypeXWalk> xWalkList;

    /**
     * Date when the record was created
     */
    @CreationTimestamp
    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    /**
     * Date when the record was updated
     */
    @UpdateTimestamp
    @Column(name = "updated_date", nullable = true)
    private LocalDateTime updatedDate;

    /**
     * toString method
     * @return
     */
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

    /**
     * equals method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternalListType that = (InternalListType) o;
        return internalListTypeSK.equals(that.internalListTypeSK);
    }

    /**
     * hascode method
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(internalListTypeSK);
    }
}
