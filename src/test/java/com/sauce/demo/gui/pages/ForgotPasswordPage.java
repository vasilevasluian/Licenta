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
public class ForgotPasswordPage {

    private PageElement mailField = PageElement.locate("//input[@placeholder='Email@domain.com']");

    private PageElement submitButton = PageElement.locate("//button[text()=' SUBMIT ']");

    private PageElement backToLoginButton = PageElement.locate("//button[@class='btn btn-lg btn-primary btn-block mt-4']");
}
