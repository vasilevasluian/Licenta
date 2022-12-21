package com.sauce.demo.steps;

import com.sauce.demo.entity.Page;
import com.sauce.demo.entity.Roles;
import com.sauce.demo.gui.helpers.BrowserHelper;
import com.sauce.demo.gui.pages.Login;
import com.sauce.demo.gui.pages.LoginPage;
import com.sauce.demo.gui.pages.MainDashboardPage;
import com.sauce.demo.utils.AssertUtils;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class LoginSteps {

    @Autowired
    LoginPage loginPage;

    @Autowired
    Login login;

    @Autowired
    MainDashboardPage mainDashboardPage;

    @Step("Open login page")
    public void openLoginPage() {
        BrowserHelper.navigate(System.getenv("url"));
    }

    @Step("Verify if login page is integral")
    public void checkLoginPage() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(loginPage.getLoginButton().isPresent())
                    .describedAs("Login Button is displayed")
                    .isTrue();

            softly.assertThat(loginPage.getPasswordField().isPresent())
                    .describedAs("Password field is displayed")
                    .isTrue();

            softly.assertThat(loginPage.getUsernameField().isPresent())
                    .describedAs("Username field is displayed")
                    .isTrue();

            softly.assertThat(loginPage.getForgotPasswordButton().isPresent())
                    .describedAs("Forgot password field is displayed")
                    .isTrue();

            softly.assertThat(loginPage.getSignUpButton().isPresent())
                    .describedAs("Sign Up button is displayed")
                    .isTrue();
        });
    }

    @Step("Go to <Forgot Password> page")
    public void goToPage(Page page) throws InterruptedException {
        Thread.sleep(120);

        switch (page) {
            case FORGOT_PASSWORD: {
                loginPage.getForgotPasswordButton().click();
                break;
            }
            case SIGN_UP: {
                loginPage.getSignUpButton().click();
                break;
            }
            case MY_PROFILE: {
                mainDashboardPage.getMyProfileButton().click();
            }
            case USER_ADMIN: {
                mainDashboardPage.getSettingsButton().click();
                mainDashboardPage.getUserAdminButton().click();
            }

        }
    }

    @Step("Login as <SIMPLE_USER>")
    public void loginToApp(Roles roles) {
        switch (roles) {
            case SIMPLE_USER: {
                BrowserHelper.navigate(System.getenv("url"));
                loginPage.getUsernameField().sendKeys(System.getenv("simpleUserUsername"));
                loginPage.getPasswordField().sendKeys(System.getenv("simpleUserPassword"));
                loginPage.getLoginButton().click();
                break;
            }
            case ADMIN_USER: {
                BrowserHelper.navigate(System.getenv("url"));
                break;
            }

        }

    }

    @Step("Verify if user is logout")
    public void checkIfUserIsLogout() {
        AssertUtils.assertThat("User is not logout", loginPage.getLoginButton().isPresent());
    }

    @Step("Fill the password field with invalid password")
    public void fillWrongPassword() {
        loginPage.getUsernameField().sendKeys(System.getenv("simpleUserUsername"));
        loginPage.getPasswordField().sendKeys(System.getenv("simpleUserUsername"));
        loginPage.getLoginButton().click();
    }

    @Step("Check if error message appears")
    public void checkErrorMessage() {
        AssertUtils.assertThat("Error message didn't appear", loginPage.getErrorMessageForPassword().isPresent());
    }

    @Step("Login to application")
    public void loginToApp() throws InterruptedException {
        login.getUsernameField().sendKeys(System.getenv("simpleUserUsername"));
        login.getPasswordField().sendKeys(System.getenv("simpleUserPassword"));
        login.getLoginButton().click();
        Thread.sleep(2000);
    }
}
