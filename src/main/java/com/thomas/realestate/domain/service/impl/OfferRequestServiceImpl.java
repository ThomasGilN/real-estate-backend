package com.thomas.realestate.domain.service.impl;

import com.thomas.realestate.application.repository.OfferRequestRepository;
import com.thomas.realestate.domain.model.OfferRequest;
import com.thomas.realestate.domain.service.OfferRequestService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OfferRequestServiceImpl implements OfferRequestService {

    private final OfferRequestRepository offerRequestRepository;

    @Override
    public List<OfferRequest> findOfferRequests(final Long offerId) {
        return offerRequestRepository.findByOfferId(offerId);
    }

    @Override
    public OfferRequest create(final OfferRequest offerRequest) {
        return offerRequestRepository.create(offerRequest);
    }
}
