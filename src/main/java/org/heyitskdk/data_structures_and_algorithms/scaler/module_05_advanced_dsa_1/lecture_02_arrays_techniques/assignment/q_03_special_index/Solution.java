package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_02_arrays_techniques.assignment.q_03_special_index;

public class Solution {
    public int solve(int[] A) {
        int n = A.length;

        // edge case
        if (n == 1) return 1;

        // building prefix sum arrays
        int[] evenPrefixSum = buildEvenPrefixSumArray(A);
        int[] oddPrefixSum = buildOddPrefixSumArray(A);

        int answer = 0;

        // edge case - checking removal at 0th index
        int oddSum = evenPrefixSum[n - 1] - evenPrefixSum[0];
        int evenSum = oddPrefixSum[n - 1]; // since OddPrefixSum[0] = 0
        if (oddSum == evenSum) answer++;

        for (int i = 1; i < n; i++) {
            oddSum = oddPrefixSum[i - 1] + (evenPrefixSum[n - 1] - evenPrefixSum[i]);
            evenSum = evenPrefixSum[i - 1] + (oddPrefixSum[n - 1] - oddPrefixSum[i]);

            if (oddSum == evenSum) answer++;
        }

        return answer;
    }

    private int[] buildEvenPrefixSumArray(int[] A) {
        int n = A.length;
        
        int[] evenPrefixArray = new int[n];
        evenPrefixArray[0] = A[0];

        for (int i = 1; i < n; i++) {
            if ((i & 1) == 0) {
                evenPrefixArray[i] = A[i] + evenPrefixArray[i - 1];
            } else {
                evenPrefixArray[i] = evenPrefixArray[i - 1];
            }
        }

        return evenPrefixArray;
    }

    private int[] buildOddPrefixSumArray(int[] A) {
        int n = A.length;

        int[] oddPrefixArray = new int[n];
        oddPrefixArray[0] = 0;

        for (int i = 1; i < n; i++) {
            if ((i & 1) == 1) {
                oddPrefixArray[i] = A[i] + oddPrefixArray[i - 1];
            } else {
                oddPrefixArray[i] = oddPrefixArray[i - 1];
            }
        }

        return oddPrefixArray;
    }
}
