package com.sauce.demo.utils;

import lombok.extern.log4j.Log4j2;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

@Log4j2
public class AssertUtils {

    public static <T> void assertThat(String message, T actual, Matcher<T> matcher) {
        log.info(message);
        MatcherAssert.assertThat(message, actual, matcher);
    }

    public static void assertThat(String message, boolean condition) {
        MatcherAssert.assertThat(message, condition);
    }

    public static <T> void assertEquals(String message, T actual, T expected) {
        assertThat(message, actual, Matchers.is(expected));
    }

}