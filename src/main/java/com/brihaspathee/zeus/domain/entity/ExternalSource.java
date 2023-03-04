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
 * Time: 4:45 PM
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
@Table(name = "external_source")
public class ExternalSource {

    /**
     * Primary key of the table
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(Types.LONGVARCHAR)
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "external_source_sk", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID externalSourceSK;

    /**
     * The code of the external source. E.g. 1 - Marketplace, 2 - Medicare
     */
    @Column(name = "external_source_code", nullable = false, length = 100, unique = true)
    private String externalSourceCode;

    /**
     * The name for the external source
     */
    @Column(name = "external_source_name", nullable = false, length = 100, unique = true)
    private String externalSourceName;

    /**
     * A short description for the external source
     */
    @Column(name = "external_source_desc", nullable = true, length = 100)
    private String externalSourceDesc;

    /**
     * The list of external types that are associated with the external source
     */
    @OneToMany(mappedBy = "externalSource")
    private List<ExternalListType> externalListTypes;

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
     * To string method
     * @return
     */
    @Override
    public String toString() {
        return "ExternalSource{" +
                "externalSourceSK=" + externalSourceSK +
                ", externalSourceCode='" + externalSourceCode + '\'' +
                ", externalSourceName='" + externalSourceName + '\'' +
                ", externalSourceDesc='" + externalSourceDesc + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    /**
     * Equals method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalSource that = (ExternalSource) o;
        return externalSourceSK.equals(that.externalSourceSK);
    }

    /**
     * Hashcode method
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(externalSourceSK);
    }
}
