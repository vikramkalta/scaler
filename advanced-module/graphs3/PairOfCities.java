public class PairOfCities {
    public static void main(String args[]) {
        // int A = 4;
        // int B = 6;
        // int C = 2;
        // int[] D = { 1, 2, 3, 2, 4, 3 };
        // int[] E = { 2, 3, 4, 4, 1, 1 };
        // int[] F = { 4, 1, 1, 1, 1, 1 };
        // int[] G = { 1, 1 };
        // int[] H = { 2, 3 };
        int  A = 15;
        int B = 18;
        int C = 29;
        int[] D = {11, 2, 2, 6, 2, 8, 9, 3, 14, 15, 4, 14, 8, 7, 8, 6, 2, 12};
        int[] E = {2, 1, 1, 2, 1, 1, 7, 3, 2, 13, 2, 1, 6, 1, 7, 1, 2, 10};
        int[] F = {8337, 6651, 29, 7765, 3428, 5213, 6431, 2864, 3137, 4024, 8169, 5013, 7375, 3786, 4326, 6415, 8982, 6864};
        int[] G = {6, 2, 1, 15, 12, 2, 14, 10, 13, 15, 15, 4, 8, 7, 9, 4, 15, 13, 12, 5, 2, 10, 1, 11, 14, 7, 3, 13, 12};
        int[] H = {5, 2, 15, 13, 6, 2, 8, 6, 3, 13, 15, 3, 1, 1, 4, 4, 5, 8, 1, 3, 1, 10, 15, 9, 2, 1, 1, 10, 2};
        System.err.println(solve(A, B, C, D, E, F, G, H));
    }

    public static int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
        int len = D.length;
        int qLen = G.length;
        int[] result = new int[qLen];
        int[][] matrix = new int[A][A];

        // int x = Integer.MAX_VALUE;
        int x = 100000005;

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == 0) {
                    matrix[i][j] = x;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            int node = D[i] - 1;
            int vertex = E[i] - 1;
            int weight = F[i];
            matrix[node][vertex] = Math.min(matrix[node][vertex], weight);
            matrix[vertex][node] = Math.min(matrix[vertex][node], weight);;
        }

        for (int k = 0; k < A; k++) {
            for (int i = 0; i < A; i++) {
                for (int j = 0; j < A; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < qLen; i++) {
            int node = G[i] - 1;
            int vertex = H[i] - 1;
            result[i] = matrix[node][vertex] == x ? -1 : matrix[node][vertex];
        }

        return result;
    }
}
