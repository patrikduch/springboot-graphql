package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.PostDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.PostDao;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.PostFn;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class PostDaoImpl implements PostDao {

    private final PostFn postFn;

    @Override
    public List<PostDto> fetchPosts(String warehouseId) {
        var posts = postFn.getPosts(warehouseId);

        var modelMapper = new ModelMapper();

        return posts
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> fetchPostsByAuthorId() {
        return null;
    }
}
