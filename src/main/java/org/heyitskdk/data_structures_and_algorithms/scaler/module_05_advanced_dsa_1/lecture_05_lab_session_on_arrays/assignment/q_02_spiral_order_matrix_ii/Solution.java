package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_05_lab_session_on_arrays.assignment.q_02_spiral_order_matrix_ii;

public class Solution {
    public static int[][] generateMatrix(int A) {
        int[][] spiralMatrix = new int[A][A];

        int i = 0, j = 0;
        int num = 1;
        while (A > 1) {
            // columnar traversal from 0 to A - 2
            for (int k = 0; k < A - 1; k++) {
                spiralMatrix[i][j] = num;
                num++;
                j++;
            }

            // row-wise traversal from
            for (int k = 0; k < A - 1; k++) {
                spiralMatrix[i][j] = num;
                num++;
                i++;
            }

            // columnar traversal from A - 1 to 1
            for (int k = 0; k < A - 1; k++) {
                spiralMatrix[i][j] = num;
                num++;
                j--;
            }

            // row-wise traversal from A - 1 to 1
            for (int k = 0; k < A - 1; k++) {
                spiralMatrix[i][j] = num;
                num++;
                i--;
            }

            // move to inner-spiral
            i++; j++; A -= 2;
        }

        // setting inner-most spiral element for odd-length spirals
        if (A == 1) {
            spiralMatrix[i][j] = num;
        }

        return spiralMatrix;
    }

    // debug - see spiral in console
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + (j != m - 1 ? ", " : " ]\n"));
            }
        }
    }

    // debug - run
    public static void main(String[] args) {
        printMatrix(generateMatrix(4));
    }
}
