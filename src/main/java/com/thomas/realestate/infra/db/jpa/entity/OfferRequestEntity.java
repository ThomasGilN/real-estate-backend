package com.thomas.realestate.infra.db.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "OFFER_REQUEST")
@Getter
@Setter
public class OfferRequestEntity {

    @Id  @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "id", updatable = false, nullable = false)
    private OfferEntity offer;

    private String interestedName;
    private String message;
    private String email;
    private String phone;
    private String creationDate;
}
