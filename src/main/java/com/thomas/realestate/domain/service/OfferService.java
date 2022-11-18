package com.thomas.realestate.domain.service;

import com.thomas.realestate.domain.model.Offer;
import com.thomas.realestate.domain.model.SearchCriteria;

import java.util.List;

public interface OfferService {

    List<Offer> findBy(SearchCriteria searchCriteria);

    Offer create(Offer offer);
}
