package com.sauce.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Browser {
    /**
     * Chrome instance
     */
    CHROME("chrome"),

    /**
     * Chrome in headless mode
     */
    CHROME_HEADLESS("chrome_headless"),
    /**
     * Firefox instance
     */
    FIREFOX("Firefox"),

    /**
     * Safari instance
     */
    SAFARI("Safari"),

    /**
     * Edge instance
     */
    EDGE("Edge");

    private final String browserType;

    public static Browser fromString(String browserType) {
        return Arrays.stream(values())
                .filter(b -> b.getBrowserType().equalsIgnoreCase(browserType))
                .findFirst()
                .orElse(CHROME);
    }
}
