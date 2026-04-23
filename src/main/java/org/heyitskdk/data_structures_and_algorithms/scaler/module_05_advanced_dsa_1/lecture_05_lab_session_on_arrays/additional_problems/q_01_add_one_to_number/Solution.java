package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_05_lab_session_on_arrays.additional_problems.q_01_add_one_to_number;

public class Solution {
    public int[] plusOne(int[] A) {
        // pre-process array
        A = sanitize(A);
        int n = A.length;

        // edge case
        if (A[0] == 0) return new int[] {1};

        // edge case
        if (allDigitsAreNine(A)) {
            int[] number = new int[n + 1];
            number[0] = 1;
            return number;
        }

        // Scenario A - Most Significant Digit is Nine
        // approach - iterate from rear, as long as digit is nine, mark it 0
        // as soon as non-nine digit is found, increment it by 1
        int i = n - 1;
        if (A[i] == 9) {
            while (A[i] == 9) {
                A[i] = 0;
                i--;
            }
            A[i]++;
            return A;
        }
        
        // Sceanrio B - Most Significant Digit is Not Nine
        A[n - 1]++;
        return A;
    }

    // modify original array to remove keading zeroes
    private int[] sanitize(int[] A) {
        int n = A.length;
        int i = 0;
        int count = 0;
        while(i < n && A[i] == 0) {
            count++;
            i++;
        }

        // no leading zeroes are pressent
        if (count == 0) return A;

        // only zeroes are present 😭
        if (count == n) return new int[] {0};

        int[] arr = new int[n - count];
        i = 0;

        // form sanitized array
        for (int j = count; j < n; j++) {
            arr[i] = A[j];
            i++;
        }

        return arr;
    }

    private boolean allDigitsAreNine(int[] A) {
        for (int num: A) {
            if (num != 9) return false;
        }
        return true;
    }
}
