import java.util.ArrayList;

public class PoisonousGraph {
    public static void main(String[] args) {
        int[][] arr = {{1,2}};
        // int[][] arr1 = {{1, 2},{1, 3},{1, 4},{2, 3},{2, 4},{3, 4}};
        // int[][] arr = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        // int[][] arr = { { 9, 8 }, { 9, 5 }, { 5, 1 }, { 8, 7 }, { 9, 2 }, { 8, 6 }, { 2, 3 }, { 6, 4 } };
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                innerList.add(arr[i][j]);
            }
            B.add(innerList);
        }
        // System.out.println(solve(2, B));
        long mod = 998244353l;
        System.out.println(binomialExp(3l, 13l, mod));
    }

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] visited;

    public static void createGraph(int A, ArrayList<ArrayList<Integer>> B) {
        int len = B.size();
        for (int i = 0; i < len; i++) {
            int vertex = B.get(i).get(0);
            int neighbor = B.get(i).get(1);
            graph.get(vertex - 1).add(neighbor - 1);
            graph.get(neighbor - 1).add(vertex - 1);
        }
    }

    // NOTE: 1 for red, 2 for green. 0 for unvisited.
    public static boolean bipartiteGraph(int A, int index) {
        Queue q = new Queue(A);
        q.enqueue(index);
        visited[index] = 1;
        while (!q.isEmpty()) {
            int front = q.dequeue();
            ArrayList<Integer> adj = graph.get(front);
            for (int i = 0, len = adj.size(); i < len; i++) {
                int curr = adj.get(i);
                if (visited[curr] != 0 && visited[curr] == visited[front]) {
                    // Graph is not bipartite.
                    return false;
                }
                if (visited[curr] == 0) {
                    q.enqueue(curr);
                    visited[curr] = visited[front] == 1 ? 2 : 1;
                }
            }
        }
        return true;
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        if (A == 1) {
            return 3;
        }
        visited = new int[A];
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
            visited[i] = 0;
        }
        createGraph(A, B);
        boolean bipartite = true;
        for (int i = 0; i < A; i++) {
            if (visited[i] == 0) {
                bipartite = bipartiteGraph(A, i);
                if (!bipartite) {
                    return 0;
                }
            }
        }
        
        long countOf1 = 0l, countOf2 = 0l;
        for (int i = 0; i < A; i++) {
            if (visited[i] == 1) {
                countOf1++;
            } else {
                countOf2++;
            }
        }
        long mod = 998244353l;
        long countPoisonous1 = binomialExp(2l, countOf1, mod);
        long countPoisonous2 = binomialExp(2l, countOf2, mod);

        long ans = (countPoisonous1 + countPoisonous2) % mod;
        if (ans < 0) {
            ans += mod;
        }
        return (int)ans;
    }

    public static long binomialExp(long a, long b, long mod) {
        if (b == 0l) {
            return 1;
        }
        long res = binomialExp(a, b / 2, mod);
        if (b % 2 == 0) {
            res = (res * res) % mod;
            // if (res < 0) {res+=mod;}
        } else {
            res = (res * res * a) % mod;
            // if (res < 0) {res+=mod;}
        }
        if (res < 0) {
            res+=mod;
        }
        return res;
    }

    static class Queue {
        int size = 0, length = 0, rear = -1, front = 0;
        int[] q;

        Queue(int n) {
            q = new int[n];
            length = n;
        }

        public void enqueue(int n) {
            if (isFull()) {
                System.out.println("Error ---> [enqueue]");
                System.exit(1);
            }
            rear = (rear + 1) % length;
            q[rear] = n;
            size++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Error ---> [dequeue]");
                System.exit(1);
            }
            int temp = q[front];
            front = (front + 1) % length;
            size--;
            return temp;
        }

        public boolean isFull() {
            return size == length;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
