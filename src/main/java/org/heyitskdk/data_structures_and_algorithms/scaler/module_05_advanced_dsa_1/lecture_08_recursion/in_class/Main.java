package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_08_recursion.in_class;

public class Main {

    private static int factorial(int n) {
        // base condition
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    private static void printIncreasing(int n) {
        // base case
        if (n < 1) return;

        // normal case
        printIncreasing(n - 1);
        System.out.printf("%d ", n);
    }

    private static void printDecreasing(int n) {
        // base case
        if (n < 0) return;

        System.out.printf("%d ", n);
        printDecreasing(n - 1);
    }

    public static void main(String[] args) {
        int num = 0;
        System.out.printf("factorial of %d is : %d\n", num, factorial(num));

        printIncreasing(5); System.out.println();
        printDecreasing(10); System.out.println();
    }
}
