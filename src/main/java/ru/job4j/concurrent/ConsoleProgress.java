package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ConsoleProgress());
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }

    @Override
    public void run() {
        String[] arr = {"|", "/", "--", "\\", "|", "/", "--", "\\"};
        int index = 0;
        while (!Thread.currentThread().isInterrupted()) {
            for (String s : arr) {
                System.out.print("\r load: " + arr[index++]);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            index = 0;
        }
    }
}
