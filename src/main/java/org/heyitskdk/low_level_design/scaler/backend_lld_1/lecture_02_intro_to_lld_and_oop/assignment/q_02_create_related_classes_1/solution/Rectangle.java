package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_02_intro_to_lld_and_oop.assignment.q_02_create_related_classes_1.solution;

public class Rectangle {
    // write the code of rectangle class here
    public Point topLeft;
    public int height, width;

    public int getArea() {
        return height * width;
    }

    public int getPerimeter() {
        return 2 * (height + width);
    }

    public int getBottomRight() {
        int xCoordinateTopLeft = topLeft.x;

        // using distance formula
        return xCoordinateTopLeft + width;
    }
}
