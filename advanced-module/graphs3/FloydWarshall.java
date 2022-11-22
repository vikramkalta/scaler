public class FloydWarshall {
    public static void main(String args[]) {
        // int[][] A = {
        // {0,50,39},
        // {-1,0,-1},
        // {-1,10,0}
        // };
        int[][] A = {
                { 0, 5, -1, 10 },
                { -1, 0, 3, -1 },
                { -1, -1, 0, 1 },
                { -1, -1, -1, 0 },
        };
        // System.out.println(solve(A));
        int[][] res = solve(A);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j] + ", ");
            }
            System.out.println();
        }
    }
    // public static long x = 10000000000l;
    public static int x = 100000005;
    public static int[][] solve(int[][] A) {
        int len = A.length;
        // int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = x;
                }
                // if (i==j)result[i][j] =0;
                // else result[i][j] = A[i][j] == -1 ? x : (A[i][j] * 1l);
            }
        }
        for (int k = 0; k < len; k++) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (A[i][k] + A[k][j] < A[i][j]) {
                    A[i][j] = A[i][k] + A[k][j];
                }
                    // if (i == j) {
                    //     result[i][j] = 0l;
                    // } else 
                    // if (result[i][j] > result[i][k] + result[k][j]) {
                    //     result[i][j] = result[i][k] + result[k][j];
                    // }
                }
            }
        }
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++) {
                A[i][j] = A[i][j] == x ? -1 : A[i][j];
            }
        }
        return A;
    }
}