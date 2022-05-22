package com.patrikduch.springbootgraphql.persistence.plpgsql.functions;

import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.entities.AuthorEntity;
import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.AuthorFn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Preparation of all author's retrieval PLpgSQL functions.
 * @author Patrik Duch
 */
@AllArgsConstructor
@Repository
public class AuthorFnImpl implements AuthorFn {

    private final GenericRepository genericRepository;

    @Override
    public List<AuthorDto> fetchAuthors(String warehouseId) {
        var authorList = new ArrayList<AuthorDto>();
        var sql = "select * from springboot_graphql.get_authors_fn();";

        try {
            var results = genericRepository.callFn(sql, warehouseId);

            while (results.getF2().next()) {  // do something with the results...

                authorList.add(AuthorDto.builder()
                                .email(results.getF2().getString("email"))
                                .id(UUID.fromString(results.getF2().getString("id")))
                                .name(results.getF2().getString("name"))
                                .warehouseId(warehouseId)
                        .build()
                );
            }
            results.getF2().close();
            results.getF1().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authorList;
    }

    @Override
    public AuthorEntity fetchAuthorByPost(String warehouseId, String postId) {
        AuthorEntity author = new AuthorEntity();
        var sql = String.format("select * from springboot_graphql.get_post_author_fn('%s');", postId);

        try {
            var results = genericRepository.callFn(sql, warehouseId);

            while (results.getF2().next()) {  // do something with the results...

               author = AuthorEntity.builder()
                        .id(UUID.fromString(results.getF2().getString("id")))
                        .name(results.getF2().getString("name"))
                        .email(results.getF2().getString("email")).build();

            }
            results.getF2().close();
            results.getF1().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }
}
