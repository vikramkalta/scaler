import java.util.ArrayList;

public class MaximizeGCD {
    public static void main(String args[]) {
        // int[] arr ={81991, 2549, 7};
        // int[] arr ={2, 3, 4, 5};
        // int[] arr = {13, 1, 8, 10};
        // int[] arr = {6, 2, 13, 4, 13, 9, 13, 3, 5};
        // int[] arr = {4, 4, 4, 4, 4, 4};
        // int[] arr = {3, 9, 6, 8, 3};
        int[] arr = {7, 21};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) A.add(arr[i]);
        System.out.println(maximizeGCD(A));
    }

    public static int maximizeGCD(ArrayList<Integer> A) {
        int len = A.size();

        int min = Integer.MAX_VALUE;
        int minIndex = Integer.MIN_VALUE;

        int result = A.get(0);
        min = result;
        minIndex = 0;
        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            result = gcd(result, curr);
            if (min > result) {
                min = result;
                minIndex = i;
            }
        }

        result = 0;
        for (int i = 0; i < len; i++) {
            if (i == minIndex) continue;
            int curr = A.get(i);
            result = gcd(result, curr);
        }
        
        return result;
    }

    public static int maximizeGCD2(ArrayList<Integer> A) {
        int len = A.size();

        // int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int result = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                result = gcd(A.get(j), result);
            }
            if (max < result) {
                max = result;
            }
        }
        
        return max;
    }

    public static int maximizeGCD1(ArrayList<Integer> A) {
        int len = A.size();

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int result = A.get(0);
        for (int i = 1; i < len; i++) {
            int currI = A.get(i);
            result = gcd(currI, result);
            if (min > result) {
                min = currI;
                minIndex = -1;
            }
        }
        result = 0;
        for (int i = 0; i < len; i++) {
            if (i == minIndex) continue;
            int curr = A.get(i);
            result = gcd(curr, result);
        }
        return result;
    }

    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
