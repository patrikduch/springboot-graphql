package com.patrikduch.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

/**
 * DTO for loading basic project details.
 * @author Patrik Duch
 */
@Getter
@Setter
@NoArgsConstructor
public class ProjectDetailDto {
    @NotNull
    private String projectName;
}