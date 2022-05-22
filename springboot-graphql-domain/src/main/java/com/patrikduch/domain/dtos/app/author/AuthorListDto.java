package com.patrikduch.domain.dtos.app.author;

import com.patrikduch.domain.dtos.shared.PaginationPropsDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
public class AuthorListDto extends PaginationPropsDto {
    @NotNull
    List<AuthorItemDto> collection;
    private String warehouseId;
}
