package com.sauce.demo.gui.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Scripts {

    SCROLL_INTO_VIEW("arguments[0].scrollIntoView(true);"),
    CLICK_WITH_JS("arguments[0].click();");

    private String script;
}
