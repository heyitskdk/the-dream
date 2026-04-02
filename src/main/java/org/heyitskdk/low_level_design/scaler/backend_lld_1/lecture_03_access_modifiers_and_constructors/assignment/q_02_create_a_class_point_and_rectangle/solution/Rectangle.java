package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_03_access_modifiers_and_constructors.assignment.q_02_create_a_class_point_and_rectangle.solution;

public class Rectangle {
    // write the code of Rectangle class here
    public Point topLeft, bottomRight;

    public Rectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        this.topLeft = new Point(topLeftX, topLeftY);
        this.bottomRight = new Point(bottomRightX, bottomRightY);
    }

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = new Point(topLeft);
        this.bottomRight = new Point(bottomRight);
    }

    public Rectangle (Rectangle rectangle) {
        this.topLeft = new Point(rectangle.topLeft);
        this.bottomRight = new Point(rectangle.bottomRight);
    }
}
