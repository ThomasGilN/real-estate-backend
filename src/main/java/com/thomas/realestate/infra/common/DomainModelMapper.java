package com.thomas.realestate.infra.common;

import java.util.List;

public abstract class DomainModelMapper<T,D> {

    protected abstract T mapFromDomain(D domainObject);
    protected abstract D mapToDomain(T targetObject);

    public T fromDomain(final D domainObject){
        return domainObject == null ? null : mapFromDomain(domainObject);
    }

    public D toDomain(final T targetObject){
        return targetObject == null ? null : mapToDomain(targetObject);
    }

    public List<T> fromDomainList(final List<D> domainObjectList) {
        return domainObjectList == null ? null : domainObjectList.stream().map(this::fromDomain).toList();
    }

    public List<D> toDomainList(final List<T> targetObjectList) {
        return targetObjectList == null ? null : targetObjectList.stream().map(this::toDomain).toList();
    }
}
