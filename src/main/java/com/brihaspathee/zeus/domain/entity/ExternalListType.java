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

    /**
     * Primary key of the table
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(Types.LONGVARCHAR)
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "external_list_type_sk", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID externalListTypeSK;

    /**
     * The name of the external list type
     */
    @Column(name = "external_list_type_name", nullable = false, unique = true, length = 100)
    private String externalListTypeName;

    /**
     * A short description of the external list type
     */
    @Column(name = "external_list_type_desc", nullable = false, length = 100)
    private String externalListTypeDesc;

    /**
     * Display name used in the UI for the list type
     */
    @Column(name = "display_name", nullable = false, length = 100)
    private String displayName;

    /**
     * The source of the external list
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "external_source_sk")
    private ExternalSource externalSource;

    /**
     * The codes associated with the external list
     */
    @OneToMany(mappedBy = "externalListType")
    private List<ExternalListDetail> externalListDetailList;

    /**
     * The crosswalk of the external list type with the internal list type
     */
    @OneToMany(mappedBy = "externalListType")
    private List<ListTypeXWalk> xWalkList;

    /**
     * The date when the record was created
     */
    @CreationTimestamp
    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    /**
     * The date when the record was updated
     */
    @UpdateTimestamp
    @Column(name = "updated_date", nullable = true)
    private LocalDateTime updatedDate;

    /**
     * The toString method
     * @return
     */
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

    /**
     * The equals method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalListType that = (ExternalListType) o;
        return externalListTypeSK.equals(that.externalListTypeSK);
    }

    /**
     * The hashcode method
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(externalListTypeSK);
    }
}
