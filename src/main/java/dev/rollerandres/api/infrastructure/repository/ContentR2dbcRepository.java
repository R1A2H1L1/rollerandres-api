package dev.rollerandres.api.infrastructure.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ContentR2dbcRepository extends ReactiveCrudRepository<ContentEntity, Long> {
    Mono<ContentEntity> findByKey(String key);
}