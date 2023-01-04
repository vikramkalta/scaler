import java.util.ArrayList;
import java.util.HashMap;

public class PrimsAlgo {
    public static void main(String[] args) {
        // int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
        //                               { 2, 0, 3, 8, 5 },
        //                               { 0, 3, 0, 0, 7 },
        //                               { 6, 8, 0, 0, 9 },
        //                               { 0, 5, 7, 9, 0 } };
        int vertices = 5;
        int graph[][] = new int[][] { { 0, 1, 2 },
                                      { 0, 3, 6 },
                                      { 1, 0, 2 },
                                      { 1, 2, 3 },
                                      { 1, 3, 8 },
                                      { 1, 4, 5 },
                                      { 2, 1, 3 },
                                      { 2, 4, 7 },
                                      { 3, 0, 6 },
                                      { 3, 1, 8 },
                                      { 3, 4, 9 },
                                      { 4, 1, 5 },
                                      { 4, 2, 7 },
                                      { 4, 3, 9 } };
        System.out.println(solve(graph, vertices));
    }
    public static int solve(int[][] A, int B) {
        int[] visited = new int[B];
        int len = A.length;
        int[][] matrix = new int[B][B];
        ArrayList<Integer> minHeap = new ArrayList<>();
        HashMap<Integer, Integer> minCycleMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int edge = A[i][0];
            int vertex = A[i][1];
            int weight = A[i][2];
            matrix[edge][vertex] = weight;
            matrix[vertex][edge] = weight; 
        }
        insert(minHeap, 0);
        visited[0] = 1;
        minCycleMap.put(0, 0);
        int ans = 0;
        while(minHeap.size() > 0) {
            int min = remove(minHeap);
            visited[min] = 1;
            for (int i = 0; i < B; i++) {
                int weight = matrix[min][i];
                if (weight != 0 && visited[i] == 0) {
                    if (!minCycleMap.containsKey(i)) {
                        minCycleMap.put(i, weight);
                    } else {
                        int x = minCycleMap.get(i);
                        if (x > weight) {
                            minCycleMap.put(i, x);
                        }
                    }
                    insert(minHeap, i);
                }
            }
        }
        for (int key: minCycleMap.keySet()) {
           ans += minCycleMap.get(key);
        }
        return ans;
    }
    public static void minHeap(ArrayList<Integer> A, int root) {
        int x = root;
        int leftChild = root * 2 + 1;
        int rightChild = root * 2 + 2;
        if (leftChild < A.size() && A.get(leftChild) < A.get(root)) {
            root = leftChild;
        }
        if (rightChild < A.size() && A.get(rightChild) < A.get(root)) {
            root = rightChild;
        }
        if (x!=root) {
            int temp = A.get(root);
            A.set(root, A.get(x));
            A.set(x, temp);
            minHeap(A, x);
        }
    }
    public static void insert(ArrayList<Integer> A, int B) {
        A.add(B);
        int parent = (A.size() - 1) / 2;
        int child = A.size() - 1;
        while (parent > 0) {
            if (A.get(parent) > A.get(child)) {
                int x = A.get(parent);
                A.set(parent, A.get(child));
                A.set(child, x);
            }
            child = parent;
            parent = parent / 2;
        }
    }
    public static int remove(ArrayList<Integer> A) {
        int x = A.get(0);
        int last = A.get(A.size() - 1);
        A.set(0, last);
        A.remove(A.size() - 1);
        minHeap(A, 0);
        return x;
    }
}