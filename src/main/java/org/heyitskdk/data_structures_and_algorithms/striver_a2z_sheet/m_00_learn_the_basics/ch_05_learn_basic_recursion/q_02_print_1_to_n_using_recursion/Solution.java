package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_05_learn_basic_recursion.q_02_print_1_to_n_using_recursion;

class Solution {
    public void printTillN(int n) {
        // code here
        
        // base case
        if (n == 1) {
            System.out.printf("1 ");
            return;
        }
        
        // normal case
        printTillN(n - 1);
        System.out.printf("%d ", n);
    }
}