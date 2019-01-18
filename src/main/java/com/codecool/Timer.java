package com.codecool;

public class Timer {
    private int time = 0;

    public void increment() {
        this.time++;
    }

    public void reset() {
        time = 0;
    }

    public int getTime() {
        return this.time;
    }
}
