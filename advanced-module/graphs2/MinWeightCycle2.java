import java.util.ArrayList;
import java.util.HashMap;

public class MinWeightCycle2 {
    public static void main(String args[]) {
        // int A = 6;
        // int[][] B =
        // {
        // {1, 2, 3},
        // {1, 3, 3},
        // {2, 3, 3},
        // {4, 5, 4},
        // {4, 6, 3},
        // {5, 6, 1},
        // };
        int A = 4;
        int[][] B = {
                { 1, 2, 2 },
                { 2, 3, 3 },
                { 3, 4, 1 },
                { 4, 1, 4 },
                { 1, 3, 15 },
        };
        // {0,2,5,6};
        System.out.println(solve(A, B));
    }

    public static int solve(int A, int[][] B) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        // ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        // for (int i = 0; i < A; i++) {
        // graph.add(new ArrayList<>());
        // }

        for (int i = 0; i < B.length; i++) {
            int vertex = B[i][0] - 1;
            int edge = B[i][1] - 1;
            int weight = B[i][2];
            // int[] inner = new int[] { edge, weight };
            // int[] inner2 = new int[] { vertex, weight };
            // graph.get(vertex).set(edge, inner);
            // graph.get(edge).set(vertex, inner2);
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

        ArrayList<int[]> minHeap = new ArrayList<>();

        // Action
        int minWeight = Integer.MAX_VALUE;
        for (int i = 0; i < A; i++) {
            int[] x = new int[] { i, 0 };
            insert(minHeap, x);
            int[] dist = new int[A];
            for (int j = 0; j < A; j++) {
                dist[j] = Integer.MAX_VALUE;
            }
            dist[i] = 0;

            if (!graph.containsKey(i)) {
                continue;
            }

            // for (int[] edge: graph.get(i)) {
            //     int weightOfRemovedEdge = edge[1];
            //     // for (int k = 0; k < )
            // }

            for (int edge : graph.get(i).keySet()) {
                int weightOfRemovedEdge = graph.get(i).get(edge);
                // Removed edge
                graph.get(i).remove(edge);
                graph.get(edge).remove(i);
                // Get distance
                while (minHeap.size() > 0) {
                    int[] min = min(minHeap);
                    if (!graph.containsKey(min[0])) {
                        continue;
                    }
                    for (int currNeighbour : graph.get(min[0]).keySet()) {
                        // if ((currNeighbour == edge && min[0] == i) || (currNeighbour == i && min[0] == edge)) {
                        //     continue;
                        // }
                        int currWeight = graph.get(min[0]).get(currNeighbour);
                        int distance = dist[min[0]] + currWeight;
                        if (distance < dist[currNeighbour]) {
                            dist[currNeighbour] = distance;
                            insert(minHeap, new int[] { currNeighbour, distance });
                        }
                    }
                }

                if (dist[edge] != Integer.MAX_VALUE) {
                    int weight = dist[edge] + weightOfRemovedEdge;
                    if (minWeight > weight) {
                        minWeight = weight;
                    }
                }
                // Add back edges
                graph.get(i).put(edge, weightOfRemovedEdge);
                graph.get(edge).put(i, weightOfRemovedEdge);
                break;
            }
        }
        return minWeight == Integer.MAX_VALUE ? -1 : minWeight;
    }

    public static void minHeap(ArrayList<int[]> minHeap, int root) {
        int x = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < minHeap.size() && minHeap.get(leftChild)[1] < minHeap.get(root)[1]) {
            root = leftChild;
        }
        if (rightChild < minHeap.size() && minHeap.get(rightChild)[1] < minHeap.get(root)[1]) {
            root = rightChild;
        }
        if (root != x) {
            int[] temp = minHeap.get(root);
            minHeap.set(root, minHeap.get(x));
            minHeap.set(x, temp);
            minHeap(minHeap, x);
        }
    }

    public static void insert(ArrayList<int[]> minHeap, int[] element) {
        minHeap.add(element);
        for (int i = minHeap.size() / 2 - 1; i >= 0; i--) {
            minHeap(minHeap, i);
        }
    }

    public static int[] min(ArrayList<int[]> minHeap) {
        int[] temp = minHeap.get(0);
        int[] last = minHeap.get(minHeap.size() - 1);
        minHeap.remove(minHeap.size() - 1);
        if (minHeap.size() > 0) {
            minHeap.set(0, last);
            for (int i = minHeap.size() / 2 - 1; i >= 0; i--) {
                minHeap(minHeap, i);
            }
        }

        return temp;
    }
}
