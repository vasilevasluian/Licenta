package com.sauce.demo.gui.pages;

import com.sauce.demo.gui.components.PageElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class LoginPage {

    private PageElement usernameField = PageElement.locate("//input[@placeholder='Email@domain.com']");

    private PageElement passwordField = PageElement.locate("//input[@placeholder='Password']");

    private PageElement loginButton = PageElement.locate("//button[@class='form__submit btn btn-lg btn-primary btn-block mt-4']");

    private PageElement signUpButton = PageElement.locate("//span[text()='SIGN UP ']");

    private PageElement forgotPasswordButton = PageElement.locate("//a[text()='FORGOT PASSWORD']");

    private PageElement errorMessageForPassword = PageElement.locate("//div[@id='toast-container']");

}
