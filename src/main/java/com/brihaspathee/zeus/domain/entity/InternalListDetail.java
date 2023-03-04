package com.brihaspathee.zeus.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    /**
     * Primary key of the table
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "internal_list_dtl_sk", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID internalListDetailSK;

    /**
     * The internal list code
     */
    @Column(name = "internal_list_code", nullable = false)
    private String internalListCode;

    /**
     * A short description of the list code
     */
    @Column(name = "internal_list_code_desc", nullable = true)
    private String internalListCodeDesc;

    /**
     * The display name used in the UI for the list code
     */
    @Column(name = "display_name", nullable = false, length = 100)
    private String displayName;

    /**
     * The list type that the code is associated
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "internal_list_type_sk", nullable = false)
    private InternalListType internalListType;

    /**
     * The crosswalk of the code with the external code
     */
    @OneToMany(mappedBy = "internalListDetail")
    private List<ListDetailXWalk> codeXWalkList;

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
        return "InternalListDetail{" +
                "internalListDetailSK=" + internalListDetailSK +
                ", internalListCode='" + internalListCode + '\'' +
                ", internalListCodeDesc='" + internalListCodeDesc + '\'' +
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
        InternalListDetail that = (InternalListDetail) o;
        return internalListDetailSK.equals(that.internalListDetailSK);
    }

    /**
     * hashcode method
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(internalListDetailSK);
    }
}
