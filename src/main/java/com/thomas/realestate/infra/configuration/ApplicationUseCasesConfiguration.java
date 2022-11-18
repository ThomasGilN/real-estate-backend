package com.thomas.realestate.infra.configuration;

import com.thomas.realestate.application.usecase.GetOfferUseCase;
import com.thomas.realestate.application.usecase.GetSearchFilterPackageUseCase;
import com.thomas.realestate.application.usecase.impl.GetOfferUseCaseImpl;
import com.thomas.realestate.application.usecase.impl.GetSearchFilterPackageUseCaseImpl;
import com.thomas.realestate.domain.service.LocationService;
import com.thomas.realestate.domain.service.OfferService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationUseCasesConfiguration {

    @Bean
    public GetOfferUseCase getOfferUseCase(final OfferService offerService){
        return new GetOfferUseCaseImpl(offerService);
    }

    @Bean
    public GetSearchFilterPackageUseCase getSearchFilterPackageUseCase(final LocationService locationService){
        return new GetSearchFilterPackageUseCaseImpl(locationService);
    }
}
