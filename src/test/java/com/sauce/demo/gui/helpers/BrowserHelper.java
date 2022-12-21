package com.sauce.demo.gui.helpers;

import com.sauce.demo.gui.components.PageElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

@Log4j2
public class BrowserHelper {

    public static int activeTab = 0;

    public static void navigate(String url) {
        log.info("Navigate to url [{}]", url);
        DriverHelper.getInstance().getDriver().navigate().to(url);
    }

    public static void back() {
        log.info("Navigate back");
        DriverHelper.getInstance().getDriver().navigate().back();
    }

    public static void refresh() {
        log.info("Refresh page");
        DriverHelper.getInstance().getDriver().navigate().refresh();
    }

    public static void maximize() {
        log.info("Maximize window");
        DriverHelper.getInstance().getDriver().manage().window().maximize();
    }

    public static void switchFrame(PageElement frame) {
        log.info("Switch to frame with xpath [{}]", frame.getLocator());
        DriverHelper.getInstance().getDriver().switchTo().frame(frame.find());
    }

    public static void switchToDefaultFrame() {
        log.info("Switch to default frame");
        DriverHelper.getInstance().getDriver().switchTo().defaultContent();
    }

    public static String getAlertText() {
        log.info("Fetch text from alert");
        return DriverHelper.getInstance().getDriver().switchTo().alert().getText();
    }

    public static void acceptAlert() {
        log.info("Accept alert");
        DriverHelper.getInstance().getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert() {
        log.info("Dismiss alert");
        DriverHelper.getInstance().getDriver().switchTo().alert().dismiss();
    }

    public static Boolean isAlertPresent() {
        try {
            DriverHelper.getInstance().getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public static void clickOutside() {
        Actions action = new Actions(DriverHelper.getInstance().getDriver());
        action.moveByOffset(0, 0).click().build().perform();
    }

    public static void closeAllTabs() {
        log.info("Close all tabs");
        DriverHelper.getInstance().getDriver().getWindowHandles().stream().forEach(tab -> {
            DriverHelper.getInstance().getDriver().switchTo().window(tab);
            DriverHelper.getInstance().getDriver().close();
        });
        activeTab = 0;
    }

    public static void switchToMainTab() {
        log.info("Switch to main tab");
        ArrayList<String> tabs = new ArrayList<String>(DriverHelper.getInstance().getDriver().getWindowHandles());
        DriverHelper.getInstance().getDriver().switchTo().window(tabs.get(0));
        activeTab = 0;
    }

    public static void switchToTab(int index) {
        log.info("Switch to tab " + index);
        ArrayList<String> tabs = new ArrayList<String>(DriverHelper.getInstance().getDriver().getWindowHandles());
        try {
            DriverHelper.getInstance().getDriver().switchTo().window(tabs.get(index));
            activeTab = index;
        } catch (Exception ex) {
            log.error(String.format("Tab with index %s not exists", index));
        }
    }

    public static void closeCurrentTab() {
        log.info("Close current tab");
        switchToTab(activeTab);
        DriverHelper.getInstance().getDriver().close();
        decreaseActiveTabIndex();
    }

    public static void closeTab(int index) {
        log.info("Close tab " + index);
        ArrayList<String> tabs = new ArrayList<String>(DriverHelper.getInstance().getDriver().getWindowHandles());
        try {
            DriverHelper.getInstance().getDriver().switchTo().window(tabs.get(index));
            DriverHelper.getInstance().getDriver().close();
            if (index > 0) {
                switchToTab(index - 1);
            } else {
                switchToMainTab();
            }
        } catch (Exception ex) {
            log.error(String.format("Tab with index %s not exists", index));
        }
    }

    public static void decreaseActiveTabIndex() {
        if (activeTab > 0) {
            activeTab--;
        } else {
            activeTab = 0;
        }
    }

}