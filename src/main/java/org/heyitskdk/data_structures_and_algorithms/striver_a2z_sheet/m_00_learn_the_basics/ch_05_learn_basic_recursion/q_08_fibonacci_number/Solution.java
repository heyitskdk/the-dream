package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_05_learn_basic_recursion.q_08_fibonacci_number;

class Solution {
    public int fib(int n) {
        // base case
        if (n == 0) return 0;
        if (n == 1) return 1;

        // normal case
        return fib(n - 1) + fib(n - 2);
    }
}