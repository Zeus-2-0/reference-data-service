package com.brihaspathee.zeus.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    /**
     * Primary key of the table
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "external_list_dtl_sk", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID externalListDetailSK;

    /**
     * The external list code
     */
    @Column(name = "external_list_code", nullable = false, length = 100)
    private String externalListCode;

    /**
     * A short description of the code
     */
    @Column(name = "external_list_desc", nullable = true, length = 100)
    private String externalListDesc;

    /**
     * The display name of the code that is used in the UI
     */
    @Column(name = "display_name", nullable = false, length = 100)
    private String displayName;

    /**
     * The external list type that the code is associated with
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "external_list_type_sk")
    private ExternalListType externalListType;

    /**
     * The cross walk with the internal codes that this external code is mapped
     */
    @OneToMany(mappedBy = "externalListDetail")
    private List<ListDetailXWalk> detailXWalkList;

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
        return "ExternalListDetail{" +
                "externalListDetailSK=" + externalListDetailSK +
                ", externalListCode='" + externalListCode + '\'' +
                ", externalListDesc='" + externalListDesc + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    /**
     * The equals method for the external code
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalListDetail that = (ExternalListDetail) o;
        return externalListDetailSK.equals(that.externalListDetailSK);
    }

    /**
     * The hashcode for the external code
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(externalListDetailSK);
    }
}
