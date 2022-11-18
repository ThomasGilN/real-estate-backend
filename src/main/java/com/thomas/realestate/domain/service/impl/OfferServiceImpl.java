package com.thomas.realestate.domain.service.impl;

import com.thomas.realestate.application.repository.OfferRepository;
import com.thomas.realestate.domain.model.Offer;
import com.thomas.realestate.domain.model.SearchCriteria;
import com.thomas.realestate.domain.service.OfferService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository repository;
    @Override
    public List<Offer> findBy(final SearchCriteria searchCriteria) {
        return repository.findBy(searchCriteria);
    }

    @Override
    public Offer create(final Offer offer) {
        return repository.create(offer);
    }
}
