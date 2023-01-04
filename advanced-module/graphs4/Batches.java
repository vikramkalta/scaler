import java.util.ArrayList;

public class Batches {
    public static void main(String args[]) {
        int A = 7;
        int[] B = {1,6,7,2,9,4,5};
        int[][] C = {
            {1, 2},
            {2, 3},
            {5, 6},
            {5, 7}
        };
        int D = 12;
        System.out.println(solve(A, B, C, D));
    }

    public static int solve(int A, int[] B, int[][] C, int D) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int len = C.length;
        int[] visited = new int[A];

       ArrayList<ArrayList<Integer>> islands = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
            islands.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            int edge = C[i][0] - 1;
            int vertex = C[i][1] - 1;
            graph.get(edge).add(vertex);
            graph.get(vertex).add(edge);
        }
        int ans = 0;
        for (int i = 0; i < A; i++) {
            if (visited[i] == 0) {
                dfs(graph, i, visited, islands);
                no++;
            }
        }

        for (int i = 0; i < A; i++) {
            if (islands.get(i).size() > 0) {
                int count = 0;
                for (int j = 0; j < islands.get(i).size(); j++) {
                    int edge = islands.get(i).get(j);
                    count += B[edge];
                }
                if (count >= D) {
                    ans++;
                }
            }
        }

        return ans;
    }
    public static int no = 0;
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int node, int[] visited, ArrayList<ArrayList<Integer>> islands) {
        visited[node] = 1;
        islands.get(no).add(node);
        for (int i = 0; i < graph.get(node).size(); i++) {
            int edge = graph.get(node).get(i);
            if (visited[edge] == 0) {
                dfs(graph, edge, visited, islands);
            }
        }
    }
}
