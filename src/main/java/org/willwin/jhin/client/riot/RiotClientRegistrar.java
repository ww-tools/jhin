package org.willwin.jhin.client.riot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.HttpServiceGroup;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(
        group = "riot",
        basePackageClasses = RiotClient.class,
        clientType = HttpServiceGroup.ClientType.WEB_CLIENT
)
class RiotClientRegistrar
{

    @Bean
    RestClientHttpServiceGroupConfigurer riotClientConfigurer()
    {
        return groups -> groups
                .filterByName("riot")
                .forEachGroup((group, clientBuilder, factoryBuilder) ->
                {
                });
    }

}
