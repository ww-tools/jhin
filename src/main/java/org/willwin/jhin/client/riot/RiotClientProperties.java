package org.willwin.jhin.client.riot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Data
@Configuration
@ConfigurationProperties(prefix = "riot")
class RiotClientProperties
{

    private LocalDate matchListStart;

}
