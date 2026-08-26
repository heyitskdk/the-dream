package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_05_interfaces_abstract_classes.in_class.abstraction;

public class Client {

    public static void main(String[] args) {
        Tiger tiger = new Tiger("Mammal", 4);
        System.out.println(tiger.noOfLegs + ", " + tiger.species);
        tiger.eating("rabbit");
        tiger.breathe();

        Animal animal = new Tiger("Royal Bengal", 4);
        animal.eating("deer");
    }
}
