package com.sauce.demo.gui;

import com.sauce.demo.gui.helpers.DriverHelper;
import com.sauce.demo.gui.helpers.ScreenshotHelper;
import com.thoughtworks.gauge.*;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.thoughtworks.gauge.Gauge.writeMessage;
import static java.lang.String.format;

@Log4j2
@Component
@NoArgsConstructor
public class Hooks {

    @Autowired
    private ScreenshotHelper screenshotHelper;

    DriverHelper driverHelper = DriverHelper.getInstance();

    @BeforeScenario
    public void scenarioStart() {
        log.info("=============================================================================================");
        log.info("Thread identifier [" + Thread.currentThread().getId() + "]");
        log.info("Environment link [" + System.getenv("url") + "]");
    }

    @AfterStep
    public void captureScreen(ExecutionContext context) {
        if (context.getCurrentStep().getIsFailing()) {
            String stepName = context.getCurrentStep().getText();
            String fileName = screenshotHelper.takeScreenshot(stepName);
            writeMessage(format("<img src='../images/%s' width='800' height='450'>", fileName));
        }
    }

    @AfterStep
    public void makeScreen(ExecutionContext context) {
//        if (!context.getCurrentStep().getIsFailing()) {
            String stepName = context.getCurrentStep().getText();
            String fileName = screenshotHelper.takeScreenshot(stepName);
            writeMessage(format("<img src='../images/%s' width='800' height='450'>", fileName));
//        }
    }

    @AfterScenario
    public void scenarioEnd() {
        driverHelper.stopDriver();
        log.info("=============================================================================================");
    }

    @AfterSuite
    public void suiteEnd() {
        driverHelper.closeSession();
    }

}
