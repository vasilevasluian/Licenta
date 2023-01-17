package com.sauce.demo.steps;

import com.sauce.demo.gui.pages.MainPage;
import com.sauce.demo.gui.pages.MyCartPage;
import com.sauce.demo.utils.AssertUtils;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MainPageSteps {
    @Autowired
    MainPage mainPage;

    @Step("Verify if main page is integral")
    public void checkMainPage() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(mainPage.getAddToCartBackPack().isPresent())
                    .describedAs("Add to cart back pack Button is displayed")
                    .isTrue();
            softly.assertThat(mainPage.getProductSortButton().isPresent())
                    .describedAs("Product sort Button is displayed")
                    .isTrue();
        });
        mainPage.validateFooter();
        mainPage.validateHeader();
    }

    @Step("Add back pack to cart")
    public void addToCart() {
        mainPage.getAddToCartBackPack().click();
    }

    @Step("Check if product was added to the cart")
    public void checkAddedProduct() {
        AssertUtils.assertThat("Element wasn't added", mainPage.getRemoveBackpackButton().isPresent());
        AssertUtils.assertEquals("Element wasn't added", mainPage.getHeader().getShoppingCartNumberItems().getText(), "1");
    }

    @Step("Navigate to my cart page")
    public void goToMyCart() {
        mainPage.getHeader().getShoppingCart().click();
    }
}
