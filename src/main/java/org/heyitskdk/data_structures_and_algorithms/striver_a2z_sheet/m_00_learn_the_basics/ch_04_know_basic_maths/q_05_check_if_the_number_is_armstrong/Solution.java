package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_04_know_basic_maths.q_05_check_if_the_number_is_armstrong;

class Solution {
    public boolean isArmstrong(int n) {
        int power = countDigits(n);
        return n == calculateSum(n, power);
    }

    public static int countDigits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    public static int calculateSum(int num, int power) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += (int)(Math.pow(digit, power));
            num /= 10;
        }
        return sum;
    }
}