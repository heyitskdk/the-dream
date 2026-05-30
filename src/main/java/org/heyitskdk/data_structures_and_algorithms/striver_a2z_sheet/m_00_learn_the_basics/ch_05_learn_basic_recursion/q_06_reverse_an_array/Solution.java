package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_05_learn_basic_recursion.q_06_reverse_an_array;

class Solution {
    public static void reverseArray(int arr[]) {
        // code here
        reverseRecursively(arr, 0, arr.length - 1);
    }
    
    private static void reverseRecursively(int[] arr, int si, int ei) {
        // base case
        if (si >= ei) return;
        
        // normal case
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
        
        reverseRecursively(arr, si + 1, ei - 1);
    }

    public static void main(String[] args) {
        reverseArray(new int[] { 1, 2, 3, 4 });
    }
}