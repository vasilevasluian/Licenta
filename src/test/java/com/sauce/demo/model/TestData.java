package com.sauce.demo.model;

import org.apache.commons.lang.RandomStringUtils;


//maybe delete
public enum TestData {

    PROJECT_NAME("Test"),
    RISK_TITLE("Risk Tile"+ RandomStringUtils.randomNumeric(6)),
    RISK_STATEMENT("Test");

    public final String value;

    TestData(String value) {
        this.value = value;
    }

    public String getTitle() {
        return TestData.RISK_TITLE.value + RandomStringUtils.randomNumeric(6);
    }

    public String of(TestData data) {
        if (data.name().equals(TestData.RISK_TITLE)) {
            return getTitle();
        }
        return data.value;
    }
}
