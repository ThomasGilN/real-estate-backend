package com.thomas.realestate.infra.rest.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CondominiumRest {
    private Long id;
    private Long zoneId;
    private String zoneName;
    private Long districtId;
    private String districtName;
    private Long cityId;
    private String cityName;
    private String address;
    private String zipCode;
    private String name;
    private Float latitude;
    private Float longitude;
    private Short builtYear;
}
