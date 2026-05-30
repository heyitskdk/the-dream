package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_05_learn_basic_recursion.q_05_factorial_of_a_given_number;

class Solution {
    // Function to calculate factorial of a number.
    int factorial(int n) {
        // base case
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
