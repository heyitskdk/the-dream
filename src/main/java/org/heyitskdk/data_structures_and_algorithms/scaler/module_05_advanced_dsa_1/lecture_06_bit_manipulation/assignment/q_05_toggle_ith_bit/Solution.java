package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_06_bit_manipulation.assignment.q_05_toggle_ith_bit;

public class Solution {
    public int solve(int A, int B) {
        return A ^ (1 << B);
    }
}
