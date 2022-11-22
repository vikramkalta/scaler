import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dijkstra {
    public static void main(String args[]) {
        int A = 5;
        int[][] B = {
            {1,2,2},
            {1,4,1},
            {2,3,4},
            {2,5,5},
            {4,3,3},
            {3,5,1}
        };
        // 1->2,4
        // 2->3,5
        // 4->3
        // 3->5
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            int vertex = B[i][0] - 1;
            int edge = B[i][1] - 1;
            int weight = B[i][2];
            HashMap<Integer, Integer> innerMap = new HashMap<>();
            if (graph.containsKey(vertex)) {
                innerMap = graph.get(vertex);
            }
            innerMap.put(edge, weight);
            graph.put(vertex, innerMap);

            HashMap<Integer, Integer> innerMap2 = new HashMap<>();
            if (graph.containsKey(edge)) {
                innerMap2 = graph.get(edge);
            }
            innerMap2.put(vertex, weight);
            graph.put(edge, innerMap2);
        }
        int[] dist = new int[A];
        for (int i = 0; i < A; i++) dist[i] = Integer.MAX_VALUE;

        int source = 0;
        dist[source] = 0;
        int destination = 4;

        ArrayList<ArrayList<Integer>> minHeap = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        x.add(source);
        x.add(0);
        insert(minHeap, x);

        while(minHeap.size() > 0) {
            ArrayList<Integer> min = getMin(minHeap);
            int vertex = min.get(0);
            for (int currEdge: graph.get(vertex).keySet()) {
                int distance = dist[vertex] + graph.get(vertex).get(currEdge);
                if (distance < dist[currEdge]) {
                    dist[currEdge] = distance;
                    ArrayList<Integer> distSource = new ArrayList<>();
                    distSource.add(currEdge);
                    distSource.add(distance);
                    insert(minHeap, distSource);
                }
            }
        }
        return dist[destination];
    }
    public static void minHeap(ArrayList<ArrayList<Integer>> B, int root) {
        int x = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < B.size() && B.get(root).get(1) > B.get(leftChild).get(1)) {
            root = leftChild;
        }
        if (rightChild < B.size() && B.get(root).get(1) > B.get(rightChild).get(1)) {
            root = rightChild;
        }
        if (x != root) {
            ArrayList<Integer> temp = B.get(root);
            B.set(root, B.get(x));
            B.set(x, temp);
            minHeap(B, root);
        }
    }
    public static void insert(ArrayList<ArrayList<Integer>> B, ArrayList<Integer> C) {
        B.add(C);
        int len = B.size();
        for (int i = len/2-1; i>=0; i--) {
            minHeap(B, i);
        }
    }
    public static ArrayList<Integer> getMin(ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> min = B.get(0);
        ArrayList<Integer> last = B.get(B.size() - 1);
        B.remove(B.size() - 1);
        if (B.size()>0) {
            B.set(0, last);
            for (int i = B.size()/2-1; i>=0; i--) {
                minHeap(B, i);
            }
        }
        return min;
    }
}
