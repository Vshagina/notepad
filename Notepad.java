package com.company;
import java.util.Timer;
import java.util.TimerTask;

public class Notepad {
    private static int counter = 0;
    private static Process process;
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                counter++;
                try {
                    if (process != null) {
                        process.destroy();
                    }
                    process = Runtime.getRuntime().exec("notepad");
                    System.out.println("Процесс блокнота запущен");
                    Thread.sleep(5000);
                    process.destroy();
                    System.out.println("Процесс блокнота завершен");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (counter == 10) {
                    if (process != null) {
                        process.destroy();
                    }
                    timer.cancel();
                    System.out.println("Завершение работы таймера");
                }
            }
        };
        long interval = 5000;
        timer.schedule(task, 0, interval);
    }
}