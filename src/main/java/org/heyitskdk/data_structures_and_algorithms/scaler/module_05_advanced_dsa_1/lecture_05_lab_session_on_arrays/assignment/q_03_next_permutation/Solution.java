package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_05_lab_session_on_arrays.assignment.q_03_next_permutation;

public class Solution {
    /*
    * Observation
    * -  Next permutation for a number is possible, only if there exists a digit, such that
    * there is at least one digit ahead of it, which is greater
    *
    * - IF no such digit exsits, the number is already present in its highest permutated state.
    * In such a scenario, reverse the number
    */
    public int[] nextPermutation(int[] A) {
        // approach
        // iterate array from rear until a valid digit is found
        // swap that digit with a number just greater than it, from the rear end itself
        // post swap at index, reverse portion of array present at rear
        // reverse the array if no such number exists
        
        int n = A.length;
        
        // boundary condition
        if (n == 1) return A;

        int swapIndex = getSwapIndex(A);

        // reverse array if no such digit is found
        if (swapIndex == -1) {
            reverse(A, 0 , n - 1);
            return A;
        }

        // perform swap
        // the digit to be swapped will be the first digit greater than the valid digit from rear
        int j = n - 1;
        while (j > swapIndex) {
            // swap digits
            if (A[j] > A[swapIndex]) {
                swap(A, swapIndex , j);
                break;
            }
            j--;
        }

        // reverse rear end of array to form the just next greater permutation
        reverse(A, swapIndex + 1, n - 1);

        return A;
    }

    private int getSwapIndex(int[] A) {
        int n = A.length;
        int swapIndex = -1;
        int i = n - 2;

        // find valid digit
        while (i >= 0) {
            if (A[i] < A[i + 1]) {
                swapIndex = i;
                break;
            }
            i--;
        }

        return swapIndex;
    }

    private void reverse(int[] A, int si, int ei) {
        while (si < ei) {
            swap(A, si, ei);
            si++; ei--;
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
