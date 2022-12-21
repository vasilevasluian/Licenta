package com.sauce.demo.gui.helpers;

import com.sauce.demo.config.DriverFactory;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DriverHelper {

    private static DriverHelper instance;

    private WebDriver webDriver;

    public DriverHelper() {
        webDriver = getDriver();
    }

    public static DriverHelper getInstance() {
        if (instance == null) {
            instance = new DriverHelper();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = DriverFactory.getWebDriver();
        }
        return webDriver;
    }

    public void stopDriver() {
        webDriver.manage().deleteAllCookies();
        if (null != webDriver) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public void closeSession() {
        log.info("Quitting driver");
        if (null != webDriver) {
            webDriver.quit();
        }
        System.gc();
    }

    public void closeDriver() {
        log.info("Closing driver");
        webDriver.close();
    }

}