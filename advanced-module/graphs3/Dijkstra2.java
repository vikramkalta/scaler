import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra2 {
    public static void main(String args[]) {
        int A = 6;
        int[][] B = {
            {0, 4, 9},
            {3, 4, 6}, 
            {1, 2, 1}, 
            {2, 5, 1}, 
            {2, 4, 5}, 
            {0, 3, 7}, 
            {0, 1, 1}, 
            {4, 5, 7}, 
            {0, 5, 1},
        };
        int C = 4;
        System.out.println(solve(A,B,C));
    }
    public static int[] solve(int A, int[][] B, int C) {
        HashMap<Integer, HashMap<Integer,Integer>> graph = new HashMap<>();
        int[] dist = new int[A];
        for (int i = 0; i < A; i ++) {
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0 ; i < B.length; i++) {
            int vertex = B[i][0];
            int edge = B[i][1];
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

        dist[C] = 0;
        ArrayList<int[]> minHeap = new ArrayList<>();
        insert(minHeap, new int[] {C, 0});
        while(minHeap.size() > 0) {
            int[] min = min(minHeap);
            if (!graph.containsKey(min[0])) {
                continue;
            }

            for (int currEdge: graph.get(min[0]).keySet()) {
                int weight = graph.get(min[0]).get(currEdge);
                if (dist[currEdge] > weight + dist[min[0]]) {
                    dist[currEdge] = weight + dist[min[0]];
                    insert(minHeap, new int[]{ currEdge, weight + dist[min[0]] });
                }
            }
        }
        for (int i = 0; i < A; i++) {
            dist[i] = dist[i] == Integer.MAX_VALUE ? -1 : dist[i];
        }
        return dist;
    }
    public static void minHeap(ArrayList<int[]> A, int root) {
        int smallest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < A.size() && A.get(leftChild)[1] < A.get(smallest)[1]) {
            smallest = leftChild;
        }
        if (rightChild < A.size() && A.get(rightChild)[1] < A.get(smallest)[1]) {
            smallest = rightChild;
        }
        if (smallest!=root) {
            int[] temp = A.get(smallest);
            A.set(smallest, A.get(root));
            A.set(root, temp);
            minHeap(A, smallest);
        }
    }
    public static int[] min(ArrayList<int[]> A) {
        int[] min = A.get(0);
        int[] last = A.get(A.size()-1);
        A.set(0, last);
        A.remove(A.size() - 1);
        minHeap(A, 0);
        return min;
    }
    public static void insert(ArrayList<int[]> A, int[] B) {
        A.add(B);
        int curr = A.size() - 1;
        int parent = A.size() / 2 - 1;
        while (parent >= 0 && A.get(curr)[1] < A.get(parent)[1]) {
            int[] temp = A.get(curr);
            A.set(curr, A.get(parent));
            A.set(parent, temp);
            curr = parent;
            parent = curr / 2 - 1;
        }
    }
}