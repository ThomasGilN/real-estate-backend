package com.thomas.realestate.infra.rest.mapper;

import com.thomas.realestate.domain.model.*;
import com.thomas.realestate.infra.common.DomainModelMapper;
import com.thomas.realestate.infra.rest.model.CondominiumRest;
import com.thomas.realestate.infra.rest.model.OfferRest;
import com.thomas.realestate.infra.rest.model.RealEstateRest;

public class OfferDomainRestMapper extends DomainModelMapper<OfferRest, Offer> {
    @Override
    public OfferRest mapFromDomain(final Offer domainObject) {
        final var domainRealEstate = domainObject.getRealEstate();
        final var domainCondominium = domainRealEstate.getCondominium();
        final var domainZone = domainCondominium.getZone();
        final var domainDistrict = domainZone.getDistrict();
        final var domainCity = domainDistrict.getCity();

        return OfferRest.builder()
                .id(domainObject.getId())
                .realEstate(
                        RealEstateRest.builder()
                                .id(domainRealEstate.getId())
                                .condominium(
                                        CondominiumRest.builder()
                                                .id(domainCondominium.getId())
                                                .zoneId(domainZone.getId())
                                                .zoneName(domainZone.getName())
                                                .districtId(domainDistrict.getId())
                                                .districtName(domainDistrict.getName())
                                                .cityId(domainCity.getId())
                                                .cityName(domainCity.getName())
                                                .address(domainCondominium.getAddress())
                                                .zipCode(domainCondominium.getZipCode())
                                                .name(domainCondominium.getName())
                                                .latitude(domainCondominium.getLatitude())
                                                .longitude(domainCondominium.getLongitude())
                                                .builtYear(domainCondominium.getBuiltYear())
                                                .build()
                                )
                                .doorNumber(domainRealEstate.getDoorNumber())
                                .floorNumber(domainRealEstate.getFloorNumber())
                                .stairNumber(domainRealEstate.getStairNumber())
                                .buildingNumber(domainRealEstate.getBuildingNumber())
                                .builtArea(domainRealEstate.getBuiltArea())
                                .availableArea(domainRealEstate.getAvailableArea())
                                .terracesArea(domainRealEstate.getTerracesArea())
                                .rooms(domainRealEstate.getRooms())
                                .baths(domainRealEstate.getBaths())
                                .terraces(domainRealEstate.getTerraces())
                                .build()
                )
                .price(domainObject.getPrice())
                .type(domainObject.getType().name())
                .locationPrivacy(domainObject.getLocationPrivacy().name())
                .description(domainObject.getDescription())
                .creationDate(domainObject.getCreationDate())
                .intermediary(domainObject.getIntermediary())
                .phone(domainObject.getPhone())
                .email(domainObject.getEmail())
                .build();
    }

    @Override
    public Offer mapToDomain(final OfferRest targetObject) {
        final var realEstateRest = targetObject.getRealEstate();
        final var condominiumRest = realEstateRest.getCondominium();
        return Offer.builder()
                .id(targetObject.getId())
                .realEstate(
                        RealEstate.builder()
                                .id(realEstateRest.getId())
                                .condominium(
                                        Condominium.builder()
                                                .id(condominiumRest.getId())
                                                .zone(
                                                        Zone.builder()
                                                                .id(condominiumRest.getZoneId())
                                                                .name(condominiumRest.getZoneName())
                                                                .district(
                                                                        District.builder()
                                                                                .id(condominiumRest.getDistrictId())
                                                                                .name(condominiumRest.getDistrictName())
                                                                                .city(
                                                                                        City.builder()
                                                                                                .id(condominiumRest.getCityId())
                                                                                                .name(condominiumRest.getCityName())
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                                .address(condominiumRest.getAddress())
                                                .zipCode(condominiumRest.getZipCode())
                                                .name(condominiumRest.getName())
                                                .latitude(condominiumRest.getLatitude())
                                                .longitude(condominiumRest.getLongitude())
                                                .builtYear(condominiumRest.getBuiltYear())
                                                .build()
                                )
                                .doorNumber(realEstateRest.getDoorNumber())
                                .floorNumber(realEstateRest.getFloorNumber())
                                .stairNumber(realEstateRest.getStairNumber())
                                .buildingNumber(realEstateRest.getBuildingNumber())
                                .builtArea(realEstateRest.getBuiltArea())
                                .availableArea(realEstateRest.getAvailableArea())
                                .terracesArea(realEstateRest.getTerracesArea())
                                .rooms(realEstateRest.getRooms())
                                .baths(realEstateRest.getBaths())
                                .terraces(realEstateRest.getTerraces())
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
