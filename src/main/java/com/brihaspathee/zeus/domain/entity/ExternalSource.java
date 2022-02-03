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

    @Id
    @GeneratedValue
    @Column(name = "external_source_sk", nullable = false, updatable = false)
    private Long externalSourceSK;

    @Column(name = "external_source_code", nullable = false, length = 100, unique = true)
    private String externalSourceCode;

    @Column(name = "external_source_name", nullable = false, length = 100, unique = true)
    private String externalSourceName;

    @Column(name = "external_source_desc", nullable = true, length = 100)
    private String externalSourceDesc;

    @OneToMany(mappedBy = "externalSource")
    private List<ExternalListType> externalListTypes;

    @CreationTimestamp
    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = true)
    private LocalDateTime updatedDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalSource that = (ExternalSource) o;
        return externalSourceSK.equals(that.externalSourceSK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalSourceSK);
    }
}
