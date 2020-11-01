package com.jgurgul.reactive.ReactiveSpringBoot.ws;

import com.jgurgul.reactive.ReactiveSpringBoot.service.dto.OrderMovementDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jgurgul.reactive.ReactiveSpringBoot.repository.model.OrderMovementEntity;
import com.jgurgul.reactive.ReactiveSpringBoot.service.OrderMovementService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
public class OrderMovementsRepository {

    private OrderMovementService service;

    @GetMapping("/orderMovements/{orderId}")
    public Flux<OrderMovementEntity> getTestReactive(@PathVariable Integer orderId) {
        return service.findOrderMovements(orderId);
    }

    @GetMapping("/orderMovements/all")
    public Flux<OrderMovementDto> getTestReactiveAll() {
        return service.findOrderMovements();
    }
}
