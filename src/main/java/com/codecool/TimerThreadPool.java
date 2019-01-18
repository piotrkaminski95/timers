package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class TimerThreadPool {
    private Map<String, TimerThread> threadPool;

    public TimerThreadPool() {
        this.threadPool = new HashMap<>();
    }

    public boolean addTimer(TimerThread timer) {
        if (threadPool.containsKey(timer.getTimerName())) {
            return false;
        }
        threadPool.put(timer.getTimerName(), timer);
        return true;
    }

    public TimerThread getTimer(String name) {
        return threadPool.get(name);
    }

    public boolean stopTimer(String name) {
        if (threadPool.containsKey(name)) {
            threadPool.get(name).interrupt();
            return true;
        }
        return false;
    }
}
