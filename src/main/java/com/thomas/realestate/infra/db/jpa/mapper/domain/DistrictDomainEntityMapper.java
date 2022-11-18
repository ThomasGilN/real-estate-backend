package com.thomas.realestate.infra.db.jpa.mapper.domain;

import com.thomas.realestate.domain.model.City;
import com.thomas.realestate.domain.model.District;
import com.thomas.realestate.infra.common.DomainModelMapper;
import com.thomas.realestate.infra.db.jpa.entity.DistrictEntity;

public class DistrictDomainEntityMapper extends DomainModelMapper<DistrictEntity, District> {
    @Override
    protected DistrictEntity mapFromDomain(final District domainObject) {
        return null;
    }

    @Override
    protected District mapToDomain(final DistrictEntity targetObject) {
        return District.builder()
                .id(targetObject.getId())
                .name(targetObject.getName())
                .city(
                        City.builder()
                                .id(targetObject.getCity().getId())
                                .build()
                )
                .build();
    }
}
