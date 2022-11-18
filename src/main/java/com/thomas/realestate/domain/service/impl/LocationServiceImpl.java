package com.thomas.realestate.domain.service.impl;

import com.thomas.realestate.application.repository.LocationRepository;
import com.thomas.realestate.domain.model.City;
import com.thomas.realestate.domain.model.District;
import com.thomas.realestate.domain.model.Zone;
import com.thomas.realestate.domain.service.LocationService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public List<City> getCities() {
        return locationRepository.getCities();
    }

    @Override
    public List<District> getDistricts() {
        return locationRepository.getDistricts();
    }

    @Override
    public List<Zone> getZones() {
        return locationRepository.getZones();
    }
}
