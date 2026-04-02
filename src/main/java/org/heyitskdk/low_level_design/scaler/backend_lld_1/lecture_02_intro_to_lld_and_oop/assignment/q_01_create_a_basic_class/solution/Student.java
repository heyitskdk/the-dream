package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_02_intro_to_lld_and_oop.assignment.q_01_create_a_basic_class.solution;

public class Student {
    // write the code of student class here
    public int age;
    public String name;

    public void diplay() {
        System.out.println("My name is " + this.name + ". I am " + this.age + " years old");
    }

    public void sayHello(String name) {
        System.out.println(this.name + " says hello to " + name);
    }
}
