import java.util.ArrayList;

public class MaximumSum {
    public static void main(String args[]) {
        int[] a = {1, 5, -3, 4, -2};
        // int[] a = {3, 2, 1};
        // int[] a = {4, 5, 3, 2};
        // int[] a = {-1, -2, -3, -4, -5};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) A.add(a[i]);
        System.out.println(solve(A, 2, 1, -1));
        // System.out.println(solve(A, 1, -10, 3));
        // System.out.println(solve(A, 10, -10, 1));
        // System.out.println(solve(A, 1,2,-3));
    }

    public static int solve(ArrayList<Integer> A, int B, int C, int D) {
        int len = A.size();
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> leftMax = new ArrayList<>();
        ArrayList<Integer> rightMax = new ArrayList<>();
        for (int i = 0; i < len; i++) rightMax.add(-1);
        int lMax = max; int rMax = max;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            curr *= B;
            if (lMax < curr) {
                lMax = curr;
            }
            leftMax.add(lMax);
        }
        for (int i = len - 1; i >= 0; i--) {
            int curr = A.get(i);
            curr *= D;
            if (rMax < curr) {
                rMax = curr;
            }
            rightMax.set(i, rMax);
        }
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            curr *= C;
            int x = leftMax.get(i);
            int y = rightMax.get(i);
            int z = x + y + curr;
            if (max < z) {
                max = z;
            }
        }
        return max;
    }

    public static int solve1(ArrayList<Integer> A, int B, int C, int D) {
        int len = A.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int x = A.get(i) * B;
            for (int j = i; j < len; j++) {
                int y = A.get(j) * C;
                for (int k = j; k < len; k++) {
                    int z = A.get(k) * D;
                    int prod = x + y + z;
                    if (max < prod) {
                        max = prod;
                    }
                }
            }
        }
        return max;
    }
}