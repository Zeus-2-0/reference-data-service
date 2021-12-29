package com.zeus.domain.repository;

import com.zeus.domain.entity.ExternalSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
public interface ExternalSourceRepository extends JpaRepository<ExternalSource, Long> {

    Optional<ExternalSource> findExternalSourceByExternalSourceName(String externalSourceName);
}
