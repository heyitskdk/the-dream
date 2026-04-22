package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_05_lab_session_on_arrays.assignment.q_01_rain_water_trapped;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        // approach - iterate original array, and form arrays storing max height
        // present at left and right for an index
        // water above a building = min(lmax, rmax) - height of current building, if >= 0
        int n = A.length;

        // edge case
        if (n < 3) return 0;

        int[] maxHeightAtRight = buildRightMax(A);
        int maxHeightAtLeft = A[0];

        long rainWaterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int currentHeight = A[i];
            int ceiling = Math.min(maxHeightAtLeft, maxHeightAtRight[i]);

            if (ceiling > currentHeight) {
                rainWaterTrapped += ceiling - currentHeight;
            }

            // updating max height at left
            maxHeightAtLeft = Math.max(maxHeightAtLeft, currentHeight);
        }

        return (int) rainWaterTrapped;
    }

    private int[] buildRightMax(int[] A) {
        int n = A.length;
        int[] maxHeightAtRight = new int[n];
        maxHeightAtRight[n - 1] = A[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int height = A[i];
            if (height > maxHeightAtRight[i + 1]) {
                maxHeightAtRight[i] = height;
            } else {
                maxHeightAtRight[i] = maxHeightAtRight[i + 1];
            }
        }

        return maxHeightAtRight;
    }
}
