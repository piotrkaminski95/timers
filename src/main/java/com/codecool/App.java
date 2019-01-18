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
        ExecutorService executor = Executors.newCachedThreadPool();
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
                case "quite": {
                    running = false;
                    break;
                }

                default: {
                    if (command.startsWith("start")) {
                        String name = command.trim().substring(5);
                    }
                }
            }
        }

    }
}
