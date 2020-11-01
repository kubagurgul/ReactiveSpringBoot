package com.jgurgul.reactive.ReactiveSpringBoot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleDto {
    private int articleId;
    private int model;
    private int color;
    private int units;
}
