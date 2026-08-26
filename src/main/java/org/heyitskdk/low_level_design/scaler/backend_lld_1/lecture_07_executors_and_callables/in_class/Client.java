package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_07_executors_and_callables.in_class;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Numbers numbers = new Numbers();
        for (int i = 0; i < 1000000; i++) {
            executorService.execute(numbers);
        }

        executorService.shutdown();
    }
}
