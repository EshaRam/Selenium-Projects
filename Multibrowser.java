package org.example;

import org.openqa.selenium.WebDriver;

public class Multibrowser extends MultithreadingUtil {

    public Multibrowser(String name, String browsertype) {
        super(name, browsertype);
    }

    // main method to create the thread and run multiple threads
    public static void main(String[] args) {
        Thread t1 = new Multibrowser("Thread Chrome", "chrome");

        Thread t2 = new Multibrowser("Thread Firefox", "firefox");
        System.out.println("Starting MyThreads");
        t1.start();
        t2.start();
        System.out.println("Thread has been started");
    }

}

