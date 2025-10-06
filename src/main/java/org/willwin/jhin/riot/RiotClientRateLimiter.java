package org.willwin.jhin.riot;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Slf4j
@Component
class RiotClientRateLimiter
{

    private static final String BURST_RATE_LIMITER = "riot-burst";

    private static final String SLOW_RATE_LIMITER = "riot-slow";

    private final RateLimiter burstLimiter;

    private final RateLimiter slowLimiter;

    RiotClientRateLimiter(RateLimiterRegistry rateLimiterRegistry)
    {
        burstLimiter = rateLimiterRegistry.rateLimiter(BURST_RATE_LIMITER);
        slowLimiter = rateLimiterRegistry.rateLimiter(SLOW_RATE_LIMITER);
    }

    public <T> T withRateLimit(Supplier<T> supplier)
    {
        Supplier<T> withBurstRateLimit = RateLimiter.decorateSupplier(
                burstLimiter, supplier);
        Supplier<T> withSlowRateLimit = RateLimiter.decorateSupplier(
                slowLimiter, withBurstRateLimit);
        return withSlowRateLimit.get();
    }

}
