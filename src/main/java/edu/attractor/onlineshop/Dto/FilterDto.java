package edu.attractor.onlineshop.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FilterDto {
    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
