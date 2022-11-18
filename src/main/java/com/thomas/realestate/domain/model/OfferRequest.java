package com.thomas.realestate.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OfferRequest {
    private Long id;
    private Offer offer;
    private String interestedName;
    private String message;
    private String email;
    private String phone;
    private String creationDate;
}
