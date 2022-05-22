package com.patrikduch.domain.dtos.app.post;

import com.patrikduch.domain.dtos.app.author.AuthorItemDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@Builder // for enabling Builder pattern
@NoArgsConstructor // for creating constructor without arguments
@AllArgsConstructor // for creating all constructors
public class PostItemDto {
    private UUID id;
    private String title;
    private String description;
    private AuthorItemDto author;
    private String warehouseId;
}
