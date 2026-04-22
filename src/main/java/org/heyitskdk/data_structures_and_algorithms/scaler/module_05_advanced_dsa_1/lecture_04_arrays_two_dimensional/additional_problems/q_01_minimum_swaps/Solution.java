package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_04_arrays_two_dimensional.additional_problems.q_01_minimum_swaps;

public class Solution {
    public int solve(int[] A, int B) {
        // approach - slide window, keep track of which window is best
        int n = A.length;
        int window = getWindowSize(A, B);

        // edge case
        if (window == 0 || window == 1) return 0;

        // badNums - nums greater than B
        int badNums = getNumbersGreaterThanBInFirstWindow(A, B, window);

        // slide window and track min swaps
        int swaps = badNums;
        int start = 1, end = window;
        while (end < n) {
            // outgoing number from window
            if (A[start - 1] > B) badNums--;
            // incoming number in the window
            if (A[end] > B) badNums++;

            // update swaps
            if (badNums < swaps) swaps = badNums;

            // slide window
            start++;
            end++;
        }

        return swaps;
    }

    private int getWindowSize(int[] A, int B) {
        int size = 0;
        for (int num : A) {
            if (num <= B) {
                size++;
            }
        }
        return size;
    }

    private int getNumbersGreaterThanBInFirstWindow(int[] A, int B, int window) {
        int badNums = 0;
        for (int i = 0; i < window; i++) {
            if (A[i] > B) {
                badNums++;
            }
        }
        return badNums;
    }
}
