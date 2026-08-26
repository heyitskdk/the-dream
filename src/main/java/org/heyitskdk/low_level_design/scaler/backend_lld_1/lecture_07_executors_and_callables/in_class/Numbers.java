package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_07_executors_and_callables.in_class;

public class Numbers implements Runnable{

    private static int count = 0;

    @Override
    public void run() {
        System.out.println(count + " : " + Thread.currentThread().getName());
        count += 1;
    }
}
