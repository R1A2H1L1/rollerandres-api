package dev.rollerandres.api.infrastructure.adapter;

import dev.rollerandres.api.domain.model.Content;
import dev.rollerandres.api.domain.port.out.ContentRepository;
import dev.rollerandres.api.infrastructure.repository.ContentEntity;
import dev.rollerandres.api.infrastructure.repository.ContentR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ContentRepositoryAdapter implements ContentRepository {

    private final ContentR2dbcRepository r2dbcRepository;

    @Override
    public Mono<Content> findByKey(String key) {
        return r2dbcRepository.findByKey(key)
                .map(this::toModel);
    }

    @Override
    public Mono<Content> save(Content content) {
        return r2dbcRepository.save(toEntity(content))
                .map(this::toModel);
    }

    private Content toModel(ContentEntity entity) {
        return Content.builder()
                .id(entity.getId())
                .key(entity.getKey())
                .value(entity.getValue())
                .description(entity.getDescription())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    private ContentEntity toEntity(Content model) {
        return ContentEntity.builder()
                .id(model.getId())
                .key(model.getKey())
                .value(model.getValue())
                .description(model.getDescription())
                .updatedAt(model.getUpdatedAt())
                .build();
    }
}