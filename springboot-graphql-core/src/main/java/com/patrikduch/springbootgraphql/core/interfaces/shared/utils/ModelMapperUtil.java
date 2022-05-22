package com.patrikduch.springbootgraphql.core.interfaces.shared.utils;

import java.util.List;

/**
 * Contract for generic ModelMapperUtil class for transforming entity to dto objects.
 * @author Patrik Duch
 */
public interface ModelMapperUtil<TSource, TDestination> {
    TDestination transformToDto(TSource entity);
    List<TDestination> transformToDto(List<TSource> entityList);
}
