package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_06_bit_manipulation.assignment.q_06_set_bit;

public class Solution {
    public int solve(int A, int B) {
        int answer = 0;
        
        answer |= (1 << A);
        answer |= (1 << B);

        return answer;
    }
}
