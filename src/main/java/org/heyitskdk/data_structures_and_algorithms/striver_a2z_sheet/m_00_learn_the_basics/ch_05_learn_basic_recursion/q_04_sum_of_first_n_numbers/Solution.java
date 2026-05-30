package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_05_learn_basic_recursion.q_04_sum_of_first_n_numbers;

class Solution {
    static int sumOfNaturals(int n) {
        // base case
        if (n == 0) return 0;
        return n + sumOfNaturals(n - 1);
    }
};