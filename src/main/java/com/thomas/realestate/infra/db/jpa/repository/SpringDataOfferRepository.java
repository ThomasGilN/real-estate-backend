package com.thomas.realestate.infra.db.jpa.repository;

import com.thomas.realestate.infra.db.jpa.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOfferRepository extends JpaRepository<OfferEntity, Long> {

}
