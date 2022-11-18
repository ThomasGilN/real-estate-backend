package com.thomas.realestate.infra.rest.controller;

import com.thomas.realestate.application.usecase.GetOfferUseCase;
import com.thomas.realestate.infra.rest.model.OfferRest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("offer")
public class OfferController {

    private final GetOfferUseCase getOfferUseCase;

    @GetMapping
    public List<OfferRest> getOffers(
            @RequestParam final String type,
            @RequestParam final Long cityId,
            @RequestParam(required = false) final List<Long> districtIds,
            @RequestParam(required = false) final List<Long> zoneIds
    ){
        return getOfferUseCase.getOffersBy(type, cityId, districtIds, zoneIds);
    }
}
