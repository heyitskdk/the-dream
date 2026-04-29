package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_06_bit_manipulation.additional_problems.q_01_find_nth_magic_number;

public class Solution {
    public int solve(int A) {
        // observation
        // binary number progression just expressed with the power of 5, with 1-based indexing
        // 001, 010, 011, 100, 101 => 5^1, 5^2, (5^1 + 5^2), 5^3, (5^3 + 5^1)
        
        int magicNumber = 0;
        int i = 1;
        while (A > 0) {
            // if bit is set
            if ((A & 1) == 1) {
                magicNumber += Math.pow(5, i);
            }

            A >>= 1;
            i++;
        }

        return magicNumber;
    }

    public int optimisedSolution(int A) {
        int magicNumber = 0;
        int power = 5;

        for (int n = A; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                magicNumber += power;
            }
            power *= 5;
        }

        return magicNumber;
    }
}
