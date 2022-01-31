import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWeightedCycle {
    public static void main(String args[]) {
        int[][] arr = {{1,2,2},{2,3,3},{3,4,1},{4,1,4},{1,3,15}};
        // int[][] arr1 = {{1,2,2},{2,3,3}};
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                innerList.add(arr[i][j]);
            }
            B.add(innerList);
        }
        System.out.println(solve(4, B));
    }
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] visited;
    private static HashMap<Integer, HashMap<Integer, Integer>> weightMap = new HashMap<>();

    public static void createGraph(int A, ArrayList<ArrayList<Integer>> B) {
        for (int i = 0; i < A; i++) {
            int vertex = B.get(i).get(0) - 1;
            int edge = B.get(i).get(1) - 1;
            int weight = B.get(i).get(2);
            graph.get(vertex).add(edge);
            // graph.get(edge).add(vertex);
            HashMap<Integer, Integer> innerMap = new HashMap<>();
            innerMap.put(edge, weight);
            weightMap.put(vertex, innerMap);
        }
    }
    private static int sum = 0;
    private static int min = Integer.MAX_VALUE;
    public static void dfs(int vertex) {
        if (visited[vertex] == 1) {
            if (min > sum) {
                min = sum;
            }
            sum = 0;
        }
        visited[vertex] = 1;
        ArrayList<Integer> edges = graph.get(vertex);
        for (int i = 0, len = edges.size(); i < len; i++) {
            int curr = edges.get(i);
            if (visited[curr] == 0) {
                sum += weightMap.get(vertex).get(curr);
                dfs(curr);
            }
        }
    }
    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        visited = new int[A];
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
            visited[i] = 0;
        }
        createGraph(A, B);
        int ans = -1;
        dfs(0);
        System.out.println(min);
        return ans;
    }
}
