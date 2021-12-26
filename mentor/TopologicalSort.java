import java.util.ArrayList;
import java.util.HashMap;

public class TopologicalSort {
    // public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static int[] visited;
    public static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String args[]) {
        int[][] a = { {2, 3}, { 3, 4 }, { 4, 5 }, {}, {} };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                int curr = a[i][j];
                innerArr.add(curr);
            }
            A.add(innerArr);
        }
        System.out.println(topoSort(A));
    }

    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        ArrayList<Integer> topoSortedArr = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                int curr = A.get(i).get(j);
                if (hm.containsKey(curr)) {
                    hm.put(curr, hm.get(curr) + 1);
                } else {
                    hm.put(curr, 1);
                }
            }
        }

        Queue q = new Queue(rows);
        q.enqueue(1);
        while (!q.isEmpty()) {
            int front = q.dequeue();
            topoSortedArr.add(front);
            ArrayList<Integer> adj = A.get(front - 1);
            for (int i = 0; i < adj.size(); i++) {
                int curr = adj.get(i);
                hm.put(curr, hm.get(curr) - 1);
                if (hm.get(curr) == 0) {
                    // topoSortedArr.add(curr);
                    q.enqueue(curr);
                }
            }
        }
        return topoSortedArr;
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

// LinkedList<LinkedList<Integer>> adj[];
// public static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
// public static HashMap<Integer, Integer> inDegree = new HashMap<>();
// public static void solve(int vertices, ArrayList<ArrayList<Integer>> edges) {
// public static ArrayList<Integer> solve(int vertices, int[][] edges) {
// // Initialisation
// for (int i = 0; i < vertices; i++) {
// graph.put(i, new ArrayList<Integer>());
// inDegree.put(i, 0);
// }
// // Building the graph.
// for (int i = 0; i < edges.length; i++) {
// int parent = edges[i][0];
// int child = edges[i][1];
// graph.get(parent).add(child);
// graph.get(child).add(parent); // undirected.
// inDegree.put(child, inDegree.get(child) + 1);
// inDegree.put(parent, inDegree.get(parent) + 1); // undirected.
// }
// // Finding the source node.
// Queue<Integer> source = new LinkedList<>();
// for (Map.entry(Integer, Integer) entry : inDegree.entrySet()) {
// if (entry.value() == 0) {
// source.enqueue(entry.getKey());
// }
// }
// // Sort
// ArrayList<Integer> sortedOrder = new ArrayList<>();
// while(!source.empty()) {
// int vertex = source.dequeue();
// sortedOrder.add(vertex);
// ArrayList<Integer> children = graph.get(vertex);
// for (int child = 0; child < children.size(); child++) {
// inDegree.put(child, inDegree.get(child) - 1);
// if (inDegree.get(child) == 0) {
// source.enqueue(child);
// }
// }
// }
// if (sortedOrder.size() != vertices) {
// return new ArrayList<>();
// }
// return sortedOrder;
// }
// ALIEN DICTIONARY
// b -> a,c
// a -> c
// c -> null
// ///////////////////////////////////////////////////
// unordered_map<char, int> inDegree;
// unordered_map<char, vector<char>> graph;
// for (auto word : words) {
// for (char character : word) {
// inDegree[character] = 0;
// graph[character] = vector<char>();
// }
// }
// for (int i = 0; i < words.size() - 1; i++) {
// string w1 = words[i], w2 = words[i + 1];
// for (int j = 0; j < min(w1.length(), w2.length()); j++) {
// char parent = w1[j], child = w2[j];
// if (parent != child) {
// graph[parent].push_back(child);
// inDegree[child]++;
// break;
// }
// }
// }
// queue<char> sources;
// for (auto entry : inDegree) {
// if (entry.second == 0) {
// sources.push(entry.first);
// }
// }
// string sortedOrder;
// while (!sources.empty()) {
// char vertex = sources.front();
// sources.pop();
// sortedOrder += vertex;
// vector<char> children =
// graph[vertex];
