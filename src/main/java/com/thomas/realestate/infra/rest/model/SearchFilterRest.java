package com.thomas.realestate.infra.rest.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchFilterRest {
    private Long id;
    private String value;
    private List<SearchFilterRest> children = new ArrayList<>();
}
