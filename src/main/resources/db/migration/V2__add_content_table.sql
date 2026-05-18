CREATE TABLE content (
    id BIGSERIAL PRIMARY KEY,
    key VARCHAR(255) NOT NULL UNIQUE,
    value TEXT NOT NULL,
    description VARCHAR(500),
    updated_at TIMESTAMP DEFAULT NOW()
);