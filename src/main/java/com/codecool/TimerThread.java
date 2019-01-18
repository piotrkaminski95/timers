package com.codecool;

public class TimerThread extends Thread {
    private Timer timer;
    private int id;
    private String timerName;

    public TimerThread(int id, String name) {
        this.timer = new Timer();
        this.id = id;
        this.timerName = name;
    }

    public String getTimerName() {
        return timerName;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            timer.increment();
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s, ThreadId: %d, Seconds: %d", timerName, id, timer.getTime());
    }
}
