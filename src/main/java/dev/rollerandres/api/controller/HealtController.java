package dev.rollerandres.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealtController {

    @GetMapping("/health")
    public Mono<Map<String, String>> healt() {
        return Mono.just(Map.of(
                "status", "UP",
                "service", "rollerandres-api"
        ));
    }

}
