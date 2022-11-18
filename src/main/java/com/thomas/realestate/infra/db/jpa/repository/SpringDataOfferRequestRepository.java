package com.thomas.realestate.infra.db.jpa.repository;

import com.thomas.realestate.infra.db.jpa.entity.OfferRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataOfferRequestRepository extends JpaRepository<OfferRequestEntity, Long> {

    List<OfferRequestEntity> findByOfferId(Long orderId);
}
