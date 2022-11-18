package com.thomas.realestate.infra.db.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CONDOMINIUM")
@Getter
@Setter
public class CondominiumEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "zone_id", referencedColumnName = "id", updatable = false, nullable = false)
    private ZoneEntity zone;

    private String address;
    private String zipCode;
    private String name;
    private Float latitude;
    private Float longitude;
    private Short builtYear;
}
