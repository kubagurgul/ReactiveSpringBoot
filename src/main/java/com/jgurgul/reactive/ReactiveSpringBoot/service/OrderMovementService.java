package com.jgurgul.reactive.ReactiveSpringBoot.service;

import com.google.common.collect.Lists;
import com.jgurgul.reactive.ReactiveSpringBoot.repository.OrderMovementRepository;
import com.jgurgul.reactive.ReactiveSpringBoot.repository.model.OrderMovementEntity;
import com.jgurgul.reactive.ReactiveSpringBoot.service.dto.ArticleDto;
import com.jgurgul.reactive.ReactiveSpringBoot.service.dto.OrderMovementDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@AllArgsConstructor
@Slf4j
public class OrderMovementService {

    private OrderMovementRepository orderMovementRepository;
    private ReactiveMongoTemplate mongoTemplate;

    public Flux<OrderMovementEntity> findOrderMovements(int orderId) {
        Flux<OrderMovementEntity> orders = mongoTemplate.query(OrderMovementEntity.class).matching(Query.query(where("orderId").is(orderId))).all();
        return orders;
    }

    public Flux<OrderMovementDto> findOrderMovements() {
        Flux<OrderMovementEntity> orders = mongoTemplate.query(OrderMovementEntity.class).all().doOnNext(System.out::println);
        return orders.groupBy(OrderMovementEntity::getOrderId).doOnNext(System.out::println)
                .flatMap(Flux::collectList)
                .map(order -> {
                    OrderMovementEntity first = order.get(0);
                    int orderUnits = order.stream().mapToInt(OrderMovementEntity::getUnits).sum();
                    List<ArticleDto> articles = order.stream().map(x -> new ArticleDto(x.getArticleId(), x.getModel(), x.getColor(), x.getUnits())).collect(Collectors.toList());
                    return new OrderMovementDto(first.getOrderId(), orderUnits, Lists.newArrayList(articles));
                });
    }

}
