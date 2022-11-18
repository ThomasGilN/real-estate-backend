package com.thomas.realestate.infra.rest.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealEstateRest {
    private Long id;
    private CondominiumRest condominium;
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
