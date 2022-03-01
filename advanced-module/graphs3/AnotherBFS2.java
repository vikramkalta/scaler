import java.util.ArrayList;

public class AnotherBFS2 {
    public static void main(String args[]) {
        int[][] arr = { { 2, 5, 1 }, { 1, 3, 1 }, { 0, 5, 2 }, { 0, 2, 2 }, { 1, 4, 1 }, { 0, 1, 1 } };
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                innerList.add(arr[i][j]);
            }
            B.add(innerList);
        }      
        System.out.println(solve(6, B, 3, 2));
    }
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void createGraph(int A, ArrayList<ArrayList<Integer>> B) {
        int len = B.size();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> innerList = B.get(i);
            int vertex = innerList.get(0);
            int edge = innerList.get(1);
            int weight = innerList.get(2);
            graph.get(vertex).add(edge);
            graph.get(edge).add(vertex);                      
        }
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        int[] distance = new int[A];
        boolean[] sptSet = new boolean[A];
        // visited = new int[A];
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        distance[C] = 0;
        
        for (int i = 0; i < A; i++) {
            // Pick the minimum distance vertex from the set of vertices
            // not processed yet. u is always equal to src in first iteration
            int u = minDistance(distance, sptSet);
            // Mark the picked vertex as processed.
            sptSet[u] = true;
            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph.get(u).get(v) != 0 && distance[u] != Integer.MAX_VALUE) {
                    distance[v] = distance[u] + graph.get(u).get(v);
                }
            } 
        }
        return distance[D];
    }

    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V = 9;
    public static int minDistance(int dist[], boolean[] sptSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
