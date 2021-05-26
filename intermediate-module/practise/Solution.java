package practise;

import java.util.Random;

public class Solution {
    public static int solve(int[] A) {
        int len = A.length;

        if (len == 0) {
            return 0;
        }
        int max = A[0];
        for (int i = 0; i < len; i++) {
            if (max < A[i]) {
                max = A[i];
            }
        }
        System.out.println("max " + max);

        int min = A[0];
        for (int i = 0; i < len; i++) {
            if (min > A[i]) {
                min = A[i];
            }
        }
        System.out.println("min " + min);

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] > min && A[i] < max) {
                count++;
            }
        }
        System.out.println("count " + count);
        return count;
    }

    public static int getTwoLargest(int[] A) {
        int len = A.length;

        if (len == 0) {
            return 0;
        }

        int max1 = A[0];
        int max2 = A[0];
        for (int i = 0; i < len; i++) {
            if (max2 < A[i]) {
                max2 = A[i];
                max1 = max2;
            }
        }
        System.out.println("max2 " + max2 + "max1 " + max1);

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] < max2) {
                count++;
            }
        }

        System.out.println("count " + count);
        return count;
    }

    public static void main(String[] args) {
        int n = 10;

        int arr[] = new int[n];
        Random rand = new Random();
        int upperbound = n;
        // generate random values from 0-10
        for (int i = 0; i < n; i++) {
            int int_random = rand.nextInt(upperbound);
            arr[i] = int_random;
            System.out.println("el " + arr[i]);
        }

        int a = Solution.getTwoLargest(arr);
        // System.out.println("a " + a);
    }

}
