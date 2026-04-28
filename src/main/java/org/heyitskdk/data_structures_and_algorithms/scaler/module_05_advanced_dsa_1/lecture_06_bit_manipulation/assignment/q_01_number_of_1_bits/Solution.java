package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_06_bit_manipulation.assignment.q_01_number_of_1_bits;

public class Solution {
    public int numSetBits(int A) {
        // let's not modify original input
        int num = A;
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) count++;
            num >>= 1;
        }
        return count;
    }

    // mentor - claude opus 4.7
    public int optimisedSolution(int A) {
        // using brian kernighan's algorithm
        int count = 0;
        while (A > 0) {
            A &= (A - 1);
            count++;
        }
        return count;
    }
}

