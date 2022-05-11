package com.patrikduch.domain.dtos;

import lombok.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder // for enabling Builder pattern
@NoArgsConstructor // for creating constructor without arguments
@AllArgsConstructor // for creating all constructors
public class AuthorDto {
    private UUID id;
    private String name;
    private String email;
    public List<PostDto> posts;
}
