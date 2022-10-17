package com.brihaspathee.zeus.domain.repository;

import com.brihaspathee.zeus.domain.entity.ExternalListType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, December 2021
 * Time: 5:03 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface ExternalListTypeRepository extends JpaRepository<ExternalListType, UUID> {

    Optional<ExternalListType> findExternalListTypeByExternalListTypeName(String externalListTypeName);
}
