package pexeso.desktop.data;

import java.util.TimerTask;

/**
 *
 * @author Felix
 */
public class Timer extends java.util.Timer {

    public static Timer createRepeatTask(final Runnable thread, int delay, int seconds) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                thread.run();
            }
        };
        timer.scheduleAtFixedRate(task, delay * 1000, seconds * 1000);
        return timer;
    }

    public static Timer createTask(final Runnable thread, int seconds) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                thread.run();
            }
        };
        timer.schedule(task, seconds * 1000);
        return timer;
    }
}
