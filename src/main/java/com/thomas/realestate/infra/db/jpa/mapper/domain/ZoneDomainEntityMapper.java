package com.thomas.realestate.infra.db.jpa.mapper.domain;

import com.thomas.realestate.domain.model.District;
import com.thomas.realestate.domain.model.Zone;
import com.thomas.realestate.infra.common.DomainModelMapper;
import com.thomas.realestate.infra.db.jpa.entity.ZoneEntity;

public class ZoneDomainEntityMapper extends DomainModelMapper<ZoneEntity, Zone> {
    @Override
    protected ZoneEntity mapFromDomain(final Zone domainObject) {
        return null;
    }

    @Override
    protected Zone mapToDomain(final ZoneEntity targetObject) {
        return Zone.builder()
                .id(targetObject.getId())
                .name(targetObject.getName())
                .district(
                        District.builder()
                                .id(targetObject.getDistrict().getId())
                                .build()
                )
                .build();
    }
}
