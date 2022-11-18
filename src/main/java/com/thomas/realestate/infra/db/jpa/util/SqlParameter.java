package com.thomas.realestate.infra.db.jpa.util;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SqlParameter<ValueType> {

    private String column;
    private String name;
    private ValueType value;
}
