import java.util.ArrayList;

public class AdjacencyMatrix {
    public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String args[]) {
        // int[][] arr = { { 0, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        int[][] arr = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 }, { 1, 0, 0, 0 } };
        // {{0,1,1,1},
        //  {1,0,0,0},
        //  {1,0,0,0},
        //  {1,0,0,0}}
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                int curr = arr[i][j];
                innerArr.add(curr);
            }
            adj.add(innerArr);
        }
        Boolean[] visited = new Boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            visited[i] = false;
        }
        dfs(0, visited);
    }

    public static void dfs(int start, Boolean[] visited) {
        System.out.println("Start: " + start);
        // Set current node as visited.
        visited[start] = true;
        // For every node of the graph
        int len = adj.get(start).size();
        for (int i = 0; i < len; i++) {
            // If some node is adjacent to the current node
            // and it has not already been visited
            int curr = adj.get(start).get(i);
            if (curr == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }
}