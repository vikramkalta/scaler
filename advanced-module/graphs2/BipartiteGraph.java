import java.util.ArrayList;

public class BipartiteGraph {
    public static void main(String args[]) {
        // int[][] a = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        // int[][] a = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 } };
        // int[][] a = { { 2, 5 }, { 6, 7 }, { 4, 8 }, { 2, 3 }, { 0, 3 }, { 4, 7 }, { 1, 8 }, { 3, 8 }, { 1, 3 } };
        // int[][] a={{8, 7},{8, 4},{4, 0},{7, 6},{8, 1},{7, 5},{1, 2},{5, 3}};
        int[][] a = {{1, 7},{0, 5},{6, 7},{0, 6}};
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> innerArrayList = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                innerArrayList.add(a[i][j]);
            }
            B.add(innerArrayList);
        }
        // System.out.println(solve(3, B));
        // System.out.println(solve(5, B));
        // System.out.println(solve(9, B));
        System.out.println(solve(9, B));
    }

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] visited;

    public static void createGraph(int A, ArrayList<ArrayList<Integer>> B) {
        int len = B.size();
        for (int i = 0; i < len; i++) {
            int fromVertex = B.get(i).get(0);
            int toVertex = B.get(i).get(1);
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }
    }

    // Color mapping -> 0: RED, 1: GREEN; 
    public static boolean bfs(ArrayList<ArrayList<Integer>> graph, Queue q, int start) {
        q.enqueue(new Pair(start, 0));

        while (!q.isEmpty()) {
            Pair front = q.dequeue();
            visited[front.num] = front.level;
            ArrayList<Integer> adj = graph.get(front.num);
            for (int i = 0, len = adj.size(); i < len; i++) {
                int curr = adj.get(i);
                if (visited[curr] == -1) {
                    int color = front.level == 0 ? 1 : 0;
                    q.enqueue(new Pair(curr, color));
                } else {
                    if (visited[curr] == visited[front.num]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        visited = new int[A];
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
            visited[i] = -1;
        }
        createGraph(A, B);
        Queue q = new Queue(A);
        boolean ans = true;
        for (int i = 0; i < A; i++) {
            if (visited[i] == -1) {
                ans = bfs(graph, q, i);
            }
            if (!ans) {
                break;
            }
        }
        return ans ? 1 : 0;
    }

    static class Queue {
        int length = 0, size = 0, rear = -1, front = 0;
        Pair[] q;

        Queue(int n) {
            q = new Pair[n];
            length = n;
        }

        public void enqueue(Pair x) {
            if (isFull()) {
                System.out.println("Ill op[e]");
                System.exit(1);
            }
            rear = (rear + 1) % length;
            q[rear] = x;
            size++;
        }

        public Pair dequeue() {
            if (isFull()) {
                System.out.println("Ill op[d]");
                System.exit(1);
            }
            Pair temp = q[front];
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

    static class Pair {
        int num;
        int level;

        Pair(int a, int b) {
            this.num = a;
            this.level = b;
        }
    }
}
