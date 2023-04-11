import java.util.HashSet;

public class SquarefulArrays {
    public static void main(String args[]) {
        // int[] A = { 1, 17, 8 };
        // int[] A = {2850, 286, 155};
        int[] A = {6009, 715, 14, 35, 1, 3, 33, 16, 84, 60, 4};
        // int[] A = {1,1,8,1,8};
        // int[] A = {428, 56, 88, 12};
        System.out.println(solve(A));
    }

    public static int ans = 0;

    public static int solve(int[] A) {
        if (A.length == 1) {
            int z = A[0];
            int z1 = (int) Math.sqrt(z);
            int z2 = z1 * z1;
            if (z2 != z) {
                return 0;
            }
            return 1;
        }
        // int[][] dp = new int[A.length][A.length];
        int[] dp = new int[A.length];
        getPerms(A, 0, dp);
        // System.out.println(__i);
        return ans;
    }
    public static int __i = 0;
    public static void getPerms(int[] A, int i, int[] dp) {
        // __i++;
        if (i == A.length - 1) {
            // ans++;
            int[] B = new int[A.length];
            for (int index = 0; index < A.length; index++) {
                B[index] = A[index];
            }
            boolean isSquareFul = true;
            for (int j = 0; j < B.length - 1; j++) {
                int x = B[j];
                int y = B[j + 1];
                int z = x + y;
                int z1 = (int) Math.sqrt(z);
                int z2 = z1 * z1;
                if (z2 != z) {
                    isSquareFul = false;
                    break;
                }
            }
            if (isSquareFul) {
                ans++;
            }
            return;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int j = i; j < A.length; j++) {
            // if (dp[i] == 1) {
            //     continue;
            // }
            // if (i!=j && A[i]==A[j]) {
            //     continue;
            // }
            if(set.contains(A[j])){
                continue;
            }
            set.add(A[j]);
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            // dp[i] = 1;
            if (i == 0 || (i > 0 && isSquare(A[i], A[i - 1]))) {
                getPerms(A, i + 1, dp);
            }
            // dp[i] = 0;
            temp = A[j];
            A[j] = A[i];
            A[i] = temp;
        }
    }
    public static boolean isSquare(int i, int j) {
        int k = i + j;
        int k1 = (int) Math.sqrt(k);
        int k2 = k1 * k1;
        // int k = (int)Math.sqrt(i + j);
        return k == k2;
    }
}
