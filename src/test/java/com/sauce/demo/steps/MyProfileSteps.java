package com.sauce.demo.steps;

import com.sauce.demo.gui.pages.MyProfilePage;
import com.sauce.demo.utils.AssertUtils;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MyProfileSteps {

    @Autowired
    MyProfilePage myProfilePage;

    @Step("Verify if my profile page is integral")
    public void checkMyProfilePage() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(myProfilePage.getFirstNameField().isPresent())
                    .describedAs("First Name field is displayed")
                    .isTrue();

            softly.assertThat(myProfilePage.getLastNameField().isPresent())
                    .describedAs("Last Name field is displayed")
                    .isTrue();

            softly.assertThat(myProfilePage.getMailField().isPresent())
                    .describedAs("Mail field is displayed")
                    .isTrue();

            softly.assertThat(myProfilePage.getUpdateUserButton().isPresent())
                    .describedAs("Update user button is displayed")
                    .isTrue();

            softly.assertThat(myProfilePage.getCurrentPasswordField().isPresent())
                    .describedAs("Current password field is displayed")
                    .isTrue();

            softly.assertThat(myProfilePage.getNewPasswordField().isPresent())
                    .describedAs("New password field is displayed")
                    .isTrue();

            softly.assertThat(myProfilePage.getConfirmNewPasswordField().isPresent())
                    .describedAs("Confirm new password field is displayed")
                    .isTrue();

            softly.assertThat(myProfilePage.getUpdatePasswordButton().isPresent())
                    .describedAs("Update password button is displayed")
                    .isTrue();

            softly.assertThat(myProfilePage.getLogoutButton().isPresent())
                    .describedAs("Logout button is displayed")
                    .isTrue();
        });
    }

    @Step("Logout from the app")
    public void logoutFunctionality() {
        myProfilePage.getLogoutButton().click();
        myProfilePage.getConfirmLogOutButton().click();
    }

    @Step("Cancel the logout")
    public void cancelTheLogout() {
        myProfilePage.getLogoutButton().click();
        myProfilePage.getCancelLogOutButton().click();
    }

    @Step("Check if user is logged in")
    public void checkIfUserIsLoggedIn() {
        AssertUtils.assertThat("User is not logout", myProfilePage.getLogoutButton().isPresent());
    }
}
