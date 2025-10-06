package org.willwin.jhin.riot;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RiotApiHeaderInterceptor implements RequestInterceptor
{

    private final RiotProperties riotProperties;

    @Override
    public void apply(RequestTemplate requestTemplate)
    {
        requestTemplate.header("X-Riot-Token", riotProperties.getApiKey());
    }

}
