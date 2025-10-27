package org.willwin.jhin.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "data.crawl")
@Data
public class DataCrawlConfiguration
{

    private Boolean crawlNewAccounts = false;

    private Boolean updateAllAccounts = false;

    private Boolean updateAllMatchFeatures = false;

    private Boolean updateAllMatches = false;

}
