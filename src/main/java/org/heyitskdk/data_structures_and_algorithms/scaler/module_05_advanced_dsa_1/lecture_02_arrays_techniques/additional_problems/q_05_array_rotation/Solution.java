package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_02_arrays_techniques.additional_problems.q_05_array_rotation;

public class Solution {
    public int[] solve(int[] A, int B) {
        int n = A.length;

        // re-setting to actual number of rotations required
        B %= n;

        // reversing complete array
        reverseArray(A, 0, n - 1);

        // reversing array elements from index [0, B - 1]
        reverseArray(A, 0, B - 1);

        // reversing array elements from index [B, n - 1]
        reverseArray(A, B, n - 1);

        return A;
    }

    private void reverseArray(int[] A, int leftIndex, int rightIndex) {
        while(leftIndex < rightIndex) {
            int temp = A[leftIndex];
            A[leftIndex] = A[rightIndex];
            A[rightIndex] = temp;

            leftIndex++;
            rightIndex--;
        }
    }
}
