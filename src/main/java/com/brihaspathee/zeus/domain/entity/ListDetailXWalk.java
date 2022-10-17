package com.brihaspathee.zeus.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 30, December 2021
 * Time: 6:36 AM
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
@Table(name = "intrnl_extrnl_dtl_xwalk")
public class ListDetailXWalk {

    /**
     * Primary key of the table
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "list_detail_xwalk", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID listDetailXWalkSK;

    @ManyToOne
    @JoinColumn(name = "list_type_xwalk_sk", nullable = false)
    private ListTypeXWalk listTypeXWalk;

    @ManyToOne
    @JoinColumn(name = "internal_list_dtl_sk", nullable = false)
    private InternalListDetail internalListDetail;

    @ManyToOne
    @JoinColumn(name = "external_list_dtl_sk", nullable = false)
    private ExternalListDetail externalListDetail;

    @CreationTimestamp
    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = true)
    private LocalDateTime updatedDate;

    @Override
    public String toString() {
        return "ListDetailXWalk{" +
                "listDetailXWalkSK=" + listDetailXWalkSK +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListDetailXWalk that = (ListDetailXWalk) o;
        return listDetailXWalkSK.equals(that.listDetailXWalkSK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listDetailXWalkSK);
    }
}
