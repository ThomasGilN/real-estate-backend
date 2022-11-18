package com.thomas.realestate.infra.db.jpa.mapper.domain;

import com.thomas.realestate.domain.model.OfferRequest;
import com.thomas.realestate.infra.common.DomainModelMapper;
import com.thomas.realestate.infra.db.jpa.entity.OfferRequestEntity;

public class OfferRequestDomainEntityMapper extends DomainModelMapper<OfferRequestEntity, OfferRequest> {
    public OfferRequestEntity mapFromDomain(final OfferRequest offerRequest){
        return null;
    }

    public OfferRequest mapToDomain(final OfferRequestEntity targetObject){
        return null;
    }
}
