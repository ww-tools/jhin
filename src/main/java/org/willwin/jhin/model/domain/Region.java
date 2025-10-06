package org.willwin.jhin.model.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.Set;

/**
 * Enum representing the regional routing values for League of Legends API.
 */
@Getter
@RequiredArgsConstructor
public enum Region
{
    /**
     * Americas region covering North and South America.
     * Includes platforms: BR1, LA1, LA2, NA1, OC1
     */
    AMERICAS(
            "americas.api.riotgames.com", Set.of(
            Platform.BR1, Platform.LA1, Platform.LA2, Platform.NA1,
            Platform.OC1
    )
    ),

    /**
     * Asia region covering Asian countries.
     * Includes platforms: JP1, KR
     */
    ASIA("asia.api.riotgames.com", Set.of(Platform.JP1, Platform.KR)),

    /**
     * Europe region covering European countries.
     * Includes platforms: EUN1, EUW1, RU, TR1
     */
    EUROPE(
            "europe.api.riotgames.com",
            Set.of(Platform.EUN1, Platform.EUW1, Platform.RU, Platform.TR1)
    ),

    /**
     * Southeast Asia region.
     * Includes platforms: PH2, SG2, TH2, TW2, VN2
     */
    SEA(
            "sea.api.riotgames.com", Set.of(
            Platform.PH2, Platform.SG2, Platform.TH2, Platform.TW2,
            Platform.VN2
    )
    );

    private final String host;

    private final Set<Platform> platforms;

    /**
     * Gets the region for a given platform.
     *
     * @param platform the platform to find the region for
     * @return the region containing the platform, or null if not found
     */
    @NonNull
    public static Region getRegionForPlatform(Platform platform)
    {
        for (Region region : values())
        {
            if (region.platforms.contains(platform))
            {
                return region;
            }
        }
        throw new IllegalArgumentException(
                "Platform " + platform + " is not a valid platform for any region");
    }

    /**
     * Gets the platforms that belong to this region.
     *
     * @return an unmodifiable set of platforms in this region
     */
    public Set<Platform> getPlatforms()
    {
        return Set.copyOf(platforms);
    }

    public URI getUri()
    {
        return URI.create("https://" + host);
    }
}
