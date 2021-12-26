import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PathInDirectedGraph {
    public static void main(String args[]) {
        int[][] arr = { { 1, 2 }, { 4, 1 }, { 2, 4 }, { 3, 4 }, { 5, 2 }, { 1, 3 } };
        int[][] arr1 = { {1, 2}, {2, 3}, {3, 4}, {4, 5} };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                int curr = arr[i][j];
                innerArr.add(curr);
            }
            A.add(innerArr);
        }
        // System.out.println(solve(5, A));
        System.out.println(solve(5, A));
    }

    private static LinkedList<Integer> adj[];

    // @SuppressWarnings("unchecked")
    // PathInDirectedGraph(int v) {
    //     adj = new LinkedList[v];
    //     for (int i = 0; i < v; i++)
    //         adj[i] = new LinkedList<>();
    // }

    public static void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public static void createGraph(int A, ArrayList<ArrayList<Integer>> B) {
        int len = B.size();
        // PathInDirectedGraph p = new PathInDirectedGraph(A);
        adj = new LinkedList[A];
        for (int i = 0; i < A; i++)
            adj[i] = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            int vertex = B.get(i).get(0);
            int edge = B.get(i).get(1);
            addEdge(vertex - 1, edge);
        }
        System.out.println();
    }

    public static void traverse(int v, Boolean[] visited) {
        visited[v] = true;
        Iterator<Integer> i = adj[v].listIterator();
        // Recur for all the vertices adjacent to this vertex.
        while(i.hasNext()) {
            int n = i.next();
            if (!visited[n - 1]) {
                traverse(n - 1, visited);
            }
        }
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        createGraph(A, B);
        // int len = B.size();
        Boolean[] visited = new Boolean[A];
        for (int i = 0; i < A; i++) {
            visited[i] = false;
        }
        traverse(0, visited);
        return visited[A - 1] ? 1 : 0;
    }
}
