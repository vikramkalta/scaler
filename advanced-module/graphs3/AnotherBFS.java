import java.util.ArrayList;
import java.util.HashMap;

public class AnotherBFS {
    public static void main(String args[]) {
        int[][] arr1 = { { 2, 5, 1 }, { 1, 3, 1 }, { 0, 5, 2 }, { 0, 2, 2 }, { 1, 4, 1
        }, { 0, 1, 1 } };
        int[][] arr = {
        { 3, 5, 1 },
        { 7, 8, 1 }, 
        { 2, 5, 1 },
        { 4, 6, 2 },
        { 0, 5, 2 },
        { 3, 8, 1 },
        { 1, 3, 2 },
        { 0, 3, 1 },
        { 0, 6, 2 },
        { 0, 1, 1 },
        { 2, 7, 2 } };
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                innerList.add(arr[i][j]);
            }
            B.add(innerList);
        }
        // System.out.println(solve(6, B, 3, 2));
        System.out.println(solve(9, B, 2, 6));
    }

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static HashMap<Integer, HashMap<Integer, Integer>> weightMap = new HashMap<>();
    public static int[] distance;

    public static void createGraph(int A, ArrayList<ArrayList<Integer>> B) {
        int len = B.size();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> innerList = B.get(i);
            int vertex = innerList.get(0);
            int edge = innerList.get(1);
            int weight = innerList.get(2);
            graph.get(vertex).add(edge);
            graph.get(edge).add(vertex);

            if (weightMap.containsKey(vertex)) {
                HashMap<Integer, Integer> innerMap = weightMap.get(vertex);
                innerMap.put(edge, weight);
                weightMap.put(vertex, innerMap);
            } else {
                HashMap<Integer, Integer> innerMap = new HashMap<>();
                innerMap.put(edge, weight);
                weightMap.put(vertex, innerMap);
            }
            if (weightMap.containsKey(edge)) {
                HashMap<Integer, Integer> innerMap = weightMap.get(edge);
                innerMap.put(vertex, weight);
                weightMap.put(edge, innerMap);
            } else {
                HashMap<Integer, Integer> innerMap = new HashMap<>();
                innerMap.put(vertex, weight);
                weightMap.put(edge, innerMap);
            }
        }
    }

    public static void dijkstra(int C, int D) {
        ArrayList<ArrayList<Integer>> minHeap = new ArrayList<>();
        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(0);
        innerList.add(C);
        minHeap.add(innerList);
        while (minHeap.size() != 0) {
            ArrayList<Integer> smallest = remove(minHeap);
            int currWeight = smallest.get(0);
            int currVertex = smallest.get(1);
            ArrayList<Integer> currEdges = graph.get(currVertex);
            for (int i = 0, len = currEdges.size(); i < len; i++) {
                int currEdge = currEdges.get(i);
                int edgeWeight = weightMap.get(currVertex).get(currEdge);
                int totalWeight = currWeight + edgeWeight;

                if (distance[currEdge] == Integer.MAX_VALUE) {
                    insert(minHeap, currEdge, totalWeight);
                }
                if (distance[currEdge] > totalWeight) {
                    distance[currEdge] = totalWeight;
                }
            }
        }
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        distance = new int[A];
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
            if (C == i) {
                distance[i] = 0;
            } else {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        createGraph(A, B);
        dijkstra(C, D);
        int ans = distance[D] == Integer.MAX_VALUE ? -1 : distance[D];
        return ans;
    }

    public static void minHeapify(ArrayList<ArrayList<Integer>> A, int root) {
        int smallest = root;
        int leftChild = (root * 2) + 1;
        int rightChild = (root * 2) + 2;
        int count = 0;
        if (leftChild < A.size() && A.get(leftChild).get(0) < A.get(root).get(0)) {
            smallest = leftChild;
            count++;
        }
        if (rightChild < A.size() && A.get(rightChild).get(0) < A.get(root).get(0)) {
            smallest = rightChild;
            count++;
        }
        if (count == 2) {
            smallest = A.get(leftChild).get(0) < A.get(rightChild).get(0) ? leftChild : rightChild;
        }
        if (root != smallest) {
            ArrayList<Integer> temp = A.get(root);
            A.set(root, A.get(smallest));
            A.set(smallest, temp);
            minHeapify(A, smallest);
        }
    }

    public static void insert(ArrayList<ArrayList<Integer>> A, int value, int dist) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(dist);
        arr.add(value);
        A.add(arr);
        int len = A.size();
        for (int i = len / 2; i >= 0; i--) {
            minHeapify(A, i);
        }
    }
    public static boolean search(ArrayList<ArrayList<Integer>> A, int value, int dist) {
        if (value == 0) {
            System.out.println();
        }
        for (int i = 0,len = A.size(); i < len; i++) {
            int vertex = A.get(i).get(1);
            if (value == vertex) {
                A.get(i).set(0, Integer.min(dist, A.get(i).get(0)));
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> remove(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> smallest = A.get(0);
        A.set(0, A.get(A.size() - 1));
        A.remove(A.size() - 1);
        int len = A.size();
        for (int i = len / 2; i >= 0; i--) {
            minHeapify(A, i);
        }
        return smallest;
    }

}