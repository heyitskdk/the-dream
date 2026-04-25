package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_04_inheritance_and_polymorphism.in_class.package_a;

class Parent {
    String name;
    int age;
    private int rollNo;

    Parent() {
        super();
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void doSomething() {
        System.out.println("doing something in the parent");
    }
}
