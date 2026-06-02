package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_09_lab_session_on_recursion.additional_problems.q_02_check_palindrome_using_recursion;

public class Solution {
    public int solve(String A) {
        char[] arr = A.toCharArray();
        return checkPalindrome(arr, 0, arr.length - 1) ? 1 : 0;
    }

    private static boolean checkPalindrome(char[] arr, int si, int ei) {
        // base case
        if (si >= ei) return true;

        // normal case
        if (arr[si] != arr[ei]) {
            return false;
        } else {
            return checkPalindrome(arr, si + 1, ei - 1);
        }
    }
}
