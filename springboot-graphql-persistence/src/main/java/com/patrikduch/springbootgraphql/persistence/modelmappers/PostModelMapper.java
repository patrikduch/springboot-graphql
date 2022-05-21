package com.patrikduch.springbootgraphql.persistence.modelmappers;

import com.patrikduch.domain.dtos.PostDto;
import com.patrikduch.domain.entities.PostEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for PostEntity to PostDto object.
 * @author Patrik Duch
 */
@Component
public class PostModelMapper {

    /**
     * Transform Post entity list to PostDTO list.
     * @author Patrik Duch
     * @param posts Entity list object.
     * @return Transformed List object.
     */
    public List<PostDto> transformPostList(List<PostEntity> posts) {
        var modelMapper = new ModelMapper();

        return posts
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

}
