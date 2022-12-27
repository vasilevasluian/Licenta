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
public class Login extends BasePage {
    private PageElement usernameField = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='username']");
    private PageElement passwordField = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='password']");
    private PageElement loginButton = PageElement.locate(LocatorType.CSS_SELECTOR, "[data-test='login-button']");
    private PageElement loginLogo = PageElement.locate(LocatorType.CSS_SELECTOR, ".login_logo");
    private PageElement loginCredentials= PageElement.locate(LocatorType.CSS_SELECTOR, "#login_credentials");
    private PageElement loginPassword= PageElement.locate(LocatorType.CSS_SELECTOR, ".login_password");

}
