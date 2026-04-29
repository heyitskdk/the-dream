package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_06_bit_manipulation.additional_problems.q_02_help_from_sam;

public class Solution {
    public int solve(int A) {
        // approach - from memory I remember, we just have to calculate number of set bits in A
        // Let's use Brian Kernighan's algorithm for that
        int setBits = 0;
        for (int num = A; num > 0; num &= (num - 1)) setBits++;
        return setBits;
    }
}
