package com.jgurgul.reactive.ReactiveSpringBoot.repository;

import com.jgurgul.reactive.ReactiveSpringBoot.repository.model.OrderMovementEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderMovementRepository extends ReactiveMongoRepository<OrderMovementEntity, String> {
}
