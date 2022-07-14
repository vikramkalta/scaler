import java.util.ArrayList;

public class BacteriaExperiment {
    public static void main(String args[]) {
        // int A = 6;
        // int[][] B = { { 1, 5 }, { 5, 3 }, { 5, 6 }, { 6, 2 }, { 6, 4 }, };
        // int A = 13;
        // int[][] B = { { 10, 6 }, { 3, 2 }, { 12, 7 }, { 9, 5 }, { 2, 1 }, { 8, 3 }, {
        // 7, 1 }, { 4, 2 }, { 6, 3 },
        // { 11, 4 }, { 5, 3 }, { 13, 11 }, };
        // int A = 11;
        // int[][] B = { { 3, 1 }, { 2, 1 }, { 5, 4 }, { 9, 3 }, { 10, 2 }, { 7, 1 }, {
        // 4, 3 }, { 8, 2 }, { 11, 8 },
        // { 6, 4 }, };
        int A = 8;
        int[][] B = { { 8, 2 }, { 6, 3 }, { 5, 2 }, { 3, 1 }, { 4, 2 }, { 7, 2 }, { 2, 1 }, };
        System.out.println(solve(A, B));
    }

    public static int dia = 0;

    public static int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            edges.add(new ArrayList<Integer>());
        }
        int edgesLen = B.length;
        for (int i = 0; i < edgesLen; i++) {
            int vertex = B[i][0];
            int edge = B[i][1];
            edges.get(vertex - 1).add(edge - 1);
            edges.get(edge - 1).add(vertex - 1);
        }
        int[] visited = new int[A];
        for (int i = 0; i < A; i++) {
            diameter(edges, i, visited);
        }
        int result = (int) Math.ceil(Math.log(dia) / Math.log(2));
        // int result = (int) (Math.log(dia) / Math.log(2));
        return result;
    }

    public static int diameter(ArrayList<ArrayList<Integer>> edges, int node, int[] visited) {
        visited[node] = 1;
        int edgesLen = edges.get(node).size();
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < edgesLen; i++) {
            int currNode = edges.get(node).get(i);
            if (visited[currNode] == 0) {
                int height = diameter(edges, currNode, visited);
                if (height > max1) {
                    max2 = max1;
                    max1 = height;
                } else if (height > max2) {
                    max2 = height;
                }
            }
        }
        dia = Math.max(dia, max1 + max2);
        // dia = Math.max(dia, max1 + max2);
        return max1 + 1;
    }
}
