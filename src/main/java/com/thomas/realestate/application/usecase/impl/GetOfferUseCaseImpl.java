package com.thomas.realestate.application.usecase.impl;

import com.thomas.realestate.infra.rest.mapper.OfferDomainRestMapper;
import com.thomas.realestate.infra.rest.model.OfferRest;
import com.thomas.realestate.application.usecase.GetOfferUseCase;
import com.thomas.realestate.domain.model.OfferType;
import com.thomas.realestate.domain.model.SearchCriteria;
import com.thomas.realestate.domain.service.OfferService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetOfferUseCaseImpl implements GetOfferUseCase {

    private final OfferService offerService;
    private final OfferDomainRestMapper domainMapper = new OfferDomainRestMapper();

    @Override
    public List<OfferRest> getOffersBy(
            final String type,
            final Long cityId,
            final List<Long> districtIds,
            final List<Long> zoneIds
    ) {
        final SearchCriteria searchCriteria = SearchCriteria.builder()
                .offerType(OfferType.valueOf(type))
                .cityId(cityId)
                .districtIds(districtIds)
                .zoneIds(zoneIds)
                .build();

        return domainMapper.fromDomainList(offerService.findBy(searchCriteria));
    }
}
