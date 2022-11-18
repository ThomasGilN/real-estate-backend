package com.thomas.realestate.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RealEstate {
    private Long id;
    private Condominium condominium;
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
