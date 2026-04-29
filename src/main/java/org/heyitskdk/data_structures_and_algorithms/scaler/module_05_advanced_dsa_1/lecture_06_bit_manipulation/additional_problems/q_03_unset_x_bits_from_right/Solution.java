package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_06_bit_manipulation.additional_problems.q_03_unset_x_bits_from_right;

public class Solution {
    public long solve(long A, int B) {
        // approach - keep clearing bits from last
        for (int i = 0; i < B; i++) {
            A &= ~(1 << i);
        }
        return A;
    }

    public long optimisedSolution1(long A, int B) {
        return (A >> B) << B;
    }

    public long optimisedSolution2(long A, int B) {
        // by creating a mask
        return A & -(1L << B);
    }
}
