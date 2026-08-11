package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_05_interfaces_abstract_classes.in_class;

public class Human implements Runner{

    String type = "Human Runner";
    @Override
    public void run() {
        System.out.println("The human is running...");
    }
}
