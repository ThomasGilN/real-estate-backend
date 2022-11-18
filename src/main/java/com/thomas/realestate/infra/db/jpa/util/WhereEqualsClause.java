package com.thomas.realestate.infra.db.jpa.util;

import static com.thomas.realestate.infra.db.jpa.util.SqlConstants.EQUAL;

public class WhereEqualsClause extends WhereClause<Object> {
    @Override
    boolean shouldCreateClause(final Object value) {
        boolean isValidParam = value != null;
        if(!isValidParam && value instanceof String){
            isValidParam = ((String) value).isBlank();
        }
        return isValidParam;
    }

    @Override
    String buildClause(final SqlParameter<Object> parameter) {
        return parameter.getColumn() + EQUAL + parameter.getName();
    }
}
