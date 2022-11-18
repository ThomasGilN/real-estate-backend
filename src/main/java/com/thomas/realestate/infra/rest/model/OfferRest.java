package com.thomas.realestate.infra.rest.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferRest {
    private Long id;
    private RealEstateRest realEstate;
    private Double price;
    private String  type;
    private String locationPrivacy;
    private String description;
    private LocalDateTime creationDate;
    private String intermediary;
    private String phone;
    private String email;
}
