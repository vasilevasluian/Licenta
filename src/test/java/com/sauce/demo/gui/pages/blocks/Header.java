package com.sauce.demo.gui.pages.blocks;

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
public class Header {
    private PageElement appLogo = PageElement.locate(LocatorType.CSS_SELECTOR, ".app_logo");
    private PageElement shoppingCart = PageElement.locate(LocatorType.CSS_SELECTOR, "#shopping_cart_container");
    private PageElement shoppingCartNumberItems= PageElement.locate(LocatorType.CSS_SELECTOR, ".shopping_cart_badge");

    private PageElement menuButton = PageElement.locate(LocatorType.CSS_SELECTOR, "#menu_button_container");

    private PageElement allItemsMenuOption = PageElement.locate("//a[text()='All Items']");
    private PageElement AboutMenuOption = PageElement.locate("//a[text()='About']");
    private PageElement LogoutMenuOption = PageElement.locate("//a[text()='Logout']");
    private PageElement resetAppStateMenuOption = PageElement.locate("//a[text()='Reset App State']");

}
