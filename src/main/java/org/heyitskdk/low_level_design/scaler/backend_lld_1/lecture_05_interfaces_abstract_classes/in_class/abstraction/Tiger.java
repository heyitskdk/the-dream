package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_05_interfaces_abstract_classes.in_class.abstraction;

public class Tiger extends Animal{

    Tiger(String species, int noOfLegs) {
        this.species = species;
        this.noOfLegs = noOfLegs;
    }

    @Override
    void eating(String fodder) {
        System.out.println("Eating " + fodder);
    }

    static void breathe() {
    }
}
