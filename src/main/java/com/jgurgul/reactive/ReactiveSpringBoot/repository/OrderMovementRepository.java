package com.jgurgul.reactive.ReactiveSpringBoot.repository;

import com.jgurgul.reactive.ReactiveSpringBoot.repository.model.OrderMovement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderMovementRepository extends ReactiveMongoRepository<OrderMovement, String> {
}
