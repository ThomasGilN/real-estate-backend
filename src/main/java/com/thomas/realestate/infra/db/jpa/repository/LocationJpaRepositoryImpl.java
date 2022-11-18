package com.thomas.realestate.infra.db.jpa.repository;

import com.thomas.realestate.application.repository.LocationRepository;
import com.thomas.realestate.domain.model.City;
import com.thomas.realestate.domain.model.District;
import com.thomas.realestate.domain.model.Zone;
import com.thomas.realestate.infra.common.DomainModelMapper;
import com.thomas.realestate.infra.db.jpa.entity.CityEntity;
import com.thomas.realestate.infra.db.jpa.entity.DistrictEntity;
import com.thomas.realestate.infra.db.jpa.entity.ZoneEntity;
import com.thomas.realestate.infra.db.jpa.mapper.domain.CityDomainEntityMapper;
import com.thomas.realestate.infra.db.jpa.mapper.domain.DistrictDomainEntityMapper;
import com.thomas.realestate.infra.db.jpa.mapper.domain.ZoneDomainEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Repository
@SuppressWarnings("unchecked")
public class LocationJpaRepositoryImpl implements LocationRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    private final CityDomainEntityMapper cityMapper = new CityDomainEntityMapper();

    private final DistrictDomainEntityMapper districtMapper = new DistrictDomainEntityMapper();

    private final ZoneDomainEntityMapper zoneMapper = new ZoneDomainEntityMapper();

    private static final String SELECT_ALL_CITIES = "SELECT * FROM CITY";
    private static final String SELECT_ALL_DISTRICTS = "SELECT * FROM DISTRICT";
    private static final String SELECT_ALL_ZONES = "SELECT * FROM ZONE";

    @Override
    public List<City> getCities() {
        return getAll(SELECT_ALL_CITIES, CityEntity.class, cityMapper);
    }

    @Override
    public List<District> getDistricts() {
        return getAll(SELECT_ALL_DISTRICTS, DistrictEntity.class, districtMapper);
    }

    @Override
    public List<Zone> getZones() {
        return getAll(SELECT_ALL_ZONES, ZoneEntity.class, zoneMapper);
    }

    private <E,D> List<D> getAll(final String selectSql, final Class<E> entityClass, final DomainModelMapper<E,D> mapper) {
        return mapper.toDomainList(entityManager.createNativeQuery(selectSql, entityClass).getResultList());
    }
}
