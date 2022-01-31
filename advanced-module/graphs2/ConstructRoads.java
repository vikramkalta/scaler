import java.util.ArrayList;

public class ConstructRoads {
    public static void main(String args[]) {
        int[][] a = { { 1, 3 }, { 1, 4 }, { 3, 2 }, { 3, 5 } };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> innerArrayList = new ArrayList<>();
            innerArrayList.add(a[i][0]);
            innerArrayList.add(a[i][1]);
            A.add(innerArrayList);
        }
        System.out.println(solve(5, A));
    }

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] visited;

    public static void createGraph(ArrayList<ArrayList<Integer>> B) {
        int edges = B.size();
        for (int i = 0; i < edges; i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);
            graph.get(start - 1).add(end);
            graph.get(end - 1).add(start);
        }
    }

    // Color coding -> 0: red, 1: green;
    public static void bfs(Queue q, int start) {
        q.enqueue(start);
        visited[start] = 0;

        while (!q.isEmpty()) {
            int front = q.dequeue();
            ArrayList<Integer> adj = graph.get(front);
            for (int i = 0, len = adj.size(); i < len; i++) {
                int curr = adj.get(i) - 1; // 1 based indexing for input.
                if (visited[curr] == -1) {
                    visited[curr] = visited[front] == 0 ? 1 : 0;
                    q.enqueue(curr);
                }
            }
        }
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        visited = new int[A];

        long mod = 1000000007l;
        for (int i = 0; i < A; i++) {
            visited[i] = -1;
            graph.add(new ArrayList<>());
        }
        Queue q = new Queue(A);
        createGraph(B);
        bfs(q, 0);
        long totalRed = 0l, totalGreen = 0l;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                totalRed++;
            } else {
                totalGreen++;
            }
        }
        long totalRoads = (totalGreen * totalRed) % mod;
        if (totalRoads < 0) {
            totalRoads += mod;
        }
        long totalRequiredRoads = totalRoads - B.size();
        return (int)totalRequiredRoads;
    }

    static class Queue {
        int length = 0, size = 0, rear = -1, front = 0;
        int[] q;

        Queue(int n) {
            q = new int[n];
            length = n;
        }

        public void enqueue(int x) {
            if (isFull()) {
                System.out.println("Ill op[e]");
                System.exit(1);
            }
            rear = (rear + 1) % length;
            q[rear] = x;
            size++;
        }

        public int dequeue() {
            if (isFull()) {
                System.out.println("Ill op[d]");
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
