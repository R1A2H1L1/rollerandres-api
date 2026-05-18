package dev.rollerandres.api.domain.usecase;

import dev.rollerandres.api.domain.model.Content;
import dev.rollerandres.api.domain.port.in.UpdateContentUseCase;
import dev.rollerandres.api.domain.port.out.ContentRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UpdateContentUseCaseImpl implements UpdateContentUseCase {

    private final ContentRepository contentRepository;

    @Override
    public Mono<Content> execute(String key, String value, String description) {
        return contentRepository.findByKey(key)
                .flatMap(existing -> {
                    existing.setValue(value);
                    existing.setDescription(description);
                    existing.setUpdatedAt(LocalDateTime.now());
                    return contentRepository.save(existing);
                })
                .switchIfEmpty(Mono.defer(() -> {
                    Content newContent = Content.builder()
                            .key(key)
                            .value(value)
                            .description(description)
                            .updatedAt(LocalDateTime.now())
                            .build();
                    return contentRepository.save(newContent);
                }));
    }
}