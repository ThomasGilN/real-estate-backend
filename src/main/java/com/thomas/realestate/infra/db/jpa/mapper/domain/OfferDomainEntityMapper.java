package com.thomas.realestate.infra.db.jpa.mapper.domain;

import com.thomas.realestate.domain.model.*;
import com.thomas.realestate.infra.common.DomainModelMapper;
import com.thomas.realestate.infra.db.jpa.entity.OfferEntity;

public class OfferDomainEntityMapper extends DomainModelMapper<OfferEntity, Offer> {

    public OfferEntity mapFromDomain(final Offer offer){
        return null;
    }

    public Offer mapToDomain(final OfferEntity targetObject){
        final var realEstateEntity = targetObject.getRealEstate();
        final var condominiumEntity = realEstateEntity.getCondominium();
        final var zoneEntity = condominiumEntity.getZone();
        final var districtEntity = zoneEntity.getDistrict();
        final var cityEntity = districtEntity.getCity();
        return Offer.builder()
                .id(targetObject.getId())
                .realEstate(
                        RealEstate.builder()
                                .id(realEstateEntity.getId())
                                .condominium(
                                        Condominium.builder()
                                                .id(condominiumEntity.getId())
                                                .zone(
                                                        Zone.builder()
                                                                .id(zoneEntity.getId())
                                                                .name(zoneEntity.getName())
                                                                .district(
                                                                        District.builder()
                                                                                .id(districtEntity.getId())
                                                                                .name(districtEntity.getName())
                                                                                .city(
                                                                                        City.builder()
                                                                                                .id(cityEntity.getId())
                                                                                                .name(cityEntity.getName())
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                                .address(condominiumEntity.getAddress())
                                                .zipCode(condominiumEntity.getZipCode())
                                                .name(condominiumEntity.getName())
                                                .latitude(condominiumEntity.getLatitude())
                                                .longitude(condominiumEntity.getLongitude())
                                                .builtYear(condominiumEntity.getBuiltYear())
                                                .build()
                                )
                                .doorNumber(realEstateEntity.getDoorNumber())
                                .floorNumber(realEstateEntity.getFloorNumber())
                                .stairNumber(realEstateEntity.getStairNumber())
                                .buildingNumber(realEstateEntity.getBuildingNumber())
                                .builtArea(realEstateEntity.getBuiltArea())
                                .availableArea(realEstateEntity.getAvailableArea())
                                .terracesArea(realEstateEntity.getTerracesArea())
                                .rooms(realEstateEntity.getRooms())
                                .baths(realEstateEntity.getBaths())
                                .terraces(realEstateEntity.getTerraces())
                                .build()
                )
                .price(targetObject.getPrice())
                .type(OfferType.valueOf(targetObject.getType()))
                .locationPrivacy(LocationPrivacyType.valueOf(targetObject.getLocationPrivacy()))
                .description(targetObject.getDescription())
                .creationDate(targetObject.getCreationDate())
                .intermediary(targetObject.getIntermediary())
                .phone(targetObject.getPhone())
                .email(targetObject.getEmail())
                .build();
    }
}
