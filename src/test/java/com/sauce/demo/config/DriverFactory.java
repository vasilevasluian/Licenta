package com.sauce.demo.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.lang.System.getenv;


@Component
@NoArgsConstructor
@Getter
@Log4j2
public class DriverFactory {

    @Value("${browserName}")
    private static String browserName;

    public static WebDriver getWebDriver() {
        return switch (System.getenv("browserName")){
            case "firefox" -> getFirefoxDriver();
            case "edge" -> getEdgeDriver();
            case "chrome_headless" -> getChromeHeadlessDriver();
            default -> getChromeDriver();
        };
    }


    private static WebDriver getEdgeDriver() {
        setupEdgeDriver();
        return new EdgeDriver(DriverOptionsProvider.getEdgeOptions());
    }
    private static WebDriver getFirefoxDriver() {
        setupFirefoxDriver();
        return new FirefoxDriver(DriverOptionsProvider.getFirefoxOptions());
    }
    private static WebDriver getChromeDriver() {
        setupChromeDriver();
        return new ChromeDriver(DriverOptionsProvider.getChromeOptions(false));
    }

    private static WebDriver getChromeHeadlessDriver() {
        setupChromeDriver();
        return new ChromeDriver(DriverOptionsProvider.getChromeOptions(true));
    }

    private static void setupChromeDriver() {
        if (!getenv("chrome_driver_version").equalsIgnoreCase("latest")) {
            WebDriverManager.chromedriver().driverVersion(getenv("chrome_driver_version")).setup();
        } else {
            WebDriverManager.chromedriver().setup();
        }
    }

    private static void setupFirefoxDriver() {
        if (!getenv("firefox_driver_version").equalsIgnoreCase("latest")) {
            WebDriverManager.firefoxdriver().driverVersion(getenv("firefox_driver_version")).setup();
        } else {
            WebDriverManager.firefoxdriver().setup();
        }
    }

    private static void setupEdgeDriver() {
        if (!getenv("edge_driver_version").equalsIgnoreCase("latest")) {
            WebDriverManager.edgedriver().driverVersion(getenv("edge_driver_version")).setup();
        } else {
            WebDriverManager.edgedriver().setup();
        }
    }
}
