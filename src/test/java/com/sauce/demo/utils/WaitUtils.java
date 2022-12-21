package com.sauce.demo.utils;

import lombok.extern.log4j.Log4j2;
import org.hamcrest.Matcher;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.function.Supplier;

@Log4j2
public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 15000;

    private static final int DEFAULT_POLLING_RATE = 1000;

    public static void sleep(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T waitUntil(Supplier<T> supplier, Matcher<T> matcher, Duration waitTime, Duration sleepTime) {
        try{
            T result = supplier.get();
            long startTime = System.currentTimeMillis();
            while(!matcher.matches(result) && (System.currentTimeMillis() - startTime) < waitTime.toMillis()) {
                log.info("[WAIT] Waiting [{}] milliseconds before retrying.", sleepTime.toMillis());
                sleep(sleepTime);
                result = supplier.get();
            }
            return result;
        }catch(Exception ex){
            throw new NoSuchElementException("Time is up");
        }
    }

    public static <T> T waitUntil(Supplier<T> supplier, Matcher<T> matcher, Long waitDuration) {
        return waitUntil(supplier, matcher, Duration.ofMillis(waitDuration), Duration.ofMillis(DEFAULT_POLLING_RATE));
    }

    public static <T> T waitUntil(Supplier<T> supplier, Matcher<T> matcher) {
        return waitUntil(supplier, matcher, Duration.ofMillis(DEFAULT_TIMEOUT),
                         Duration.ofMillis(DEFAULT_POLLING_RATE));
    }

}
