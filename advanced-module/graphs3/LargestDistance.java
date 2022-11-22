import java.util.ArrayList;

public class LargestDistance {
    public static void main(String[] args) {
        int[] A = { -1, 0, 0 };
        // int[] A = { -1, 0 };
        System.out.println(solve(A));
    }

    static int result = Integer.MAX_VALUE;

    public static int solve(int[] A) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            graph.add(new ArrayList<>());
        }
        int root = -1;
        for (int i = 0; i< len; i++) {
            int vertex = A[i];
            int edge = i;
            if (vertex != -1) {
                graph.get(vertex).add(edge);
                graph.get(edge).add(vertex);
            } else {
                root = i;
            }
        }
        int[] visited = new int[len];
        Queue q = new Queue(len);
        q.enqueue(new Pair(root, 0));
        int deepestNode = bfs(graph, q, visited, root, len);
        visited = new int[len];
        q = new Queue(len);
        q.enqueue(new Pair(deepestNode, 0));
        bfs(graph, q, visited, deepestNode, len);
        return result;
    }

    public static int bfs(ArrayList<ArrayList<Integer>> graph, Queue q, int[] visited, int node, int level) {
        int max = Integer.MIN_VALUE;
        int deepestEdge = -1;
        while(!q.isEmpty()) {
            Pair front = q.dequeue();
            visited[front.node] = 1;
            for (int i = 0; i < graph.get(front.node).size(); i++) {
                int currEdge = graph.get(front.node).get(i);
                if (visited[currEdge] == 0) {
                    q.enqueue(new Pair(currEdge, front.level + 1));
                    if (max < front.level + 1) {
                        max = front.level + 1;
                        deepestEdge = front.node;
                    }
                }
            }
        }
        result = max;
        return deepestEdge;
    }

    static class Pair {
        int node;
        int level;
        Pair(int node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static class Queue {
        int rear = -1;
        int front = 0;
        int len = 0;
        int size = 0;
        Pair[] q;
        Queue(int n) {
            q = new Pair[n];
            len = n;
        }
        public void enqueue(Pair n) {
            if (isFull()) {
                System.out.println("err[e]");
                System.exit(1);
            }
            rear = (rear + 1) % len;
            q[rear] = n;
            size++;
        }
        public Pair dequeue() {
            if (isEmpty()) {
                System.out.println("err[d]");
                System.exit(1);
            }
            Pair temp = q[front];
            front = (front + 1) % len;
            size--;
            return temp;
        }
        public boolean isFull() {
            return size == len;
        }
        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static int solve2(int[] A) {
        int n = A.length;
        if (n <= 2)
            return n - 1;

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (A[k] == -1 || A[i] == -1) {
                    continue;
                }
                int x = A[A[i]] == k ? Integer.MAX_VALUE : 1;
                if (x < A[i]) {
                    A[i] = x;
                    if (max < x) {
                        max = x;
                    }
                }
            }
        }
        return max;
    }

    public static int solve1(int[] A) {
        int n = A.length;
        if (n <= 2)
            return n - 1;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[i] != -1) {
                matrix[i][A[i]] = 1;
                matrix[A[i]][i] = 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        int x = matrix[i][k] + matrix[k][j];
                        if (x < matrix[i][j]) {
                            matrix[i][j] = x;
                            if (max < x) {
                                max = x;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}