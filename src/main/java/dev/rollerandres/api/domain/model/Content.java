package dev.rollerandres.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private Long id;
    private String key;
    private String value;
    private String description;
    private LocalDateTime updatedAt;
}