package com.sauce.demo.steps;

import com.sauce.demo.gui.pages.SignUpPage;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SignUpSteps {

    @Autowired
    SignUpPage signUpPage;

    @Step("Verify if sign up page is integral")
    public void checkSignUpPage() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(signUpPage.getFirstNameField().isPresent())
                    .describedAs("First name field is displayed")
                    .isTrue();

            softly.assertThat(signUpPage.getLastNameField().isPresent())
                    .describedAs("Last name field is displayed")
                    .isTrue();

            softly.assertThat(signUpPage.getPasswordField().isPresent())
                    .describedAs("Password field is displayed")
                    .isTrue();

            softly.assertThat(signUpPage.getConfirmPasswordField().isPresent())
                    .describedAs("Confirm password field is displayed")
                    .isTrue();

            softly.assertThat(signUpPage.getMailField().isPresent())
                    .describedAs("Mail field is displayed")
                    .isTrue();

            softly.assertThat(signUpPage.getPermissionTypeField().isPresent())
                    .describedAs("Permission type field is displayed")
                    .isTrue();

            softly.assertThat(signUpPage.getBackToLoginButton().isPresent())
                    .describedAs("Back to login button is displayed")
                    .isTrue();

            softly.assertThat(signUpPage.getSignUpButton().isPresent())
                    .describedAs("Sign up button is displayed")
                    .isTrue();
        });
    }
}
