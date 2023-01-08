package com.sauce.demo.steps;

import com.sauce.demo.entity.Page;
import com.sauce.demo.entity.Roles;
import com.sauce.demo.gui.helpers.BrowserHelper;
import com.sauce.demo.gui.pages.Login;
import com.sauce.demo.gui.pages.MainPage;
import com.sauce.demo.gui.pages.blocks.Header;
import com.sauce.demo.utils.AssertUtils;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.kohsuke.rngom.digested.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class LoginSteps {


    @Autowired
    Login login;

    @Autowired
    Header header;

    @Autowired
    MainPage mainPage;


    @Step("Open login page")
    public void openLoginPage() {
        BrowserHelper.navigate(System.getenv("url"));
    }

    @Step("Verify if login page is integral")
    public void checkLoginPage() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(login.getLoginButton().isPresent())
                    .describedAs("Login Button is displayed")
                    .isTrue();
            softly.assertThat(login.getUsernameField().isPresent())
                    .describedAs("User name field is displayed")
                    .isTrue();
            softly.assertThat(login.getPasswordField().isPresent())
                    .describedAs("Password field is displayed")
                    .isTrue();
            softly.assertThat(login.getLoginLogo().isPresent())
                    .describedAs("Login logo is displayed")
                    .isTrue();
            softly.assertThat(login.getLoginCredentials().isPresent())
                    .describedAs("Login credentials is displayed")
                    .isTrue();
            softly.assertThat(login.getLoginPassword().isPresent())
                    .describedAs("Login password is displayed")
                    .isTrue();
        });
    }

    public void checkHeader() {
        SoftAssertions.assertSoftly(softly -> {
//                    softly.assertThat(header.getAppLogo().isPresent())
//                            .describedAs("App logo is displayed")
//                            .isTrue();

            softly.assertThat(header.getShoppingCart().isPresent())
                    .describedAs("Shopping cart is displayed")
                    .isTrue();

            softly.assertThat(header.getMenuButton().isPresent())
                    .describedAs("Menu button is displayed")
                    .isTrue();
        });
    }

//    @Step("Verify if login page is integral")
//    public void checkLoginPage() {
//        SoftAssertions.assertSoftly(softly -> {
//            softly.assertThat(loginPage.getLoginButton().isPresent())
//                    .describedAs("Login Button is displayed")
//                    .isTrue();
//
//            softly.assertThat(loginPage.getPasswordField().isPresent())
//                    .describedAs("Password field is displayed")
//                    .isTrue();
//
//            softly.assertThat(loginPage.getUsernameField().isPresent())
//                    .describedAs("Username field is displayed")
//                    .isTrue();
//
//            softly.assertThat(loginPage.getForgotPasswordButton().isPresent())
//                    .describedAs("Forgot password field is displayed")
//                    .isTrue();
//
//            softly.assertThat(loginPage.getSignUpButton().isPresent())
//                    .describedAs("Sign Up button is displayed")
//                    .isTrue();
//        });
//    }


    @Step("Login as <SIMPLE_USER>")
    public void loginToApp(Roles roles) {
        switch (roles) {
            case SIMPLE_USER: {
//                BrowserHelper.navigate(System.getenv("url"));
                login.getUsernameField().sendKeys(System.getenv("simpleUserUsername"));
                login.getPasswordField().sendKeys(System.getenv("simpleUserPassword"));
                login.getLoginButton().click();
                break;
            }
            case PROBLEM_USER: {
//                BrowserHelper.navigate(System.getenv("url"));
                login.getUsernameField().sendKeys(System.getenv("problemUserUsername"));
                login.getPasswordField().sendKeys(System.getenv("problemUserPassword"));
                login.getLoginButton().click();
                break;
            }
            case PROBLEM_GLITCH_USER: {
                login.getUsernameField().sendKeys(System.getenv("performanceGlitchUsername"));
                login.getPasswordField().sendKeys(System.getenv("performanceGlitchPassword"));
                login.getLoginButton().click();
                break;
            }
            case LOCKED_OUT_USER: {
                login.getUsernameField().sendKeys(System.getenv("lockedOutUsername"));
                login.getPasswordField().sendKeys(System.getenv("lockedOutPassword"));
                login.getLoginButton().click();
                break;
            }
            case WRONG_PASSWORD: {
                login.getUsernameField().sendKeys(System.getenv("performanceGlitchUsername"));
                login.getPasswordField().sendKeys("wrongPassword");
                login.getLoginButton().click();
                break;
            }
            case WRONG_USERNAME: {
                login.getUsernameField().sendKeys("wrongUsername");
                login.getPasswordField().sendKeys(System.getenv("lockedOutPassword"));
                login.getLoginButton().click();
                break;
            }
        }

    }

    @Step("Login to application")
    public void loginToApp() throws InterruptedException {
        login.getUsernameField().sendKeys(System.getenv("simpleUserUsername"));
        login.getPasswordField().sendKeys(System.getenv("simpleUserPassword"));
        login.getLoginButton().click();
        Thread.sleep(2000);
        login.getHeader().getAppLogo().isPresent();
    }

    @Step("Verify if user is logged")
    public void checkUserLogged() {
        AssertUtils.assertThat("User is not logged", mainPage.getHeader().getShoppingCart().isPresent());
    }

    @Step("Verify if error message for locked user appeared")
    public void checkErrorLocked() {
        AssertUtils.assertThat("Error did not appeared", login.getErrorContainer().isPresent());
        AssertUtils.assertEquals("Error did not appeared", login.getErrorContainer().getText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Step("Verify if error message for wrong username/password appeared")
    public void checkWrongPassword() {
        AssertUtils.assertEquals("Error did not appeared", login.getErrorContainer().getText(), "Epic sadface: Username and password do not match any user in this service");
    }

//    @Step("Verify if error message for wrong username appeared")
//    public void checkWrongUsername() {
//        AssertUtils.assertEquals("Error did not appeared", login.getErrorContainer().getText(), "Epic sadface: Username and password do not match any user in this service");
//    }
}
