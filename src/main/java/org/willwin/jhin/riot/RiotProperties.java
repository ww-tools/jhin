package org.willwin.jhin.riot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Data
@ConfigurationProperties(prefix = "riot")
@Configuration
class RiotProperties
{

    private String apiKey;

    private String defaultApiUrl;

    private LocalDate matchListStartDate;

}
