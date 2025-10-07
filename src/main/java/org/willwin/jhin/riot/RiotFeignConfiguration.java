package org.willwin.jhin.riot;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiotFeignConfiguration
{

    @Bean
    Feign.Builder feignBuilder(RiotApiHeaderInterceptor riotApiHeaderInterceptor)
    {
        return Feign.builder().requestInterceptor(riotApiHeaderInterceptor);
    }


}
