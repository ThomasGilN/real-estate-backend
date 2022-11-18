package com.thomas.realestate.infra.db.jpa.util;

public abstract class WhereClause<ParameterValueType> {
    public String createClause(final SqlParameter<ParameterValueType> parameter){
        return shouldCreateClause(parameter.getValue()) ? buildClause(parameter) : "";
    }

    abstract boolean shouldCreateClause(final ParameterValueType value);

    abstract String buildClause(final SqlParameter<ParameterValueType> parameter);
}
