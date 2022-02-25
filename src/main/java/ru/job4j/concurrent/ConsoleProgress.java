package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    public static void main(String[] args) {
        new ConsoleProgress().run();
    }

    @Override
    public void run() {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        while (!Thread.currentThread().isInterrupted()) {
            Thread thread = new Thread(
                    () -> {
                        while (!Thread.currentThread().isInterrupted()) {
                            System.out.print("\r load: " + "|");
                            System.out.print("\r load: " + "/");
                            System.out.print("\r load: " + "--");
                            System.out.print("\r load: " + "\\");
                            System.out.print("\r load: " + "|");
                            System.out.print("\r load: " + "/");
                            System.out.print("\r load: " + "--");
                            System.out.print("\r load: " + "\\");
                        }
                    }
            );
            thread.start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        }
    }
}
