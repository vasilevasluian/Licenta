package com.sauce.demo.gui.components;

import com.sauce.demo.common.LocatorType;
import com.sauce.demo.gui.helpers.DriverHelper;
import com.sauce.demo.gui.helpers.JavascriptHelper;
import com.sauce.demo.gui.helpers.Scripts;
import com.sauce.demo.utils.WaitUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.core.Is;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.chord;

@Log4j2
@NoArgsConstructor
@Data
public class PageElement {

    private String locator;

    private LocatorType locatorType;

    private JavascriptHelper javascriptHelper = new JavascriptHelper();

    public PageElement(String locator) {
        this.locator = locator;
        this.locatorType = LocatorType.XPATH;
    }

    public PageElement(String locator, LocatorType locatorType) {
        this.locator = locator;
        this.locatorType = locatorType;
    }

    public static PageElement locate(LocatorType locatorType, String path) {
        return new PageElement(path, locatorType);
    }

    public static PageElement locate(String xpath) {
        return new PageElement(xpath, LocatorType.XPATH);
    }

    protected boolean isReady() {
        return isReady(Boolean.TRUE);
    }

    protected boolean isNotReady() {
        return !isReady(Boolean.FALSE);
    }

    protected boolean isReady(Boolean expected) {
        try {
            if (expected == Boolean.TRUE) {
                return getElement().isEnabled() && getElement().isDisplayed();
            } else {
                return !getElement().isEnabled() && !getElement().isDisplayed();
            }
        } catch (WebDriverException e) {
            if (expected == Boolean.TRUE) {
                log.warn("Could not find element with locator [{} - {}]", getLocatorType(), getLocator());
            } else {
                log.warn("[isReady] Element with locator is not present [{} - {}]", getLocatorType(), getLocator());
            }
            return false;
        }
    }

    public WebElement find() {
        WaitUtils.waitUntil(() -> isReady(), Is.is(Boolean.TRUE));
        bringIntoView();
        return getElement();
    }

    public void click() {
        log.info("Click on element with locator [{} - {}]", getLocatorType(), getLocator());
        new Actions(DriverHelper.getInstance().getDriver()).click(find()).perform();

    }

    public void clickWithJS() {
        log.info("Click on element using JS with locator [{} - {}]", getLocatorType(), getLocator());
        javascriptHelper.execute(Scripts.CLICK_WITH_JS.getScript(), getElement());
    }

    public void doubleClick() {
        log.info("Double click on element with locator [{} - {}]", getLocatorType(), getLocator());
        new Actions(DriverHelper.getInstance().getDriver()).doubleClick(find()).perform();

    }

    public void sendKeys(String keys) {
        log.info("Send keys [{}] to element with locator [{} - {}]", keys, getLocatorType(), getLocator());
        find().sendKeys(keys);
    }

    public void sendKeys(Keys keys) {
        log.info("Send keys [{}] to element with locator [{} - {}]", keys, getLocatorType(), getLocator());
        find().sendKeys(keys);
    }

    public void clearKeys() {
        log.info("Clear keys from element with locator [{} - {}]", getLocatorType(), getLocator());
        find().sendKeys(chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public String getText() {
        log.info("Fetch text from element with locator [{} - {}]", getLocatorType(), getLocator());
        return find().getText();
    }

    public String getSelectedValue() {
        log.info("Fetch text from element with locator [{} - {}]", getLocatorType(), getLocator());
        return find().getAttribute("title");
    }

    public String getLocatorId() {
        log.info("Fetch id from element with locator [{} - {}]", getLocatorType(), getLocator());
        return find().getAttribute("id");
    }

    public void select(String value) {
        log.info("Select value [{}] from element with locator [{}]", value, getLocatorType(), getLocator());
        new Select(find()).selectByVisibleText(value);
    }

    public void selectByIndex(int index){
        log.info("Select value by index [{}] from element with locator [{}]", index, getLocatorType(), getLocator());
        new Select(find()).selectByIndex(index);
    }

    public void hover() {
        log.info("Hover over element with locator [{} - {}]", getLocatorType(), getLocator());
        new Actions(DriverHelper.getInstance().getDriver()).moveToElement(find()).perform();

    }

    public boolean isLocked() {
        log.info("Verify element with locator [{}] is locked", getLocatorType(), getLocator());
        return !(find().isEnabled());
    }

    public Boolean isPresent() {
        log.info("Verify presence of element with locator [{} - {}]", getLocatorType(), getLocator());
        try {
            return find().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public Boolean isNotPresent() {
        return waitForBlockerInvisibility();
    }

    private WebElement getElement() {
        switch (locatorType) {
            case ID:
                return DriverHelper.getInstance().getDriver().findElement(By.id(getLocator()));

            case XPATH:
                return DriverHelper.getInstance().getDriver().findElement(By.xpath(getLocator()));

            case CSS_SELECTOR:
                return DriverHelper.getInstance().getDriver().findElement(By.cssSelector(getLocator()));

            default:
                throw new IllegalArgumentException(String.format("Locator type [%s] is undefined", getLocatorType()));
        }
    }

    private void bringIntoView() {
        javascriptHelper.execute(Scripts.SCROLL_INTO_VIEW.getScript(), getElement());
    }

    public Boolean waitForBlockerInvisibility() {
        log.info("Waiting for element [" + getLocator() + "] to be invisible");
        return new WebDriverWait(DriverHelper.getInstance().getDriver(), Long.valueOf(System.getenv("blocker_invisibility_timeout")))

                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(getLocator())));
    }

    /**
     * An expectation for checking that a web-element is either invisible or not present on the DOM.
     *
     * @param locator used to find the element
     */
    public static ExpectedCondition<Boolean> invisibilityOfElementLocated(final By locator) {
        return driver -> {
            try {
                return !(driver.findElement(locator).isDisplayed());
            } catch (NoSuchElementException e) {
                // As the element is not present in DOM, it returns true. The
                //this try block detects whether the element is present but is invisible.
                return true;
            } catch (StaleElementReferenceException e) {
                // The stale element reference implies that element is no longer visible, hence returns true.
                return true;
            }
        };
    }

    public String getBackgroundColor() {
        String backgroundColorRGB = find().getCssValue("background-color");
        return Color.fromString(backgroundColorRGB).asHex();
    }

    public void selectCheckBox() {
        if (!find().isSelected()) {
            find().click();
        }
    }

}
