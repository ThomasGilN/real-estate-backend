package com.thomas.realestate.application.repository;

import com.thomas.realestate.domain.model.OfferRequest;

import java.util.List;

public interface OfferRequestRepository {
    List<OfferRequest> findByOfferId(Long offerId);
    OfferRequest create(OfferRequest offerRequest);
}
