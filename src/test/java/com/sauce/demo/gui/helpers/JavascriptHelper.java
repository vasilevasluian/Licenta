package com.sauce.demo.gui.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;

@Getter
@AllArgsConstructor
public class JavascriptHelper {

    public Object execute(String script, Object... args) {
        return executor().executeScript(script, args);
    }

    private JavascriptExecutor executor() {
        return ((JavascriptExecutor) DriverHelper.getInstance().getDriver());
    }
}
