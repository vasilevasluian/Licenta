package com.sauce.demo.steps;

import com.sauce.demo.gui.pages.UserAdminPage;
import com.sauce.demo.utils.AssertUtils;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserAdminSteps {

    @Autowired
    UserAdminPage userAdminPage;

    @Step("Verify if user admin page is integral")
    public void checkUserAdminPage() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(userAdminPage.getSearchField().isPresent())
                    .describedAs("Search field is displayed")
                    .isTrue();

            softly.assertThat(userAdminPage.getShowNumberOfUsers().isPresent())
                    .describedAs("Number of users filter is displayed")
                    .isTrue();

            softly.assertThat(userAdminPage.getFilterForDisplayUsers().isPresent())
                    .describedAs("Filter for display user button is displayed")
                    .isTrue();

            softly.assertThat(userAdminPage.getFirstNameColumn().isPresent())
                    .describedAs("First Name column is displayed")
                    .isTrue();

            softly.assertThat(userAdminPage.getEmailColumn().isPresent())
                    .describedAs("Email column is displayed")
                    .isTrue();

            softly.assertThat(userAdminPage.getRoleColumn().isPresent())
                    .describedAs("Role column is displayed")
                    .isTrue();

            softly.assertThat(userAdminPage.getLastNameColumn().isPresent())
                    .describedAs("Last Name column is displayed")
                    .isTrue();
        });
    }

    @Step("Verify if the showing entries filter are displayed")
    public void checkShowingEntriesFilter() {
        userAdminPage.getShowNumberOfUsers().click();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(userAdminPage.getShowTenEntriesFilter().isPresent())
                    .describedAs("Ten filter field is displayed")
                    .isTrue();

            softly.assertThat(userAdminPage.getShowTwentyFiveEntriesFilter().isPresent())
                    .describedAs("Twenty Five filter field is displayed")
                    .isTrue();

            softly.assertThat(userAdminPage.getShowFiftyEntriesFilter().isPresent())
                    .describedAs("Fifty filter field is displayed")
                    .isTrue();

            softly.assertThat(userAdminPage.getShowAllEntriesFilter().isPresent())
                    .describedAs("All filter field is displayed")
                    .isTrue();
        });

    }

    @Step("Check if the user can display users by first name/last name/role/email")
    public void checkIfUserCanDisplayUsersBy() {
        userAdminPage.getFilterForDisplayUsers().click();
        userAdminPage.getFirstNameCheckBox().click();
        AssertUtils.assertThat("Type of showing entries is not present", userAdminPage.getFirstNameColumn().isNotPresent());
        userAdminPage.getFilterForDisplayUsers().click();
        userAdminPage.getLastNameCheckBox().click();
        AssertUtils.assertThat("Type of showing entries is not present", userAdminPage.getLastNameColumn().isNotPresent());
        userAdminPage.getFilterForDisplayUsers().click();
        userAdminPage.getEmailNameCheckBox().click();
        AssertUtils.assertThat("Type of showing entries is not present", userAdminPage.getEmailColumn().isNotPresent());
        userAdminPage.getFilterForDisplayUsers().click();
        userAdminPage.getRoleNameCheckBox().click();
        AssertUtils.assertThat("Type of showing entries is not present", userAdminPage.getRoleColumn().isPresent());
    }
}
