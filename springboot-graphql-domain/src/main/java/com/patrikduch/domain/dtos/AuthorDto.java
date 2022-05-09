package com.patrikduch.domain.dtos;

import lombok.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private UUID id;
    private String name;
    private String email;
    public List<PostDto> posts;
}
