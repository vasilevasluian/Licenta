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
public class MyCartPage {
    private PageElement checkoutButton = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='checkout']");

}
