package com.thomas.realestate.domain.service;

import com.thomas.realestate.domain.model.OfferRequest;

import java.util.List;

public interface OfferRequestService {

    List<OfferRequest> findOfferRequests(Long offerId);

    OfferRequest create(OfferRequest offerRequest);
}
