package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new ConsoleProgress());
        thread.start();
        new ConsoleProgress().run();
        thread.interrupt();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            String[] arr = {"|", "/", "--", "\\", "|", "/", "--", "\\"};
            for (String s : arr) {
                System.out.print("\r load: " + s);
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
