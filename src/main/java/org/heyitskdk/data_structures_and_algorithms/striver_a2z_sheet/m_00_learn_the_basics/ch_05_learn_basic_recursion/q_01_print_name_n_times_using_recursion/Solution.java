package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_05_learn_basic_recursion.q_01_print_name_n_times_using_recursion;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        print(n);
    }
    
    private static void print(int n) {
        if (n == 0) return;
        
        print(n - 1);
        System.out.printf("GFG ");
    }
}