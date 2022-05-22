package com.patrikduch.domain.dtos.shared;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

/**
 * Pagination properties that are needed for each list with pagination.
 * @author Patrik Duch
 */
@Getter
@Setter
public class PaginationPropsDto  {
    @NotNull
    private int pageId;
    @NotNull
    private Long totalItemsCount;
}