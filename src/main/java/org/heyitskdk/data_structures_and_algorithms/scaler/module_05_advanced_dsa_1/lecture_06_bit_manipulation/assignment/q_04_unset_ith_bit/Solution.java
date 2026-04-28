package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_06_bit_manipulation.assignment.q_04_unset_ith_bit;

public class Solution {
    public int solve(int A, int B) {
        // toggling only if bit is set
        if ((A & (1 << B)) != 0) {
            A ^= (1 << B);
        }

        return A;
    }

    public int optimsedSolution(int A, int B) {
        return A & ~(1 << B);
    }
}
