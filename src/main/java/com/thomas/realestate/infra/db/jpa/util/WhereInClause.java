package com.thomas.realestate.infra.db.jpa.util;

import java.util.List;

import static com.thomas.realestate.infra.db.jpa.util.SqlConstants.*;

public class WhereInClause extends WhereClause<List<?>> {

    @Override
    boolean shouldCreateClause(final List<?> value) {
        return value != null && !value.isEmpty();
    }

    @Override
    String buildClause(final SqlParameter<List<?>> parameter) {
        return parameter.getColumn() + IN + RIGHT_PARENTHESIS + parameter.getName() + LEFT_PARENTHESIS;
    }
}
