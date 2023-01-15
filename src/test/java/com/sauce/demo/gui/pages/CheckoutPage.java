package com.sauce.demo.gui.pages;

import com.sauce.demo.common.LocatorType;
import com.sauce.demo.gui.BasePage;
import com.sauce.demo.gui.components.PageElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.kohsuke.rngom.parse.host.Base;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class CheckoutPage extends BasePage {
    private PageElement firstNameField = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='firstName']");

    private PageElement lastNameField = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='lastName']");

    private PageElement zipCodeField = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='postalCode']");
    private PageElement continueButton = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='continue']");
    private PageElement finishButton = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='finish']");
    private PageElement completeCheckout = PageElement.locate(LocatorType.CSS_SELECTOR, "[id='checkout_complete_container']");



}
