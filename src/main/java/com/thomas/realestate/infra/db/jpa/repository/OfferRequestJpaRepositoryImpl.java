package com.thomas.realestate.infra.db.jpa.repository;

import com.thomas.realestate.application.repository.OfferRequestRepository;
import com.thomas.realestate.domain.model.OfferRequest;
import com.thomas.realestate.infra.db.jpa.mapper.domain.OfferRequestDomainEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OfferRequestJpaRepositoryImpl implements OfferRequestRepository {

    private final SpringDataOfferRequestRepository springDataOfferRequestRepository;
    private final OfferRequestDomainEntityMapper domainMapper = new OfferRequestDomainEntityMapper();

    @Override
    public List<OfferRequest> findByOfferId(final Long offerId) {
        return domainMapper.toDomainList(springDataOfferRequestRepository.findByOfferId(offerId));
    }

    @Override
    public OfferRequest create(final OfferRequest offerRequest) {
        return domainMapper.toDomain(
                springDataOfferRequestRepository.saveAndFlush(domainMapper.fromDomain(offerRequest))
        );
    }
}
