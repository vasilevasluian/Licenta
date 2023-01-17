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
    private PageElement productSortButton = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='product_sort_container']");
    private PageElement addToCartBackPack= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='add-to-cart-sauce-labs-backpack']");
    private PageElement addToCartBikeLight= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='add-to-cart-sauce-labs-bike-light']");
    private PageElement removeBackpackButton= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='remove-sauce-labs-backpack']");
    private PageElement removeBikeLightButton= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='remove-sauce-labs-bike-light']");

}
