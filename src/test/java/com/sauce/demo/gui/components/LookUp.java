package com.sauce.demo.gui.components;

import com.sauce.demo.common.LocatorType;
import com.sauce.demo.utils.WaitUtils;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.core.Is;
import org.openqa.selenium.Keys;

import java.time.Duration;


//delete after maybe
// i thing we don't use that
@Log4j2
@NoArgsConstructor
public class LookUp extends PageElement {

    public LookUp(final String locator) {
        super(locator);
    }

    public LookUp(final String locator, final LocatorType locatorType) {
        super(locator, locatorType);
    }

    public static LookUp locate(String xpath) {
        return new LookUp(xpath, LocatorType.XPATH);
    }

    public void select(String value) {
        PageElement inputLocator =
                PageElement.locate(getLocator().concat("//input[contains(@id,'react-select-2-input')]"));
        inputLocator.click();
        inputLocator.clearKeys();
        inputLocator.sendKeys(value);
        WaitUtils.sleep(Duration.ofMillis(500));
        inputLocator.sendKeys(Keys.ENTER);
        PageElement addedGroup =
                PageElement.locate(String.format(getLocator().concat("//div[contains(text(),'%s')]"), value));
        WaitUtils.waitUntil(() -> addedGroup.isPresent(), Is.is(Boolean.TRUE));
    }

}