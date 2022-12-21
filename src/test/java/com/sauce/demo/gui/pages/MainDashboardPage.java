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
public class MainDashboardPage {

    private PageElement setFilters = PageElement.locate("//button[text()='SET FILTERS ']");

    private PageElement settingsButton = PageElement.locate("//div[@title='Settings']");

    private PageElement userAdminButton = PageElement.locate("//a[text()='User Admin']");

    private PageElement notificationButton = PageElement.locate("//span[@class='header__notifications-read']");

    private PageElement myProfileButton = PageElement.locate("//a[@title='My Profile']");

    private PageElement exportToCSV = PageElement.locate("//span[@title='Export CSV file']");

    private PageElement exportToPDF = PageElement.locate("//span[@title='Export PDF file']");

    private PageElement metricsLogo = PageElement.locate("//img[@class='nav__logo-image ']");

    private PageElement switchToManagementDashboard = PageElement.locate("//span[@title='Management Dashboards']");

    private PageElement switchToMetricsViewDashboard = PageElement.locate("//span[@title='Team View']");

    private PageElement favouriteButton = PageElement.locate("//button[@class='clickoutDropdown favoritesTrigger fa cursor-pointer p-1 fa-star-o']");

    private PageElement searchButton = PageElement.locate("//button[@class='clickoutDropdown searchTrigger fa fa-search cursor-pointer p-1 ml-1']");

    private PageElement sendFeedbackButton = PageElement.locate("//a[@class='feedback-btn']");

    private PageElement capacityWasteDashboard = PageElement.locate("//li[@title='CapacityWaste']");

    private PageElement veloCapacityDashboard = PageElement.locate("//li[@title='CapacityWaste']");

    private PageElement backlogReadinessDashboard = PageElement.locate("//li[@title='Backlog Readiness']");

    private PageElement sprintPredictabilityDashboard = PageElement.locate("//li[@title='Sprint Predictability']");

    private PageElement cloneOfVelocityNewDashboard = PageElement.locate("//li[@title='Clone of Velocity New ']");

    private PageElement wasteNewDashboard = PageElement.locate("//li[@title='Waste New']");
}
