package com.ksh.threads;

class FirstMethod extends Thread {

    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("FirstMethod Thread is Running "+i);
        }
    }
}

class SecondMethod implements Runnable {

    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("SecondMethod Thread is Running "+i);
        }
    }
}

public class CreateThread {

    public static void main(String[] args) {
        System.out.println("Main Thread Started");
        Thread thread1 = new FirstMethod();
        Thread thread2 = new FirstMethod();
        thread1.start();
        thread2.start();

        Runnable runnable = () -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("Lambda Thread is Running "+i);
            }
        };

        new Thread(new SecondMethod()).start();
        new Thread(new SecondMethod()).start();
        new Thread(runnable).start();
        System.out.println("Main Thread Ended.");
    }
}
