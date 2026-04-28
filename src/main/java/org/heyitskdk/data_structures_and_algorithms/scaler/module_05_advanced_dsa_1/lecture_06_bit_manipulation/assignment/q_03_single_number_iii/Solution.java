package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_06_bit_manipulation.assignment.q_03_single_number_iii;

public class Solution {
    public int[] solve(int[] A) {
        int xor = 0;
        for (int num: A) xor ^= num;

        // finding first set-bit of the xored value
        int i = 0;
        while (xor > 0 && ((xor & 1) == 0)) {
            i++;
            xor >>= 1;
        }

        // groupA: set bit is 0, groupB: set bit is 1
        int groupA = 0, groupB = 0;
        for (int num: A) {
            if (((num >> i) & 1) == 0) {
                groupA ^= num;
            } else {
                groupB ^= num;
            }
        }

        return groupA < groupB ? new int[] { groupA, groupB } : new int[] { groupB, groupA };
    }

    public int[] optimisedSolution(int[] A) {
        int xor = 0;
        for (int num: A) xor ^= num;

        // this has a '1' exactly on the lowest set bit
        int diffBit = xor & -xor;

        int a = 0, b = 0;
        for (int num: A) {
            // If AND with the diffBit is 0: bit of num at that position is unset
            if ((num & diffBit) == 0) a ^= num;
            else b ^= num;
        }

        return a < b ? new int[] {a, b} : new int[] {b, a};
    }
}
