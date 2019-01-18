package com.codecool;

public class TimerThread extends Thread {
    private Timer timer;
    private int id;
    private String timerName;
    private boolean stopped = false;

    public TimerThread(int id, String name) {
        this.timer = new Timer();
        this.id = id;
        this.timerName = name;
        this.setDaemon(true);
    }

    public String getTimerName() {
        return timerName;
    }

    public boolean isStopped() {
        return stopped;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                timer.increment();
            }
        } catch (InterruptedException e) {
            stopped = true;
            System.out.println(timerName + " stopped");
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s, ThreadId: %d, Seconds: %d", timerName, id, timer.getTime());
    }
}
