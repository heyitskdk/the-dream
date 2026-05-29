package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_04_know_basic_maths.q_07_check_for_prime_number;

class Solution {
    static boolean isPrime(int n) {
        // code here
        if (n == 1) return false;
        if (n == 2) return true;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}