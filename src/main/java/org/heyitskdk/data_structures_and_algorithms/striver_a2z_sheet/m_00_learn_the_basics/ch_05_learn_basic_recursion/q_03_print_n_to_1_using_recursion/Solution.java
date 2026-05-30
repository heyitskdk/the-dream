package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_05_learn_basic_recursion.q_03_print_n_to_1_using_recursion;

class Solution {
    void printNos(int n) {
        // base case
        if (n < 1) return;
        
        // normal case
        System.out.printf("%d ", n);
        printNos(n - 1);
    }
}