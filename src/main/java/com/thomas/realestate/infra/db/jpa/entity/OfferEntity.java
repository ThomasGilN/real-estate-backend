package com.thomas.realestate.infra.db.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "OFFER")
@Getter
@Setter
public class OfferEntity {

    @Id  @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "real_estate_id", referencedColumnName = "id", updatable = false, nullable = false)
    private RealEstateEntity realEstate;

    @OneToMany(mappedBy = "offer", fetch = FetchType.LAZY)
    private Set<OfferRequestEntity> requests;

    private Double price;
    private String type;
    private String locationPrivacy;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime endDate;
    private String intermediary;
    private String phone;
    private String email;
}
