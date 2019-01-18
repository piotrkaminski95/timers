package com.codecool;

public class TimerThreadFactory {
    private static int counter = 0;

    public TimerThread getTimerThread(String name) {
        return new TimerThread(++counter, name);
    }
}
