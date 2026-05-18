package dev.rollerandres.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class ApiKeyFilter implements WebFilter {

    @Value("${API_KEY}")
    private String apiKey;

    private static final String API_KEY_HEADER = "X-API-Key";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String path = exchange.getRequest().getPath().value();
        String method = exchange.getRequest().getMethod().name();

        if (method.equals("GET") || path.equals("/api/health")) {
            return chain.filter(exchange);
        }

        String key = exchange.getRequest().getHeaders().getFirst(API_KEY_HEADER);
        if (apiKey.equals(key)) {
            return chain.filter(exchange);
        }

        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }
}