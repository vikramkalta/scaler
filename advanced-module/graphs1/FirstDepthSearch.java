import java.util.ArrayList;

public class FirstDepthSearch {
    public static void main(String args[]) {
        int[] A = { 1, 1, 2 };
        int B = 1;
        int C = 2;
        System.out.println(solve(A, B, C));
    }

    public static int solve(int[] A, final int B, final int C) {
        int len = A.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 1; i < len; i++) {
            int vertex = A[i] - 1;
            int edge = i;
            graph.get(vertex).add(edge);
        }
        int[] visited = new int[len];
        dfs(graph, visited, C - 1);
        return visited[B - 1];
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int edge) {
        visited[edge] = 1;
        for (int i = 0; i < graph.get(edge).size(); i++) {
            int currVertex = graph.get(edge).get(i);
            if (visited[currVertex] == 0) {
                dfs(graph, visited, currVertex);
            }
        }
    }
}