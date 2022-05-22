package com.patrikduch.domain.dtos.shared;

import lombok.Getter;
import lombok.Setter;

/**
 * Shared warehouse properties for all DTO that needs arbitrary warehouse properties.
 * @author Patrik Duch
 */
@Getter
@Setter
public class WarehousePropsDto {
    private String warehouseId;
}
