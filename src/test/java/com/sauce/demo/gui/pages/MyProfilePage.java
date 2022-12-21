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
public class MyProfilePage {

    private PageElement firstNameField = PageElement.locate("//input[@placeholder='First Name']");

    private PageElement lastNameField = PageElement.locate("//input[@placeholder='Last Name']");

    private PageElement mailField = PageElement.locate("//input[@placeholder='Email@domain.com']");

    private PageElement updateUserButton = PageElement.locate("//button[text()=' UPDATE USER ']");

    private PageElement currentPasswordField = PageElement.locate("//input[@placeholder='Current Password']");

    private PageElement newPasswordField = PageElement.locate("//input[@placeholder='New Password']");

    private PageElement confirmNewPasswordField = PageElement.locate("//input[@placeholder='Confirm New Password']");

    private PageElement updatePasswordButton = PageElement.locate("//button[text()=' UPDATE PASSWORD ']");

    private PageElement logoutButton = PageElement.locate("//button[text()='LOGOUT']");

    private PageElement cancelLogOutButton = PageElement.locate("//button[@class='btn btn-outline-white px-4 mr-2']");

    private PageElement confirmLogOutButton = PageElement.locate("//button[@class='btn btn-white px-4']");
}
