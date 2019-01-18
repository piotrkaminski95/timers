package com.codecool;

public class TimerThread extends Thread {
    private Timer timer;
    private int id;
    private String name;

    public TimerThread(int id, String name) {
        this.timer = new Timer();
        this.id = id;
        this.name = name;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            timer.increment();
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s, ThreadId: %d, Seconds: %d", name, id, timer.getTime());
    }
}
