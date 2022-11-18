package com.thomas.realestate.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SearchCriteria {
    private OfferType offerType;
    private Long cityId;
    private List<Long> districtIds;
    private List<Long> zoneIds;
}
