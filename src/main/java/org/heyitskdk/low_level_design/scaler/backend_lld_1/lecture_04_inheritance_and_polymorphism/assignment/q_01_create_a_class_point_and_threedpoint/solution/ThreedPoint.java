package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_04_inheritance_and_polymorphism.assignment.q_01_create_a_class_point_and_threedpoint.solution;

public class ThreedPoint extends Point{
    // write the code of Threedpoint class here
    private int z;

    @Override
    public void display() {
        System.out.println("[" + this.x + ", " + this.y + ", " + this.z + "]");
    }
}
