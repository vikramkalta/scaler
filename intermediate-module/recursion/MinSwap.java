import java.util.HashMap;

public class MinSwap {
    public static void main(String args[]) {
        int A = 3;
        int[] B = {3,5,6,4,1,2};
        int[][] C = {{1,3},{2,6},{4,5}};
        System.out.println(solve(A, B, C));
    }

    public static int solve(int A, int[] B, int[][] C) {
        HashMap<Integer, Integer> pairMap = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            int x = C[i][0];
            int y = C[i][1];
            pairMap.put(x, y);
            pairMap.put(y, x);
        }
        int ans = 0;
        for (int i = 0; i < B.length - 1; i+=2) {
            int x = B[i];
            int y = B[i + 1];
            if (y != pairMap.get(x)) {
                for (int j = 0; j < B.length; j++) {
                    if (pairMap.get(x) == B[j]) {
                        swap(B, i + 1, j);
                        ans++;
                        break;
                    }
                }
            } else if (x != pairMap.get(y)) {
                for (int j = 0; j < B.length; j++) {
                    if (pairMap.get(y) == B[j]) {
                        swap(B, i + 1, j);
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
