package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_03_arrays_one_dimensional.additional_problems.q_02_merged_intervals_2;

import java.util.ArrayList;

/*
* This solution is an optimzed and stylized version of my original solution
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B) {
        int n = A.size();
        int i = 0;
        int newStart = B.get(0);
        int newEnd = B.get(1);

        // adding intervals completely before B
        ArrayList<ArrayList<Integer>> mergedIntervals = new ArrayList<>();
        while (i < n && newStart > A.get(i).get(1)) {
            mergedIntervals.add(A.get(i));
            i++;
        }

        // merging intervals
        while (i < n && newEnd >= A.get(i).get(0)) {
            newStart = Math.min(A.get(i).get(0), newStart);
            newEnd = Math.max(A.get(i).get(1), newEnd);
            i++;
        }

        // adding the merged interval
        mergedIntervals.add(makeInterval(newStart, newEnd));

        // adding remaining intervals
        while (i < n) {
            mergedIntervals.add(A.get(i));
            i++;
        }

        return mergedIntervals;
    }

    private ArrayList<Integer> makeInterval(int start, int end) {
        ArrayList<Integer> interval = new ArrayList<>();
        interval.add(start);
        interval.add(end);

        return interval;
    }
}
