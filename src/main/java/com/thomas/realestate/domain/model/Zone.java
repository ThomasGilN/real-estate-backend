package com.thomas.realestate.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Zone {
    private long id;
    private String name;
    private District district;
}
