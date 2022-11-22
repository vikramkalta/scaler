import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AnotherBFS3 {
    public static void main(String args[]) {
        int A = 6;
        int[][] B = {
            {2, 5,  1},
            {1, 3, 1}, 
            {0, 5, 2}, 
            {0, 2, 2}, 
            {1, 4, 1}, 
            {0, 1, 1},
        };
        System.out.println(solve(A, B, 3, 2));
    }

    public static int solve(int A, int[][] B, int C, int D) {
        int[] dist = new int[A];
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < B.length; i++){
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

        for (int i = 0; i < A; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[C] = 0;
        ArrayList<int[]> minHeap = new ArrayList<>();
        insert(minHeap, new int[] { C, 0 });
        
        Set<Integer> settled = new HashSet<Integer>();
        while( settled.size() != A  ) {
            
            if (minHeap.size() == 0) {
                break;
            }
            
            int[] min = remove(minHeap);
            if (!graph.containsKey(min[0]) || settled.contains(min[0])) {
                continue;
            }

            settled.add(min[0]);

            for (int currEdge: graph.get(min[0]).keySet()) {
                int x = dist[min[0]] + graph.get(min[0]).get(currEdge);
                if (!settled.contains(currEdge) && dist[currEdge] > x) {
                    dist[currEdge] = x;
                    insert(minHeap, new int[] { currEdge, x });
                }
            }
        }
        return dist[D] == Integer.MAX_VALUE ? -1 : dist[D];
    }

    public static void minHeap(ArrayList<int[]> heap, int root) {
        int x = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < heap.size() && heap.get(root)[1] > heap.get(leftChild)[1]) {
            root = leftChild;
        }
        if (rightChild < heap.size() && heap.get(root)[1] > heap.get(rightChild)[1]) {
            root = rightChild;
        }
        if (root!=x) {
            int[] temp = heap.get(root);
            heap.set(root, heap.get(x));
            heap.set(x, temp);
            minHeap(heap, root);
        }
    }
    public static void insert(ArrayList<int[]> heap, int[] x) {
        heap.add(x);
        int curr = heap.size();
        int parent = curr / 2 - 1;
        while (parent > 0 && heap.get(parent)[1] > heap.get(curr - 1)[1]) {
            int[] temp = heap.get(parent);
            heap.set(parent, heap.get(curr - 1));
            heap.set(curr - 1, temp);
            curr = parent;
            parent = curr / 2 - 1;
        }
    }
    public static int[] remove(ArrayList<int[]> heap) {
        int[] x = heap.get(0);
        int len = heap.size();
        int[] last = heap.get(len - 1);
        heap.set(0, last);
        heap.remove(len - 1);
        minHeap(heap, 0);
        return x;
    }
}
