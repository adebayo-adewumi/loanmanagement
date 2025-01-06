package com.example.loanmanagement.ratelimit;

import io.github.resilience4j.ratelimiter.*;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimitService {
    private final RateLimiter rateLimiter;

    public RateLimitService() {
        // Create a RateLimiter with custom configuration
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .timeoutDuration(Duration.ofMillis(500))
                .build();

        RateLimiterRegistry registry = RateLimiterRegistry.of(config);
        this.rateLimiter = registry.rateLimiter("apiRateLimiter");
    }

    public void executeWithRateLimit() {
        // Execute logic with rate limiting
        RateLimiter.waitForPermission(rateLimiter);
        // Your business logic here
    }
}
