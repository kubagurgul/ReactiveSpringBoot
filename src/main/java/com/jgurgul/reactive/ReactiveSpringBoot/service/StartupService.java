package com.jgurgul.reactive.ReactiveSpringBoot.service;

import com.google.common.collect.Lists;
import com.jgurgul.reactive.ReactiveSpringBoot.repository.OrderMovementRepository;
import com.jgurgul.reactive.ReactiveSpringBoot.repository.model.OrderMovementEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@Slf4j
public class StartupService {

    private OrderMovementRepository repository;

    @PostConstruct
    public void init() {
        log.info("Startup");
        repository.saveAll(
            Lists.newArrayList(new OrderMovementEntity(213298, 245921), new OrderMovementEntity(213298, 245921),
                new OrderMovementEntity(213298, 245921), new OrderMovementEntity(213000, 245002), new OrderMovementEntity(213000, 245002))
        ).subscribe(x -> log.info("OrderMovement has been saved: {}", x.toString()));
    }
}
