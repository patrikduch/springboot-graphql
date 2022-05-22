package com.patrikduch.domain.entities;

import lombok.*;

import java.util.UUID;

/**
 * Mapped relation entity "Post" for displaying current posts.
 * @author Patrik Duch
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    private UUID id;
    private String title;
    private String description;
    private String warehouseId;
}
