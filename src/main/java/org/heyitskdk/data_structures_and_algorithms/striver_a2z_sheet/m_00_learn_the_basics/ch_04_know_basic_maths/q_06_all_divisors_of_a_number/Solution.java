package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_04_know_basic_maths.q_06_all_divisors_of_a_number;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> getDivisors(int n) {
        // code here
        ArrayList<Integer> divisors = new ArrayList<>();
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        
        // sorting in ascending order
        Collections.sort(divisors);
        
        return divisors;
    }
}