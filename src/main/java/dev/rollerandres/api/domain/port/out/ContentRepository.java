package dev.rollerandres.api.domain.port.out;

import dev.rollerandres.api.domain.model.Content;
import reactor.core.publisher.Mono;

public interface ContentRepository {
    Mono<Content> findByKey(String key);
    Mono<Content> save(Content content);
}