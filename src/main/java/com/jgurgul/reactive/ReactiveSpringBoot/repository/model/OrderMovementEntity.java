package com.jgurgul.reactive.ReactiveSpringBoot.repository.model;

import java.io.Serializable;
import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Document
public class OrderMovementEntity implements Serializable {
    @Id
    private String _id;
    private int orderId;
    private int articleId;
    private int model;
    private int color;
    private int orderUnits;
    private int units;

    public OrderMovementEntity(int orderId, int articleId) {
        this.orderId = orderId;
        this.articleId = articleId;
        this.model = 1 + new Random().nextInt(100);
        this.color =  1 + new Random().nextInt(100);
        this.orderUnits =  1 + new Random().nextInt(100);
        this.units =  1 + new Random().nextInt(100);
        this._id = orderId + "_" + articleId + "_" + model + "_" + color;
    }

}
