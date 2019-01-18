package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class TimerThreadPool {
    private Map<String, TimerThread> threadPool;
    private TimerThreadFactory factory;

    public TimerThreadPool() {
        this.threadPool = new HashMap<>();
        this.factory = new TimerThreadFactory();
    }

    private void addTimer(String name) {
        threadPool.put(name, factory.getTimerThread(name));
    }

    public void printTimer() {
        if (threadPool.isEmpty()) {
            System.out.println("No timers available");
        } else {
            for (TimerThread timer : threadPool.values()) {
                System.out.println(timer);
            }
        }
    }

    public void printTimer(String name) {
        if (threadPool.containsKey(name)) {
            System.out.println(threadPool.get(name));
        } else {
            System.out.println(name + " is not exist");
        }
    }

    public boolean startTimer(String name) {
        if (threadPool.containsKey(name)) {
            TimerThread timer = threadPool.get(name);
            if (timer.isStopped()) {
                restartTimer(timer);
            } else {
                return false;
            }
            return true;
        }
        addTimer(name);
        threadPool.get(name).start();
        return true;
    }

    private void restartTimer(TimerThread timer) {
        timer = factory.resetTimerThread(timer);
        threadPool.put(timer.getTimerName(), timer);
        timer.start();
    }

    public boolean stopTimer(String name) {
        if (threadPool.containsKey(name)) {
            threadPool.get(name).interrupt();
            return true;
        }
        return false;
    }

    public boolean isStopped(String name) {
        return threadPool.get(name).isStopped();
    }
}
