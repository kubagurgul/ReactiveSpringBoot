package com.jgurgul.reactive.ReactiveSpringBoot.service;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.jgurgul.reactive.ReactiveSpringBoot.repository.OrderMovementRepository;
import com.jgurgul.reactive.ReactiveSpringBoot.repository.model.OrderMovement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@AllArgsConstructor
@Slf4j
public class OrderMovementService {

    private OrderMovementRepository orderMovementRepository;
    private ReactiveMongoTemplate mongoTemplate;

    public Flux<OrderMovement> findOrderMovements(int orderId) {
        return mongoTemplate.query(OrderMovement.class).matching(Query.query(where("orderId").is(orderId))).all();
    }

}
