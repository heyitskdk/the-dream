package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_06_introduction_to_processes_and_threads.in_class;

public class Client {

    public static void main(String[] args) {
        PrintNumbers print = new PrintNumbers();

        Thread thread = new Thread(print);
//        thread.start();

        Count count = new Count();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(count);
            t.start();
        }
    }
}
