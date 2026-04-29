package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_07_lab_session_on_bit_manipulation.assignment.q_03_finding_good_days;

public class Solution {
    public int solve(int A) {
        // sugar coated version of counting set bits in a number
        // brian kernighan says hold my coffee
        int num = A;
        int days = 0;
        while (num > 0) {
            days++;
            num &= num - 1;
        }
        return days;
    }
}
