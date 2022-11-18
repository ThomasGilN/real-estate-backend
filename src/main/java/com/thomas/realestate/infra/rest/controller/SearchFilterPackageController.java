package com.thomas.realestate.infra.rest.controller;

import com.thomas.realestate.application.usecase.GetSearchFilterPackageUseCase;
import com.thomas.realestate.infra.rest.model.SearchFilterPackageRest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("searchFilterPackage")
@RequiredArgsConstructor
public class SearchFilterPackageController {

    private final GetSearchFilterPackageUseCase getSearchFilterPackageUseCase;

    @GetMapping
    public SearchFilterPackageRest getSearchFilterPackage(){
        return getSearchFilterPackageUseCase.getSearchFilterPackage();
    }

}
