package com.patrikduch.domain.dtos.app.post;

import com.patrikduch.domain.dtos.shared.PaginationPropsDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostListDto extends PaginationPropsDto {
    @NotNull
    List<PostItemDto> collection;
    private String warehouseId;
}
