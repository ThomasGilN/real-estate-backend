package com.thomas.realestate.infra.db.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.thomas.realestate.infra.db.jpa.util.SqlConstants.*;

public class QueryBuilder {
    private final String sqlBase;
    private final List<String> whereClauses = new ArrayList<>();
    private final Map<String, Object> usedParameters = new HashMap<>();

    public QueryBuilder(final String sqlBase) {
        this.sqlBase = sqlBase;
    }

    public <ParameterValueType> QueryBuilder withParameter(final SqlParameter<ParameterValueType> parameter, final WhereClause<ParameterValueType> whereClause){
       final String whereStatement = whereClause.createClause(parameter);
        if(!whereStatement.isBlank()) {
            whereClauses.add(whereStatement);
            usedParameters.put(parameter.getName(), parameter.getValue());
        }
        return this;
    }

    public Query build(final EntityManager entityManager, final Class<?> resultEntityClass){
        final String sql = sqlBase + (whereClauses.isEmpty() ? "" : WHERE) + String.join(AND, whereClauses);
        final Query query = entityManager.createNativeQuery(sql, resultEntityClass);

        for(final String paramName : usedParameters.keySet()){
            query.setParameter(paramName.replace(":", ""), usedParameters.get(paramName));
        }
        return query;
    }
}
