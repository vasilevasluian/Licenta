package com.sauce.demo.steps;

import com.sauce.demo.gui.pages.MainDashboardPage;
import com.thoughtworks.gauge.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MainDashboardSteps {

    @Autowired
    MainDashboardPage mainDashboardPage;

    @Step("Verify if main dashboard page is integral")
    public void checkMainDashboardPage() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(mainDashboardPage.getSetFilters().isPresent())
                    .describedAs("Set filters Button is displayed")
                    .isTrue();

            softly.assertThat(mainDashboardPage.getFavouriteButton().isPresent())
                    .describedAs("Favourite Button is displayed")
                    .isTrue();

            softly.assertThat(mainDashboardPage.getSearchButton().isPresent())
                    .describedAs("Search Button is displayed")
                    .isTrue();

            softly.assertThat(mainDashboardPage.getSettingsButton().isPresent())
                    .describedAs("Settings Button is displayed")
                    .isTrue();

            softly.assertThat(mainDashboardPage.getMyProfileButton().isPresent())
                    .describedAs("My profile Button is displayed")
                    .isTrue();

            softly.assertThat(mainDashboardPage.getNotificationButton().isPresent())
                    .describedAs("Notifications Button is displayed")
                    .isTrue();

            softly.assertThat(mainDashboardPage.getExportToCSV().isPresent())
                    .describedAs("Export to CSV Button is displayed")
                    .isTrue();

            softly.assertThat(mainDashboardPage.getExportToPDF().isPresent())
                    .describedAs("Export to PDF Button is displayed")
                    .isTrue();

            softly.assertThat(mainDashboardPage.getSendFeedbackButton().isPresent())
                    .describedAs("Send Feedback Button is displayed")
                    .isTrue();
        });
    }
}
