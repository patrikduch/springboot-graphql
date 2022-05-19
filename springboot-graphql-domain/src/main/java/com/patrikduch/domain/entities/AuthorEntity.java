package com.patrikduch.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Mapped relation entity "Author" for displaying current post authors.
 * @author Patrik Duch
 */
@Builder
@Getter
@Setter
public class AuthorEntity {
    private String id;
    private String name;
    private String email;
    private List<PostEntity> posts;
}
