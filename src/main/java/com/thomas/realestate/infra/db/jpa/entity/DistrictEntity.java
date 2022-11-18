package com.thomas.realestate.infra.db.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DISTRICT")
@Getter
@Setter
public class DistrictEntity {

    @Id  @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", updatable = false, nullable = false)
    private CityEntity city;

    private String name;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private Set<ZoneEntity> zones;
}
