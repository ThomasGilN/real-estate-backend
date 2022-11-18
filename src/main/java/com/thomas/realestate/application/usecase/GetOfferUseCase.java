package com.thomas.realestate.application.usecase;

import com.thomas.realestate.infra.rest.model.OfferRest;

import java.util.List;

public interface GetOfferUseCase {

    List<OfferRest> getOffersBy(
            String type,
            Long cityId,
            List<Long> districtIds,
            List<Long> zoneIds
    );
}
