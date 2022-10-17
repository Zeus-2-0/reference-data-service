package com.brihaspathee.zeus.domain.repository;

import com.brihaspathee.zeus.domain.entity.ExternalSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, December 2021
 * Time: 4:53 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface ExternalSourceRepository extends JpaRepository<ExternalSource, UUID> {

    Optional<ExternalSource> findExternalSourceByExternalSourceName(String externalSourceName);
}
