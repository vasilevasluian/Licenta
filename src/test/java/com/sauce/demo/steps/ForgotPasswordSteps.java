package com.sauce.demo.steps;

import com.sauce.demo.gui.pages.ForgotPasswordPage;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ForgotPasswordSteps {

    @Autowired
    ForgotPasswordPage forgotPasswordPage;

    @Step("Verify if forgot password page is integral")
    public void verifyIfPageIsIntegral() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(forgotPasswordPage.getMailField().isPresent())
                    .describedAs("Mail field is displayed")
                    .isTrue();

            softly.assertThat(forgotPasswordPage.getSubmitButton().isPresent())
                    .describedAs("Submit button is displayed")
                    .isTrue();

            softly.assertThat(forgotPasswordPage.getBackToLoginButton().isPresent())
                    .describedAs("Back to login button is displayed")
                    .isTrue();
        });
    }
}
