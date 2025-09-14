package org.willwin.jhin.domain.riot;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing the platform identifier where a League of Legends match was played.
 */
@Getter
@RequiredArgsConstructor
public enum Platform
{
    /**
     * Brazil.
     */
    BR1("br1.api.riotgames.com"),

    /**
     * Europe Nordic & East.
     */
    EUN1("eun1.api.riotgames.com"),

    /**
     * Europe West.
     */
    EUW1("euw1.api.riotgames.com"),

    /**
     * Japan.
     */
    JP1("jp1.api.riotgames.com"),

    /**
     * Korea.
     */
    KR("kr.api.riotgames.com"),

    /**
     * Latin America North.
     */
    LA1("la1.api.riotgames.com"),

    /**
     * Latin America South.
     */
    LA2("la2.api.riotgames.com"),

    /**
     * North America.
     */
    NA1("na1.api.riotgames.com"),

    /**
     * Oceania.
     */
    OC1("oc1.api.riotgames.com"),

    /**
     * Turkey.
     */
    TR1("tr1.api.riotgames.com"),

    /**
     * Russia.
     */
    RU("ru.api.riotgames.com"),

    /**
     * Philippines.
     */
    PH2("ph2.api.riotgames.com"),

    /**
     * Singapore.
     */
    SG2("sg2.api.riotgames.com"),

    /**
     * Thailand.
     */
    TH2("th2.api.riotgames.com"),

    /**
     * Taiwan.
     */
    TW2("tw2.api.riotgames.com"),

    /**
     * Vietnam.
     */
    VN2("vn2.api.riotgames.com");

    private final String host;

}
