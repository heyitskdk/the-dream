package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_06_learn_basic_hashing.q_01_counting_frequencies_of_array_elements;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public List<List<Integer>> countFrequencies(int[] nums) {
        // Your code goes here
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int freq = hmap.getOrDefault(num, 0);
            hmap.put(num, freq + 1);
        }

        List<List<Integer>> pairs = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: hmap.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            pairs.add(pair);
        }

        return pairs;
    }
}