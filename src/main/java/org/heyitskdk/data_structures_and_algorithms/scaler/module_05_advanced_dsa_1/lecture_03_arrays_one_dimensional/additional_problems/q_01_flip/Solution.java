package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_03_arrays_one_dimensional.additional_problems.q_01_flip;

public class Solution {
    public int[] flip(String A) {
        int[] pair = new int[2];
        int left = 0, right = -1;
        int startIndex = 0;

        char[] letters = A.toCharArray();

        int currentSum = 0, maxSum = 0;
        for (int i = 0; i < A.length(); i++) {
            char letter = letters[i];
            if (letter == '0') {
                currentSum++;
            } else {
                currentSum--;
            }

            // updating sum and index if maximum is achieved            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = left;
                right = i;
            }

            // re-setting sum and indexes for negative sum
            if (currentSum < 0) {
                currentSum = 0;
                left = i + 1;
            }
        }

        // array contains only 1s
        if (right == -1) return new int[]{};

        return new int[] { startIndex + 1, right + 1 };
    }
}
