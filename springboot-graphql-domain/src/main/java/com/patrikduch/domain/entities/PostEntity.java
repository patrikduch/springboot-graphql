package com.patrikduch.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Mapped relation entity "Post" for displaying current posts.
 * @author Patrik Duch
 */
@Builder
@Getter
@Setter
public class PostEntity {
    private String id;
    private String title;
    private String description;
}
