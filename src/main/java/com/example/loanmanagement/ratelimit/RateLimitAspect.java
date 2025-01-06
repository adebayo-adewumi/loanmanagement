package com.example.loanmanagement.ratelimit;

import io.github.resilience4j.ratelimiter.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Aspect
@Component
public class RateLimitAspect {
    private final RateLimiter rateLimiter;

    // Constructor to initialize the rate limiter
    public RateLimitAspect() {
        // Create the RateLimiter configuration
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(5)  // Limit of 5 requests
                .limitRefreshPeriod(Duration.ofSeconds(1))  // 1-second time window
                .timeoutDuration(Duration.ofMillis(500))  // Timeout duration for requests exceeding the limit
                .build();

        // Create a RateLimiter registry
        RateLimiterRegistry registry = RateLimiterRegistry.of(config);
        this.rateLimiter = registry.rateLimiter("apiRateLimiter");
    }

    // Define a pointcut that will match all methods annotated with @RateLimited
    @Pointcut("@annotation(RateLimited)")
    public void rateLimitedMethods() {
    }

    // Apply rate limiting before the execution of methods annotated with @RateLimited
    @Before("rateLimitedMethods() && @annotation(rateLimited)")
    public void applyRateLimit(RateLimited rateLimited) {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(rateLimited.limitForPeriod())
                .limitRefreshPeriod(Duration.ofSeconds(rateLimited.limitRefreshPeriod()))
                .timeoutDuration(Duration.ofMillis(rateLimited.timeoutDuration()))
                .build();

        RateLimiterRegistry registry = RateLimiterRegistry.of(config);
        RateLimiter rateLimiter = registry.rateLimiter("apiRateLimiter");

        RateLimiter.waitForPermission(rateLimiter);
    }
}
