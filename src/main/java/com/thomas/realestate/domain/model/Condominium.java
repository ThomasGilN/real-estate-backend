package com.thomas.realestate.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Condominium {
    private Long id;
    private Zone zone;
    private String address;
    private String zipCode;
    private String name;
    private Float latitude;
    private Float longitude;
    private Short builtYear;
}
