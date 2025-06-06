package com.example.demo.api.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/echo")
public class EchoController {
    @GetMapping({ "{word}", "" })
    public Mono<String> echo(@PathVariable(value = "word", required = false) Optional<String> word) {
        return Mono.just(word)
                .map(w -> w.isEmpty() ? "" : w.get())
                .flatMap(w -> Mono.just("Hello %s!".formatted(w)));
    }
}
