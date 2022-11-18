package com.thomas.realestate.infra.db.jpa.repository;

import com.thomas.realestate.application.repository.OfferRepository;
import com.thomas.realestate.domain.model.Offer;
import com.thomas.realestate.domain.model.SearchCriteria;
import com.thomas.realestate.infra.db.jpa.entity.OfferEntity;
import com.thomas.realestate.infra.db.jpa.mapper.domain.OfferDomainEntityMapper;
import com.thomas.realestate.infra.db.jpa.util.QueryBuilder;
import com.thomas.realestate.infra.db.jpa.util.SqlParameter;
import com.thomas.realestate.infra.db.jpa.util.WhereEqualsClause;
import com.thomas.realestate.infra.db.jpa.util.WhereInClause;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class OfferJpaRepositoryImpl implements OfferRepository {

    @PersistenceContext
    private final EntityManager entityManager;
    private final SpringDataOfferRepository springDataOfferRepository;
    private final OfferDomainEntityMapper domainMapper = new OfferDomainEntityMapper();

    static final String SELECT_OFFERS = "SELECT * FROM OFFER O";

    static final String SELECT_OFFERS_WITH_DETAIL = SELECT_OFFERS
            + " INNER JOIN REAL_ESTATE RE ON RE.ID = O.REAL_ESTATE_ID"
            + " INNER JOIN CONDOMINIUM C ON C.ID = RE.CONDOMINIUM_ID"
            + " INNER JOIN ZONE Z ON Z.ID = C.ZONE_ID"
            + " INNER JOIN DISTRICT D ON D.ID = Z.DISTRICT_ID"
            + " INNER JOIN CITY CI ON CI.ID = D.CITY_ID";

    @Override
    public List<Offer> findBy(final SearchCriteria searchCriteria) {
        final Query query = new QueryBuilder(SELECT_OFFERS_WITH_DETAIL)
                .withParameter(
                        SqlParameter.builder()
                                .column("O.TYPE")
                                .name(":offerType")
                                .value(searchCriteria.getOfferType().name())
                                .build(),
                        new WhereEqualsClause()
                )
                .withParameter(
                        SqlParameter.builder()
                                .column("CI.ID")
                                .name(":cityId")
                                .value(searchCriteria.getCityId())
                                .build(),
                        new WhereEqualsClause()
                )
                .withParameter(
                        SqlParameter.<List<?>>builder()
                                .column("Z.ID")
                                .name(":zoneIds")
                                .value(searchCriteria.getZoneIds())
                                .build(),
                        new WhereInClause()
                )
                .withParameter(
                        SqlParameter.<List<?>>builder()
                                .column("D.ID")
                                .name(":districtIds")
                                .value(searchCriteria.getDistrictIds())
                                .build(),
                        new WhereInClause()
                )
                .build(entityManager, OfferEntity.class);

        return domainMapper.toDomainList(query.getResultList());
    }

    @Override
    public Offer create(final Offer offer) {
        return domainMapper.toDomain(springDataOfferRepository.saveAndFlush(domainMapper.fromDomain(offer)));
    }
}
