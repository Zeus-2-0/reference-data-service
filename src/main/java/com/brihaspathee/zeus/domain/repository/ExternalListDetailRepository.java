package com.brihaspathee.zeus.domain.repository;

import com.brihaspathee.zeus.domain.entity.ExternalListDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, December 2021
 * Time: 5:14 PM
 * Project: Zeus
 * Package Name: com.zeus.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface ExternalListDetailRepository extends JpaRepository<ExternalListDetail, Long> {
}
