package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_02_arrays_techniques.additional_problems.q_02_product_array_puzzle;

import java.util.Arrays;

public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;
        int[] answer = prefixProductArray(A);
        int suffixProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct;
            suffixProduct *= A[i];
        }

        return answer;
    }

    private int[] prefixProductArray(int[] A) {
        int n = A.length;

        int[] prefixProduct = new int[n];
        prefixProduct[0] = 1;

        for (int i = 1; i < n; i++) {
            prefixProduct[i] = A[i - 1] * prefixProduct[i - 1];
        }

        return prefixProduct;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Answer: " + Arrays.toString(s.solve(new int[] { 1, 2, 3, 4, 5 })));
    }
}
