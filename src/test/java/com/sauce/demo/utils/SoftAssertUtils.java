package com.sauce.demo.utils;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j2
public class SoftAssertUtils {

    private static List<AssertionError> assertionErrors = new ArrayList<>();

    public static void assertSoftly(Runnable... actions) {
        Arrays.stream(actions)
                .forEach(action -> {
                    try {
                        action.run();
                    } catch (AssertionError e) {
                        assertionErrors.add(e);
                    }
                });
    }

    public static void logFailures() {
        int totalFailures = assertionErrors.size();
        if (totalFailures > 0) {
            AssertionError assertionError = new AssertionError("Collected [" + totalFailures + "failure(s)");
            assertionErrors.forEach(assertionError::addSuppressed);
            throw assertionError;
        } else {
            log.info("All asserts passed, no failures occurred.");
        }
    }
}
