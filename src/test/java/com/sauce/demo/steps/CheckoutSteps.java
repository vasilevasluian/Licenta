package com.sauce.demo.steps;

import com.sauce.demo.gui.pages.CheckoutPage;
import com.sauce.demo.utils.AssertUtils;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CheckoutSteps {
    @Autowired
    CheckoutPage checkoutPage;

    @Step("Fill all the data and click on Continue button")
    public void fillData() {
        checkoutPage.getFirstNameField().sendKeys(System.getenv("simpleUserUsername"));
        checkoutPage.getLastNameField().sendKeys(System.getenv("simpleUserUsername"));
        checkoutPage.getZipCodeField().sendKeys(System.getenv("zipCode"));
        checkoutPage.getContinueButton().click();
    }

    @Step("Click on Finish button")
    public void clickOnFinishButton() {
        checkoutPage.getFinishButton().click();
    }

    @Step("Verify if order was placed successfully")
    public void checkOrderCompletion() {
        AssertUtils.assertThat("Order was not placed", checkoutPage.getCompleteCheckout().isPresent());
    }
}
