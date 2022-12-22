package com.sauce.demo.gui.pages;

import com.sauce.demo.common.LocatorType;
import com.sauce.demo.gui.components.PageElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class ProductPage {
    private PageElement addToCartBackPack= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='add-to-cart-sauce-labs-backpack']");
    private PageElement removeBackpackButton= PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='remove-sauce-labs-backpack']");
    private PageElement backToProductsButton = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='back-to-products']");
    private PageElement productName = PageElement.locate(LocatorType.CSS_SELECTOR, ".inventory_details_name");
    private PageElement productDetails = PageElement.locate(LocatorType.CSS_SELECTOR, ".inventory_details_desc");
    private PageElement productPrice = PageElement.locate(LocatorType.CSS_SELECTOR, ".inventory_details_price");

}
