package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_04_know_basic_maths.q_03_palindrome_number;

class Solution {
    public boolean isPalindrome(int x) {
        // negative numbers aren't palindromes
        if (x < 0) return false;
        long number = x;
        if (number == reverse(x)) return true;
        return false;
    }

    public static long reverse(int x) {
        long num = 0l;
        while (x > 0) {
            int digit = x % 10;
            num *= 10;
            num += digit;
            x /= 10;
        }
        return num;
    }
}