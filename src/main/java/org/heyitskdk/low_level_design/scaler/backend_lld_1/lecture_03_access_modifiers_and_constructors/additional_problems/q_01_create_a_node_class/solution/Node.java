package org.heyitskdk.low_level_design.scaler.backend_lld_1.lecture_03_access_modifiers_and_constructors.additional_problems.q_01_create_a_node_class.solution;

public class Node {
    // write the code of node class here
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node (Node node) {
        this.data = node.data;
        if (node.next != null) {
            this.next = new Node(node.next);
        } else {
            this.next = null;
        }
    }
}