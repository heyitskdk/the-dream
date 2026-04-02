package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_03_access_modifiers_and_constructors.additional_problems.q_02_create_a_student_class.solution;

public class Student {
    // write the code of student class 
    public int age;
    public String name;

    public Student() {
        this(0);
    }

    public Student(int age) {
        this(age, null);
    }

    public Student(String name) {
        this(0, name);
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
