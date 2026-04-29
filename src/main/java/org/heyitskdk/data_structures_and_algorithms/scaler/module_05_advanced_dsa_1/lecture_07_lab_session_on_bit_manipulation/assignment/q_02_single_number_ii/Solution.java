package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_07_lab_session_on_bit_manipulation.assignment.q_02_single_number_ii;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            if (numberOfOneBits(A, i) % 3 == 1) {
                // set the bit of answer at ith position
                answer |= (1 << i);
            }
        }
        return answer;
    }

    private int numberOfOneBits(int[] A, int i) {
        int oneBits = 0;
        for (int j = 0; j < A.length; j++) {
            if ((A[j] & (1 << i)) != 0) oneBits++;
        }
        return oneBits;
    }
}

/*
* Methodology
* Rather than reading each array element 32 times, we iterate array once
* The code still iterates 32 * n times, but repeated passes over array have been optimized
* */
class OptimalSolution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        // technically still constant space
        int[] bits = new int[32];
        populateBits(bits, A);

        int answer = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                answer |= (1 << i);
            }
        }

        return answer;
    }

    private void populateBits(int[] bits, int[] A) {
        for (int i = 0; i < 32; i++) {
            for (int num: A) {
                bits[i] += (num >> i) & 1;
            }
        }
    }
}
