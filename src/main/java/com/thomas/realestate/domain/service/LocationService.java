package com.thomas.realestate.domain.service;

import com.thomas.realestate.domain.model.City;
import com.thomas.realestate.domain.model.District;
import com.thomas.realestate.domain.model.Zone;

import java.util.List;

public interface LocationService {
    List<City> getCities();
    List<District> getDistricts();
    List<Zone> getZones();
}
