package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_05_interfaces_abstract_classes.in_class.abstraction;

public abstract class Animal {
    protected String species;
    int noOfLegs;
    private boolean alive;

    void walk() {
        System.out.println("Animal is walking son");
    }

    abstract void eating(String fodder);

    static void breathe() {
        System.out.println("Animal is breathing");
    }
}
