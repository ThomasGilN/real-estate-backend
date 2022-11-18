package com.thomas.realestate.infra.db.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ZONE")
@Getter
@Setter
public class ZoneEntity {

    @Id  @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id", updatable = false, nullable = false)
    private DistrictEntity district;

    private String name;
}
