package dev.rollerandres.api.domain.usecase;

import dev.rollerandres.api.domain.model.Content;
import dev.rollerandres.api.domain.port.in.GetContentUseCase;
import dev.rollerandres.api.domain.port.out.ContentRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetContentUseCaseImpl implements GetContentUseCase {

    private final ContentRepository contentRepository;

    @Override
    public Mono<Content> execute(String key) {
        return contentRepository.findByKey(key);
    }
}