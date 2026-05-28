package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_04_know_basic_maths.q_04_gcd_of_two_numbers;

class Solution {
    public static int gcd(int a, int b) {
        // code here
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        if (max % min == 0) return min;
        
        int answer = 1;
        for (int i = 1; i*i <= min; i++) {
            if (min % i == 0) {
                if (max % i == 0) answer = Math.max(answer, i);
                int factor = min / i;
                if (max % factor == 0) answer = Math.max(answer, factor);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(gcd(15, 16));
    }
}
