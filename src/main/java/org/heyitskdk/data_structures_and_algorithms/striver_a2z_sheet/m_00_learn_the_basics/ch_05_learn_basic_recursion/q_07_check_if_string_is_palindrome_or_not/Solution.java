package org.heyitskdk.data_structures_and_algorithms.striver_a2z_sheet.m_00_learn_the_basics.ch_05_learn_basic_recursion.q_07_check_if_string_is_palindrome_or_not;

class Solution {
    public boolean isPalindrome(String s) {
        // convert to lowercase
        s = s.toLowerCase();

        // internally uses System.arraycopy() - O(n)
        char[] arr = s.toCharArray();

        // remove non-alphanumeric characters
        arr = normalize(arr);

        return checkPalindrome(arr, 0, arr.length - 1);
    }

    private static char[] normalize(char[] arr) {
        // get count of alphanumeric characters
        int n = getCount(arr);
        char[] finalArr = new char[n];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            // alphanumeric checks
            boolean isAlphabet = ch >= 'a' && ch <= 'z';
            boolean isDigit = ch >= '0' && ch <= '9';

            if (isAlphabet || isDigit) {
                finalArr[index] = ch;
                index++;
            }
        }

        return finalArr;
    }

    private static int getCount(char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            // alphanumeric checks
            boolean isAlphabet = ch >= 'a' && ch <= 'z';
            boolean isDigit = ch >= '0' && ch <= '9';

            if (isAlphabet || isDigit) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkPalindrome(char[] arr, int si, int ei) {
        // base case
        if (si >= ei) return true;

        // normal case
        if (arr[si] != arr[ei]) return false;
        return checkPalindrome(arr, ++si, --ei);
    }
}