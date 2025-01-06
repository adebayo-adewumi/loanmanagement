package com.example.loanmanagement.ratelimit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the annotation
@Target(ElementType.METHOD)  // This can be applied to methods
@Retention(RetentionPolicy.RUNTIME)  // This will be available at runtime
public @interface RateLimited {
    int limitForPeriod() default 5;
    int limitRefreshPeriod() default 1; // in seconds
    long timeoutDuration() default 500; // in milliseconds
}

