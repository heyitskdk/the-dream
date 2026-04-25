package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_04_inheritance_and_polymorphism.in_class.package_a;

public class Child extends Parent{
    Child() {
        // super.rollNo;
    }

    public void childMethod() {
        System.out.println("Inside child method");
    }

    @Override
    public void doSomething() {
        System.out.println("doing something in the child");
    }

}

class NewChild extends Parent {

    public void newChildMethod() {
        System.out.println("Inside new child's method");
    }
}

class AnotherChild {
    Parent parent;
}