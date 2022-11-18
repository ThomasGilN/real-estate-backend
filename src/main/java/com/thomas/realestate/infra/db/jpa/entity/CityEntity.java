package com.thomas.realestate.infra.db.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CITY")
@Getter
@Setter
public class CityEntity {

    @Id  @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<DistrictEntity> districts;
}
