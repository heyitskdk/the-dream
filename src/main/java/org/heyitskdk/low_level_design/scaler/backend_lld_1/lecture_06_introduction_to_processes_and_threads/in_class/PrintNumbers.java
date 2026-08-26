package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_06_introduction_to_processes_and_threads.in_class;

public class PrintNumbers implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}
