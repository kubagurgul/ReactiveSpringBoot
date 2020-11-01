package com.jgurgul.reactive.ReactiveSpringBoot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderMovementDto {
    private int orderId;
    private int orderUnits;
    private List<ArticleDto> articles;


}
