package com.sauce.demo.utils;

public enum ExecutionTimer {

    INSTANCE;

    private long start;
    private long end;

    public void start() {
        reset();
        start = System.currentTimeMillis();
    }

    public void stop() {
        end = System.currentTimeMillis();
    }

    public long duration() {
        return (end - start);
    }

    public double durationInSeconds() {
        return ((end - start) / 1000.00);
    }

    public void reset() {
        start = 0;
        end = 0;
    }
}
