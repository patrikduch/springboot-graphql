package com.patrikduch.springbootgraphql.shared.utils;

import com.patrikduch.springbootgraphql.core.interfaces.shared.utils.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ModelMapper generical implementation that can be applied for all entities.
 * @author Patrik Duch
 * @param <TSource> Source object (entity object).
 * @param <TDestination> Destination object (dto object).
 */
public class ModelMapperUtilImpl<TSource, TDestination> implements ModelMapperUtil<TSource, TDestination> {

    private Class<TDestination> destinationClass;
    private ModelMapper modelMapper;

    public ModelMapperUtilImpl(Class<TDestination> destinationClass) {
        this.destinationClass = destinationClass;
        this.modelMapper = new ModelMapper();
    }

    /**
     * Transform entity object into DTO.
     * @author Patrik Duch
     * @param entity Entity object, that will be mapped into new DTO.
     * @return DTO object.
     */
    @Override
    public TDestination transformToDto(TSource entity) {
        return this.modelMapper.map(entity, destinationClass);
    }

    /**
     * Transform list of entities into DTO list.
     * @author Patrik Duch
     * @param entityList Entity list of objects, that will be mapped into new DTO list.
     * @return DTO list of objets.
     */
    @Override
    public List<TDestination> transformToDto(List<TSource> entityList) {

        return entityList
                .stream()
                .map(item -> modelMapper.map(item, destinationClass))
                .collect(Collectors.toList());
    }

}
