package com.thomas.realestate.application.usecase.impl;

import com.thomas.realestate.application.usecase.GetSearchFilterPackageUseCase;
import com.thomas.realestate.domain.model.City;
import com.thomas.realestate.domain.model.District;
import com.thomas.realestate.domain.model.Zone;
import com.thomas.realestate.domain.service.LocationService;
import com.thomas.realestate.infra.rest.model.SearchFilterPackageRest;
import com.thomas.realestate.infra.rest.model.SearchFilterRest;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class GetSearchFilterPackageUseCaseImpl implements GetSearchFilterPackageUseCase {

    private final LocationService locationService;

    @Override
    public SearchFilterPackageRest getSearchFilterPackage() {
        return SearchFilterPackageRest.builder()
                .locationFilters(getLocationFilters())
                .realStateFilters(getRealStateFilters())
                .build();
    }

    private List<SearchFilterRest> getLocationFilters() {
        final List<City> cities = locationService.getCities();
        final List<District> districts = locationService.getDistricts();
        final List<Zone> zones = locationService.getZones();

        return cities.stream().map(
                city -> {
                    final List<SearchFilterRest> cityDistricts = districts.stream()
                            .filter(district -> city.getId() == district.getCity().getId())
                            .map(
                                    district -> {
                                        final List<SearchFilterRest> districtZones = zones.stream()
                                                .filter(zone -> district.getId() == zone.getDistrict().getId())
                                                .map(
                                                        zone -> SearchFilterRest.builder()
                                                                .id(zone.getId())
                                                                .value(zone.getName())
                                                                .build()
                                                )
                                                .toList();
                                        return SearchFilterRest.builder()
                                                .id(district.getId())
                                                .value(district.getName())
                                                .children(districtZones)
                                                .build();
                                    }
                            ).toList();
                    return SearchFilterRest.builder()
                            .id(city.getId())
                            .value(city.getName())
                            .children(cityDistricts)
                            .build();
                }
        ).toList();
    }

    private List<SearchFilterRest> getRealStateFilters() {
        return Collections.emptyList();
    }
}
