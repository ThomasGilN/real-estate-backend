package com.thomas.realestate.infra.rest.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchFilterPackageRest {
    List<SearchFilterRest> locationFilters;
    List<SearchFilterRest> realStateFilters;
}
