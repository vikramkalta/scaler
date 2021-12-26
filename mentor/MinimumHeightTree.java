import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTree {
    public static void main(String args[]) {
    }

    LinkedList<LinkedList<Integer>> adj[];

    public static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    public static HashMap<Integer, Integer> inDegree = new HashMap<>();

    // [[0, 1], [1, 2], [1, 3], [2, 4]]
    public static ArrayList<Integer> solve(int vertices, int[][] edges) {
        // Initialisation
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<Integer>());
            inDegree.put(i, 0);
        }
        // Building the graph.
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child);
            graph.get(child).add(parent); // undirected.
            inDegree.put(child, inDegree.get(child) + 1);
            inDegree.put(parent, inDegree.get(parent) + 1); // undirected.
        }
        // Finding the source node.
        LinkedList<Integer> leaves = new LinkedList<>();
        // for (Map.entry entry : inDegree.entrySet()) {
        // for (Map.entry(Integer, Integer) entry : inDegree.entrySet()) {
        // if (entry.value() == 1) {
        // leaves.enqueue(entry.getKey());
        // }
        // }
        // }
        // Sort
        ArrayList<Integer> minimumHeightTree = new ArrayList<>();
        int totalNodes = vertices;
        while (totalNodes > 2) {
            int leavesSize = leaves.size();
            totalNodes -= leavesSize;
            for (int i = 0; i < leaves.size(); i++) {
                int vertex = leaves.poll();
                ArrayList<Integer> children = graph.get(vertex);
                for (int child = 0; child < children.size(); child++) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 1) {
                        leaves.add(child);
                    }
                }
            }
        }
        minimumHeightTree.addAll(leaves);
        return minimumHeightTree;
    }

    static class Queue {
        int length, size, rear = -1, front = 0;
        int[] q;

        Queue(int n) {
            length = n;
            q = new int[n];
        }

        public void enqueue(int n) {
            if (isFull()) {
                System.out.println("Illegal op[E]");
                System.exit(1);
            }
            rear = (rear + 1) % length;
            q[rear] = n;
            size++;
        }

        public int dequeue() {
            if (isFull()) {
                System.out.println("Illegal op[D]");
                System.exit(1);
            }
            int temp = q[front];
            front = (front + 1) % length;
            size--;
            return temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == length;
        }
    }
}
