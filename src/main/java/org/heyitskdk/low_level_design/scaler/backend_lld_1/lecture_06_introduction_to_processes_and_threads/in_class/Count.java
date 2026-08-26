package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_06_introduction_to_processes_and_threads.in_class;

public class Count implements Runnable {

    public static int count = 0;

    @Override
    public void run() {
        System.out.println(count);
        count++;
    }
}
