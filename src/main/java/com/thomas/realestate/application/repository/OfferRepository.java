package com.thomas.realestate.application.repository;

import com.thomas.realestate.domain.model.Offer;
import com.thomas.realestate.domain.model.SearchCriteria;

import java.util.List;

public interface OfferRepository {

    List<Offer> findBy(SearchCriteria searchCriteria);

    Offer create(Offer offer);
}
