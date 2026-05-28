package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_04_know_basic_maths.q_01_count_all_digits_of_a_number;

class Solution {
    public static int countDigits(int n) {
        // Code here
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }
}