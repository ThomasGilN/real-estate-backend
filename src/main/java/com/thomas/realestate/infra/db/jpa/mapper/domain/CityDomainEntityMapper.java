package com.thomas.realestate.infra.db.jpa.mapper.domain;

import com.thomas.realestate.domain.model.City;
import com.thomas.realestate.infra.common.DomainModelMapper;
import com.thomas.realestate.infra.db.jpa.entity.CityEntity;

public class CityDomainEntityMapper extends DomainModelMapper<CityEntity, City> {
    @Override
    protected CityEntity mapFromDomain(final City domainObject) {
        return null;
    }

    @Override
    protected City mapToDomain(final CityEntity targetObject) {
        return City.builder()
                .id(targetObject.getId())
                .name(targetObject.getName())
                .build();
    }
}
