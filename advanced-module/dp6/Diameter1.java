import java.util.ArrayList;

public class Diameter1 {
    public static void main(String args[]) {
        // int A = 6;
        // int[][] B = { { 1, 5 }, { 5, 3 }, { 5, 6 }, { 6, 2 }, { 6, 4 }, };
        int A = 9;
        int[][] B = { {1,2},{1,3},{1,4},{2,5},{2,6},{3,7},{5,8},{5,9} };
        System.out.println(solve(A, B));
    }

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
        }
        int ans = diameter(edges, 0);
        return ans;
    }

    public static int diameter(ArrayList<ArrayList<Integer>> edges, int node) {
        // if (edges.get(node).isEmpty()) {
        //     return 0;
        // }
        int edgesLen = edges.get(node).size();
        int max1 = 0, max2 = 0;
        int maxDia = 0;
        for (int i = 0; i < edgesLen; i++) {
            int currNode = edges.get(node).get(i);
            int height = getHeight(edges, currNode);
            if (height > max1) {
                max2 = max1;
                max1 = height;
            } else if (height > max2) {
                max2 = height;
            }
            // maxDia = Math.max(maxDia, max1 + max2);
        }
        for (int i = 0; i < edgesLen; i++) {
            int currNode = edges.get(node).get(i);
            maxDia = Math.max(maxDia, diameter(edges, currNode));
        }
        return Math.max(maxDia, max1 + max2);
    }

    public static int getHeight(ArrayList<ArrayList<Integer>> edges, int node) {
        // if (edges.get(node).isEmpty()) {
        //     return 0;
        // }
        int maxHeight = 0;
        int edgesLen = edges.get(node).size();
        for (int i = 0; i < edgesLen; i++) {
            int currNode = edges.get(node).get(i);
            int height = getHeight(edges, currNode);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight + 1;
    }
}