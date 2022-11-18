package com.thomas.realestate.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Offer {
    private Long id;
    private RealEstate realEstate;
    private Double price;
    private OfferType type;
    private LocationPrivacyType locationPrivacy;
    private String description;
    private LocalDateTime creationDate;
    private String intermediary;
    private String phone;
    private String email;
}
