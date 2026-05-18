package dev.rollerandres.api.config;

import dev.rollerandres.api.domain.port.in.GetContentUseCase;
import dev.rollerandres.api.domain.port.in.UpdateContentUseCase;
import dev.rollerandres.api.domain.port.out.ContentRepository;
import dev.rollerandres.api.domain.usecase.GetContentUseCaseImpl;
import dev.rollerandres.api.domain.usecase.UpdateContentUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GetContentUseCase getContentUseCase(ContentRepository contentRepository) {
        return new GetContentUseCaseImpl(contentRepository);
    }

    @Bean
    public UpdateContentUseCase updateContentUseCase(ContentRepository contentRepository) {
        return new UpdateContentUseCaseImpl(contentRepository);
    }
}