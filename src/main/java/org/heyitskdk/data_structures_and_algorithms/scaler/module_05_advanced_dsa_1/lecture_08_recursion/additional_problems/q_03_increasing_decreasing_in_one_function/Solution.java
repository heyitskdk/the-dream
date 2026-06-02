package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_08_recursion.additional_problems.q_03_increasing_decreasing_in_one_function;

public class Solution {
        public void DecThenInc(int n) {
            print(n, n);
        }

        private static void print(int n, int limit) {
            // base case
            if (n < 1) return;

            // normal case
            System.out.printf("%d ", n);
            print(n - 1, limit);
            System.out.printf("%d ", n);

            // platform new line correction
            if (n == limit) System.out.println();
        }
    }
