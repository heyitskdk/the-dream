package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_06_learn_basic_hashing.q_02_highest_occuring_element_in_an_array;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int mostFreqEle(int[] arr) {
        // code here
        int maxFreq = 1;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int num: arr) {
            int freq = hmap.getOrDefault(num, 0);
            freq += 1;
            if (freq > maxFreq) maxFreq = freq;
            hmap.put(num, freq);
        }
        
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry: hmap.entrySet()) {
            if (entry.getValue() == maxFreq && entry.getKey() > max) {
                max = entry.getKey();
            }
        }
        
        return max;
    }
}