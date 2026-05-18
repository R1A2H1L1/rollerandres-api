package dev.rollerandres.api.infrastructure.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("content")
public class ContentEntity {

    @Id
    private Long id;
    private String key;
    private String value;
    private String description;
    private LocalDateTime updatedAt;
}