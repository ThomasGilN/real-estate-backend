package com.thomas.realestate.infra.configuration;

import com.thomas.realestate.application.repository.LocationRepository;
import com.thomas.realestate.application.repository.OfferRepository;
import com.thomas.realestate.application.repository.OfferRequestRepository;
import com.thomas.realestate.domain.service.LocationService;
import com.thomas.realestate.domain.service.OfferRequestService;
import com.thomas.realestate.domain.service.OfferService;
import com.thomas.realestate.domain.service.impl.LocationServiceImpl;
import com.thomas.realestate.domain.service.impl.OfferRequestServiceImpl;
import com.thomas.realestate.domain.service.impl.OfferServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServicesConfiguration {

    @Bean
    public OfferService offerService(final OfferRepository repository){
        return new OfferServiceImpl(repository);
    }

    @Bean
    public OfferRequestService offerRequestService(final OfferRequestRepository repository){
        return new OfferRequestServiceImpl(repository);
    }

    @Bean
    public LocationService locationService(final LocationRepository repository) {
        return new LocationServiceImpl(repository);
    }
}
