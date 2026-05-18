package dev.rollerandres.api.domain.port.in;

import dev.rollerandres.api.domain.model.Content;
import reactor.core.publisher.Mono;

public interface UpdateContentUseCase {
    Mono<Content> execute(String key, String value, String description);
}