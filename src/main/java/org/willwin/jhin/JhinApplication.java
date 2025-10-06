package org.willwin.jhin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "org.willwin.jhin.feign")
@EnableCaching
@SpringBootApplication
public class JhinApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(JhinApplication.class, args);
    }

}
