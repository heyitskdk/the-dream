package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_04_know_basic_maths.q_02_reverse_a_number;

class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        long reverse = 0l;
        int number = x > 0 ? x : -1 * x;
        while (number > 0) {
            int digit = number % 10;
            reverse *= 10;
            reverse += digit;
            number /= 10;
        }

        if (reverse > Integer.MAX_VALUE) return 0;

        return isNegative ? (int)reverse * -1 : (int)reverse;
    }
}