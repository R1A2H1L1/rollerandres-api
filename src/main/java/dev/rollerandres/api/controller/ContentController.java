package dev.rollerandres.api.controller;

import dev.rollerandres.api.domain.model.Content;
import dev.rollerandres.api.domain.port.in.GetContentUseCase;
import dev.rollerandres.api.domain.port.in.UpdateContentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

    private final GetContentUseCase getContentUseCase;
    private final UpdateContentUseCase updateContentUseCase;

    @GetMapping("/{key}")
    public Mono<Content> getContent(@PathVariable String key) {
        return getContentUseCase.execute(key);
    }

    @PutMapping("/{key}")
    public Mono<Content> updateContent(
            @PathVariable String key,
            @RequestParam String value,
            @RequestParam(required = false) String description) {
        return updateContentUseCase.execute(key, value, description);
    }
}