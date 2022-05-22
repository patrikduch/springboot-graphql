package com.patrikduch.domain.dtos.app.author;

import com.patrikduch.domain.dtos.app.post.PostListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Data
@Builder // for enabling Builder pattern
@NoArgsConstructor // for creating constructor without arguments
@AllArgsConstructor // for creating all constructors
public class AuthorItemDto {
    private UUID id;
    private String name;
    private String email;
    private List<PostListDto> posts;
    private String warehouseId;
}
