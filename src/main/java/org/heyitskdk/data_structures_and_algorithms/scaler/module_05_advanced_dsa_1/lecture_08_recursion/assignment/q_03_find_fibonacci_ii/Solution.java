package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_08_recursion.assignment.q_03_find_fibonacci_ii;

public class Solution {
    public int findAthFibonacci(int A) {
        // base case
        if (A == 0) return 0;
        if(A == 1) return 1;

        // normal case
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }
}
