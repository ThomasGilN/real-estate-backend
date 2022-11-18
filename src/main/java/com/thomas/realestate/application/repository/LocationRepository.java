package com.thomas.realestate.application.repository;

import com.thomas.realestate.domain.model.City;
import com.thomas.realestate.domain.model.District;
import com.thomas.realestate.domain.model.Zone;

import java.util.List;

public interface LocationRepository {
    List<City> getCities();
    List<District> getDistricts();
    List<Zone> getZones();
}
