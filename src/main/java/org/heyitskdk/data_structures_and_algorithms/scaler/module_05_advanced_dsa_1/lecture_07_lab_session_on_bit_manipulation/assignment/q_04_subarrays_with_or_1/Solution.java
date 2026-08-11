package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_07_lab_session_on_bit_manipulation.assignment.q_04_subarrays_with_or_1;

public class Solution {
    public int subarraysWithOR1(int[] A) {
        int n = A.length;
        int allSubarrays = (n * (n + 1)) / 2;

        int subWithOrZero = 0;
        int len = 0;
        int i = 0;
        while (i < n) {
            if (A[i] == 0) {
                len++;
            } else {
                subWithOrZero += (len * (len + 1)) / 2;
                len = 0;
            }
            i++;
        }

        if (len > 0) {
            subWithOrZero += (len * (len + 1)) / 2;
        }

        return allSubarrays - subWithOrZero;
    }
}
