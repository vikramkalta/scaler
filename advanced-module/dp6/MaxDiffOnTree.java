import java.util.ArrayList;

public class MaxDiffOnTree {
    public static void main(String args[]) {
        // int[] A = {10,5,12,6};
        // int[][] B = {{1,2},{1,4},{4,3}};
        int[] A = { -59, -33, 34, 0, 69, 24, -22, 58, 62, -36, 5, 45, -19 };
        int[][] B = { { 10, 6 }, { 3, 2 }, { 12, 7 }, { 9, 5 }, { 2, 1 }, { 8, 3 }, { 7, 1 }, { 4, 2 }, { 6, 3 },
                { 11, 4 }, { 5, 3 }, { 13, 11 }, };
        // int x = -50;
        // int y = -20;
        // int z = Math.abs(x - y);
        System.out.println(solve(A, B));
    }
    // public static int max = Integer.MIN_VALUE;

    public static int solve(int[] A, int[][] B) {
        int max = Integer.MIN_VALUE;
        int lenA = A.length;
        int lenB = B.length;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < lenA; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < lenB; i++) {
            int currVertex = B[i][0];
            int currEdge = B[i][1];
            edges.get(currVertex - 1).add(currEdge - 1);
        }
        ArrayList<ArrayList<Integer>> children = new ArrayList<>();
        for (int i = 0; i < lenA; i++) {
            ArrayList<Integer> childrenX = getChildren(edges, i, new ArrayList<Integer>());
            children.add(childrenX);
        }
        for (int i = 0; i < lenA; i++) {
            int currVertex = A[i];
            int currChildLen = children.get(i).size();
            for (int j = 0; j < currChildLen; j++) {
                int currEdgeIndex = children.get(i).get(j);
                int currEdge = A[currEdgeIndex];
                int x = Math.abs(currVertex - currEdge);
                if (x > max) {
                    max = x;
                }
            }
        }
        return max;
    }

    public static ArrayList<Integer> getChildren(ArrayList<ArrayList<Integer>> edges, int node, ArrayList<Integer> children) {
        int len = edges.get(node).size();
        for (int i = 0; i < len; i++) {
            int curr = edges.get(node).get(i);
            children.add(curr);
            getChildren(edges, curr, children);
        }
        return children;
    }

    public static int solve1(int[] A, int[][] B) {
        int lenA = A.length;
        int lenB = B.length;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < lenA; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < lenB; i++) {
            int vertex = B[i][0];
            int edge = B[i][1];
            edges.get(vertex - 1).add(edge - 1);
        }
        for (int i = 0; i < lenA; i++) {
            getMaxDiff(edges, A, i);
        }
        return 0;
    }
    public static void getMaxDiff(ArrayList<ArrayList<Integer>> edges, int[] A, int node) {
        if (edges.get(node).isEmpty()) {
            return;
        }
        int len = edges.get(node).size();
        int currVertex = A[node];
        for (int i = 0; i < len; i++) {
            int currNodeIndex = edges.get(node).get(i);
            int currNode = A[currNodeIndex];
            getMaxDiff(edges, A, currNodeIndex);
            int x = Math.abs(currVertex - currNode);
            // if (max < x) {
            //     max = x;
            // }
        }
    }
}