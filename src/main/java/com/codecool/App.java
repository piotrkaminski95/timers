package com.codecool;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        TimerThreadPool timerPool = new TimerThreadPool();
        TimerThreadFactory timerFactory = new TimerThreadFactory();
        Scanner input = new Scanner(System.in);
        boolean running = true;
        String command;
        while (running) {
            System.out.println("command(type ? for help) -> ");
            command = input.nextLine();
            switch (command) {
                case "?": {
                    System.out.println(
                            "start NAME - start timer\n" +
                            "stop NAME - stop timer\n" +
                            "check NAME - show timer status\n" +
                            "quit - exit program");
                    break;
                }
                case "quit": {
                    running = false;
                    break;
                }

                default: {
                    if (command.startsWith("start")) {
                        String name = command.trim().substring(5);
                        if (timerPool.addTimer(timerFactory.getTimerThread(name))) {
                            timerPool.startTimer(name);
                            System.out.println("Started");
                        } else if (timerPool.isStopped(name)) {
                            System.out.println("deb: stopped restarting...");
                            timerPool.startTimer(name);
                            timerPool.printTimer(name);
                        } else {
                            System.out.println(name + " already started");
                        }
                    } else if (command.startsWith("stop")) {
                        String name = command.trim().substring(4);
                        if (timerPool.stopTimer(name)) {
                            System.out.println("Stopped");
                        } else {
                            System.out.println(name + " is not exist!");
                        }
                    } else if (command.startsWith("check")) {
                        String name = command.trim().substring(5);
                        timerPool.printTimer(name);
                    } else {
                        System.out.println("wrong command!");
                    }
                }
            }
        }

    }
}
