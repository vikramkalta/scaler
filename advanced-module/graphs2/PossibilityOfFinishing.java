import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PossibilityOfFinishing {
    public static void main(String args[]) {
        // int[] b = {1,2};
        // int[] c = {2,3};
        // int[] b = {1,2};
        // int[] c = {2,1};
        // int[] b = { 1, 2, 3 };
        // int[] c = { 2, 3, 1 };
        // int[] b = { 1, 3, 4, 5 };
        // int[] c = { 2, 1, 5, 3 };
        // int[] b = { 67, 8, 48, 42, 35, 25, 37, 69, 31, 36, 7, 33, 2, 47, 42, 52, 31,
        // 70, 29, 38, 36, 60, 15, 37, 33, 27,
        // 4, 32, 43, 55, 49, 35, 21, 28, 62, 17, 2, 61, 54, 22, 9, 56, 12, 3, 60, 52,
        // 21, 15, 54, 63, 33, 64, 38,
        // 16, 59, 69, 49, 52, 10, 10, 6, 56, 43, 32, 41, 66, 6 };
        // int[] c = { 51, 43, 55, 27, 34, 8, 14, 5, 70, 64, 65, 57, 45, 19, 53, 50, 44,
        // 51, 19, 41, 14, 68, 12, 58, 50,
        // 66, 7, 47, 40, 62, 29, 5, 22, 39, 23, 34, 25, 4, 40, 26, 26, 45, 18, 28, 61,
        // 59, 17, 46, 39, 46, 68, 24,
        // 63, 59, 67, 53, 9, 11, 3, 44, 24, 37, 13, 1, 65, 18, 48 };
        int[]b={11, 5, 13, 12, 5, 11, 4, 16, 7, 18, 12, 6, 6, 9, 10, 15, 2, 3, 4, 5,
        6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11,
        12, 13, 14, 15, 16, 17, 18, 1, 2, 4, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17,
        18, 1};
        int[]c={17, 18, 14, 9, 3, 8, 10, 14, 15, 1, 3, 17, 4, 8, 7, 13, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
        2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4};
        // int[] b = { 1, 2, 3, 4, 5, 8 };
        // int[] c = { 2, 3, 4, 5, 6, 7 };
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            B.add(b[i]);
        }
        for (int i = 0; i < c.length; i++) {
            C.add(c[i]);
        }
        // System.out.println(solve(3, B, C));
        // System.out.println(solve(2, B, C));
        // System.out.println(solve(3, B, C));
        // System.out.println(solve(5, B, C));
        // System.out.println(solve(34, B, C));
        // System.out.println(solve(70, B, C));
        System.out.println(solve(18, B, C));
        // System.out.println(solve(8, B, C));
    }

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] visited;
    private static HashMap<Integer, Integer> inDegree = new HashMap<>();

    public static void createGraph(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int len = B.size();
        for (int i = 0; i < len; i++) {
            int vertex = B.get(i) - 1;
            int edge = C.get(i) - 1;
            graph.get(vertex).add(edge);
            if (inDegree.containsKey(edge)) {
                inDegree.put(edge, inDegree.get(edge) + 1);
            } else {
                inDegree.put(edge, 1);
            }
        }
    }

    // 0->unvisited,1->red,2->green
    public static boolean bipartite(int A, int index, Queue q) {
        visited[index] = 1; // RED COLOR
        while (!q.isEmpty()) {
            int front = q.dequeue();
            ArrayList<Integer> edges = graph.get(front);
            for (int i = 0, len = edges.size(); i < len; i++) {
                int curr = edges.get(i);
                if (visited[curr] == 0) {
                    visited[curr] = visited[front] == 1 ? 2 : 1;
                    q.enqueue(curr);
                }
                if (visited[curr] != 0 && visited[front] == visited[curr]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int count = 0;

    public static void topologicalSort(int A, Queue q) {
        while (!q.isEmpty()) {
            int front = q.dequeue();
            List<Integer> edges = graph.get(front);
            for (int index = 0, len = edges.size(); index < len; index++) {
                int curr = edges.get(index);
                inDegree.put(curr, inDegree.get(curr) - 1);
                if (inDegree.get(curr) == 0) {
                    visited[front] = 1;
                    q.enqueue(curr);
                    count++;
                }
            }
        }
    }

    public static int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        visited = new int[A];
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
            visited[i] = 0;
        }
        createGraph(A, B, C);

        Queue q = new Queue(A);
        for (int i = 0; i < A; i++) {
            if (!inDegree.containsKey(i)) {
                visited[i] = 1;
                count++;
                q.enqueue(i);
            }
        }
        if (q.isEmpty()) {
            return 0;
        }
        topologicalSort(A, q);
        if (count != A) {
            return 0;
        }
        return 1;
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
                System.out.println("ill op[e]");
                System.exit(1);
            }
            rear = (rear + 1) % length;
            size++;
            q[rear] = n;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("ill op[d]");
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
