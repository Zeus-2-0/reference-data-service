package com.brihaspathee.zeus.domain.repository;

import com.brihaspathee.zeus.domain.entity.InternalListDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 30, December 2021
 * Time: 6:28 AM
 * Project: Zeus
 * Package Name: com.zeus.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface InternalListDetailRepository extends JpaRepository<InternalListDetail, Long> {
}
