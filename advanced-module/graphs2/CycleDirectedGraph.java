import java.util.ArrayList;

public class CycleDirectedGraph {
    public static void main(String args[]) {
        // int[][] a = { { 1, 2 }, { 4, 1 }, { 2, 4 }, { 3, 4 }, { 5, 2 }, { 1, 3 } };
        // int[][] a = {{1, 2},{2,3},{3,4},{4,5}};
        // int[][] a = {{1, 2}};
        int[][] a = {{1, 2},{1, 3},{2, 3},{1, 4},{4, 3},{4, 5},{3, 5}};
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int iCurr = a[i][0];
            int jCurr = a[i][1];
            ArrayList<Integer> innerArr = new ArrayList<>();
            innerArr.add(iCurr);
            innerArr.add(jCurr);
            A.add(innerArr);
        }
        // System.out.println(solve(5, A));
        // System.out.println(solve(2, A));
        System.out.println(solve(5, A));
    }

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static Boolean[] visited;
    public static Boolean[] dfsVisited;

    public static void createGraph(ArrayList<ArrayList<Integer>> matrix) {
        int len = matrix.size();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> curr = matrix.get(i);
            int vertex = curr.get(0);
            int adj = curr.get(1);
            graph.get(vertex - 1).add(adj);
        }
    }

    public static boolean isCyclePresent = false;

    public static void dfs(int vertex) {
        if (visited[vertex] && dfsVisited[vertex]) {
            isCyclePresent = true;
            return;
        }
        visited[vertex] = true;
        dfsVisited[vertex] = true;
        ArrayList<Integer> adjList = graph.get(vertex);
        int len = adjList.size();
        for (int i = 0; i < len; i++) {
            if (isCyclePresent) {
                break;
            }
            int curr = adjList.get(i);
            dfs(curr - 1);
        }
        dfsVisited[vertex] = false;
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        visited = new Boolean[A];
        dfsVisited = new Boolean[A];
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
            visited[i] = false;
            dfsVisited[i] = false;
        }
        createGraph(B);

        for (int i = 0; i < A; i++) {
            if (!visited[i]) {
                dfs(i);
                if (isCyclePresent) {
                    break;
                }
            }
        }
        return isCyclePresent ? 1 : 0;
    }
}