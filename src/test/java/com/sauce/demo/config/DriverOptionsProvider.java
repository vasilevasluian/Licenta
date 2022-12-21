package com.sauce.demo.config;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;

public final class DriverOptionsProvider {

    private DriverOptionsProvider() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static ChromeOptions getChromeOptions(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();

        chromePrefs.put("profile.default_content_settings.popups", 0);

        if (isHeadless) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("window-size=2560,2884");
        } else {
            options.addArguments("--disable-notifications");
            options.addArguments("disable-infobars");
            options.addArguments("start-maximized");
        }

        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        return options;
    }

    static FirefoxOptions getFirefoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions options = new FirefoxOptions();

        profile.setPreference("network.proxy.type", 4);
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

        options.setProfile(profile);
        options.setLogLevel(FirefoxDriverLogLevel.INFO);

        return options;
    }

    static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setCapability("acceptInsecureCerts", true);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

        return options;
    }

    static SafariOptions getSafariOptions() {
        SafariOptions options = new SafariOptions();

        options.setUseTechnologyPreview(true);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

        return options;
    }
}