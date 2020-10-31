package com.jgurgul.reactive.ReactiveSpringBoot.ws;

import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/testReactive")
    public Mono<Integer> getTestReactive() {
        return Mono.defer(() -> Mono.just(1));
    }

    @GetMapping(value ="/testReactive1", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> getTestReactive1() {
        return Flux.fromIterable(Lists.newArrayList(1,2,3,4,5,6,7,8,9,10)).delayElements(Duration.ofSeconds(1));
    }
}
