package com.thomas.realestate.infra.db.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "REAL_ESTATE")
@Getter
@Setter
public class RealEstateEntity {

    @Id  @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "condominium_id", referencedColumnName = "id", updatable = false, nullable = false)
    private CondominiumEntity condominium;

    private String doorNumber;
    private String floorNumber;
    private String stairNumber;
    private String buildingNumber;
    private Short builtArea;
    private Short availableArea;
    private Short terracesArea;
    private Byte rooms;
    private Byte baths;
    private Byte terraces;
}
