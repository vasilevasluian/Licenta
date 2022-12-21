package com.sauce.demo.gui.helpers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;
import static org.apache.commons.io.FileUtils.copyFile;

@Log4j2
@NoArgsConstructor
@Getter
@Component
public class ScreenshotHelper {

    private String imageDirectory = "reports/html-report/images/%s";

    public String takeScreenshot(String stepName) {
        String name = generateName(stepName);
        String path = format(imageDirectory, name);
        File file = capture();
        save(file, path);
        return name;
    }

    private File capture() {
        return ((TakesScreenshot) DriverHelper.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
    }

    private void save(File file, String filePath) {
        try {
            copyFile(file, new File(filePath));
        } catch (IOException e) {
            log.error(format("Could not save file, reason -> [%s].", e));
        }
    }

    private String generateName(String fileName) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        return format("%s_%s.png", fileName.replaceAll("\\W", "_"), formatter.format(date));
    }

}