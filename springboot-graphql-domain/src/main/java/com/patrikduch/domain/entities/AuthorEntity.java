package com.patrikduch.domain.entities;

import lombok.*;
import java.util.List;
import java.util.UUID;

/**
 * Mapped relation entity "Author" for displaying current post authors.
 * @author Patrik Duch
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    private UUID id;
    private String name;
    private String email;
    private List<PostEntity> posts;
}
