package com.zeus.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class ExternalSource {

    @Id
    @GeneratedValue
    private Long externalSourceSK;

    private String externalSourceCode;

    private String externalSourceName;

    private String externalSourceDesc;

    @OneToMany(mappedBy = "externalSource")
    private List<ExternalListType> externalListTypes;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
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
