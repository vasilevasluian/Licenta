package com.sauce.demo.steps;

import com.sauce.demo.gui.pages.MyCartPage;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MyCartSteps {
    @Autowired
    MyCartPage myCartPage;

    @Step("Click to checkout button")
    public void clickToCheckout() {
        myCartPage.getCheckoutButton().click();
    }
}
