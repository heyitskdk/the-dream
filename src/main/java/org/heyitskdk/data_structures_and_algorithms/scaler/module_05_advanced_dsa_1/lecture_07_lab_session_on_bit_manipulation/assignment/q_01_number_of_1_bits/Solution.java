package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_07_lab_session_on_bit_manipulation.assignment.q_01_number_of_1_bits;

public class Solution {
    public int numSetBits(int A) {
        int setBits = 0;
        for (int num = A; num > 0; num &= num - 1) setBits++;
        return setBits;
    }
}
