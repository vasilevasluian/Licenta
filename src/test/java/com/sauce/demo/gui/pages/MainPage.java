package com.sauce.demo.gui.pages;

import com.sauce.demo.common.LocatorType;
import com.sauce.demo.gui.BasePage;
import com.sauce.demo.gui.components.PageElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class MainPage extends BasePage {
//    private PageElement appLogo = PageElement.locate(LocatorType.CSS_SELECTOR, ".app_logo");
//    private PageElement shoppingCart = PageElement.locate(LocatorType.CSS_SELECTOR, "#shopping_cart_container");
//    private PageElement menuButton = PageElement.locate(LocatorType.CSS_SELECTOR, "#menu_button_container");
    private PageElement productSortButton = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='product_sort_container']");
    private PageElement addToCartBackPack= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='add-to-cart-sauce-labs-backpack']");
    private PageElement addToCartBikeLight= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='add-to-cart-sauce-labs-bike-light']");
    private PageElement twitterButton= PageElement.locate(LocatorType.CSS_SELECTOR, ".social_twitter");
    private PageElement facebookButton= PageElement.locate(LocatorType.CSS_SELECTOR, ".social_facebook");
    private PageElement linkedinButton= PageElement.locate(LocatorType.CSS_SELECTOR, ".social_linkedin");
    private PageElement footerData= PageElement.locate(LocatorType.CSS_SELECTOR, ".footer_copy");
    private PageElement removeBackpackButton= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='remove-sauce-labs-backpack']");
    private PageElement removeBikeLightButton= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='remove-sauce-labs-bike-light']");
//    private PageElement shoppingCartNumberItems= PageElement.locate(LocatorType.CSS_SELECTOR, ".shopping_cart_badge");





}
