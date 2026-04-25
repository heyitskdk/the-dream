package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_04_inheritance_and_polymorphism.in_class.package_a;

public class Client {

    public static void main(String[] args) {
        Parent parent = new Child();
        // not allowed - will throw compile time error
        // parent.childMethod();

        Child child = new Child();
        child.childMethod();

        parent = child;

        // Checking Polymorphism
        child.doSomething();
        parent.doSomething();

    }
}
