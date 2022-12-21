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
public class SignUpPage {

    private PageElement firstNameField = PageElement.locate("//input[@placeholder='First Name']");

    private PageElement lastNameField = PageElement.locate("//input[@placeholder='Last Name']");

    private PageElement mailField = PageElement.locate("//input[@placeholder='Email@domain.com']");

    private PageElement permissionTypeField = PageElement.locate("//textarea[@formcontrolname='comment']");

    private PageElement passwordField = PageElement.locate("//input[@formcontrolname='password']");

    private PageElement confirmPasswordField = PageElement.locate("//input[@formcontrolname='confirmPassword']");

    private PageElement signUpButton = PageElement.locate("//button[text()=' SIGN UP ']");

    private PageElement backToLoginButton = PageElement.locate("//span[text()=' BACK TO LOGIN ']");
}
