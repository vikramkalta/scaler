import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TopographicalSort {
    public static void main(String args[]) {
        int[][] a = { {6, 3},{6, 1},{5, 1},{5, 2},{3, 4},{4, 2} };
        // int[][] a = { { 1, 2 }, { 2, 3 }, { 3, 1 } };
        // int[][] a = { { 1, 4 }, { 1, 2 }, { 4, 2 }, { 4, 3 }, { 3, 2 }, { 5, 2 }, { 3, 5 }, { 8, 2 }, { 8, 6 }, };
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> innerArrayList = new ArrayList<>();
            innerArrayList.add(a[i][0]);
            innerArrayList.add(a[i][1]);
            B.add(innerArrayList);
        }
        System.out.println(solve(6, B));
        // System.out.println(solve(3, B));
        // System.out.println(solve(8, B));
    }

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static HashMap<Integer, Integer> inDegree = new HashMap<>();

    public static void createGraph(ArrayList<ArrayList<Integer>> B) {
        for (int i = 0, len = B.size(); i < len; i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);
            graph.get(start - 1).add(end);

            if (inDegree.containsKey(end)) {
                inDegree.put(end, inDegree.get(end) + 1);
            } else {
                inDegree.put(end, 1);
            }
        }
    }

    // public static ArrayList<Integer> topologicalSort(ArrayList<Integer> sourceNodes, int A) {
    //     ArrayList<Integer> sortedList = new ArrayList<>();
    //     // PriorityQueue q = new PriorityQueue(A);
    //     // ArrayList<Integer> q = new 

    //     for (int source = 0, sLen = sourceNodes.size(); source < sLen; source++) {
    //         int currNode = sourceNodes.get(source);
    //         q.enqueue(currNode);

    //         while (!q.isEmpty()) {
    //             int front = q.dequeue();
    //             sortedList.add(front);
    //             ArrayList<Integer> adj = graph.get(front - 1);
    //             for (int i = 0, len = adj.size(); i < len; i++) {
    //                 int curr = adj.get(i);
    //                 inDegree.put(curr, inDegree.get(curr) - 1);
    //                 if (inDegree.get(curr) == 0) {
    //                     q.enqueue(curr);
    //                 }
    //             }
    //         }
    //     }
    //     return sortedList;
    // }


    public static ArrayList<Integer> topologicalSort(ArrayList<Integer> sourceNodes, int A) {
        ArrayList<Integer> result = new ArrayList<>();

        while(sourceNodes.size() > 0) {
            int currNode = extractValue(sourceNodes);
            result.add(currNode);
            ArrayList<Integer> adjList = graph.get(currNode - 1);
            for (int i = 0, len = adjList.size(); i < len; i++){
                int currAdj = adjList.get(i);

                if (inDegree.containsKey(currAdj)) {
                    inDegree.put(currAdj, inDegree.get(currAdj) - 1);
                    if (inDegree.get(currAdj) == 0) {
                        insertValue(sourceNodes, currAdj);
                        inDegree.remove(currAdj);
                    }
                }
            }
        }
        return result;
    }

    public static void insertValue(ArrayList<Integer> A, int val) {
        A.add(val);
        int len = A.size();
        for (int i = len / 2 - 1; i >= 0; i--) {
            minHeapify(A, i);
        }
    }
    public static int extractValue(ArrayList<Integer> A) {
        int top = A.get(0);
        int bottom = A.get(A.size() - 1);
        A.set(0, bottom);
        A.remove(A.size()-1);
        int len = A.size();
        for (int i = len / 2 - 1; i >= 0; i--) {
            minHeapify(A, i);
        }
        return top;
    }
    public static void minHeapify(ArrayList<Integer> A, int root) {
        int smallest = root;
        int leftChild = root * 2 + 1;
        int rightChild = root * 2 + 2;
        int bothSmall = 0;
        if (leftChild < A.size() && A.get(leftChild) < A.get(root)) {
            smallest = leftChild;
            bothSmall++;
        }
        if (rightChild < A.size() && A.get(rightChild) < A.get(root)) {
            smallest = rightChild;
            bothSmall++;
        }
        if (bothSmall == 2) {
            smallest = A.get(leftChild) < A.get(rightChild) ? leftChild : rightChild;
        }
        if (smallest!=root) {
            int temp = A.get(root);
            A.set(root, A.get(smallest));
            A.set(smallest, temp);
            minHeapify(A, smallest);
        }
    }

    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }
        createGraph(B);

        ArrayList<Integer> sourceNodes = new ArrayList<>();

        for (int i = 1; i <= A; i++) {
            if (!inDegree.containsKey(i)) {
                sourceNodes.add(i);
            }
        }
        // sort the adjacency lists.
        int sourceNodesLen = sourceNodes.size();
        ArrayList<Integer> result = new ArrayList<>();
        if (sourceNodesLen > 0) {
            // for (int i = 0, len = graph.size(); i < len; i++) {
            //     Collections.sort(graph.get(i));
            // }
            result = topologicalSort(sourceNodes, A);
        } else {
            return new ArrayList<>();
        }
        
        return result;
    }
}
