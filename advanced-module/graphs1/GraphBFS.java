import java.util.ArrayList;

public class GraphBFS {
    public static void main(String args[]) {
        // int[][] arr = { { 2, 1, 0 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int[][] arr = {{1,2,3}, {0,2}, {0}, {0}};
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                int curr = arr[i][j];
                innerArr.add(curr);
            }
            A.add(innerArr);
        }
        solve(A);
    }

    public static void BFS(ArrayList<ArrayList<Integer>> A, Boolean[] visited, Queue q, int i) {
        q.enqueue(i);
        visited[i] = true;
        while(!q.isEmpty()) {
            int node = q.dequeue();
            for (int start = 0; start < A.get(node).size(); start++) {
                int curr = A.get(node).get(start);
                if (!visited[curr]) {
                    q.enqueue(curr);
                    visited[curr] = true;
                }
            }
        }
    }

    public static void solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();

        Boolean[] visited;
        visited = new Boolean[rows];
        for (int i = 0; i < rows; i++) {
            visited[i] = false;
        }

        Queue q = new Queue(rows);
        q.enqueue(0);
        BFS(A, visited, q, 0);
        System.out.println();
    }

    static public class Queue {
        int length = 0;
        int rear = -1;
        int front = 0;
        int size = 0;
        int[] q;
        Queue(int n) {
            length = n;
            q = new int[n];
        }
        public void enqueue(int n) {
            if (isFull()) {
                System.out.println("Not allowed[enqueue]");
                System.exit(1);
            }
            rear = (rear + 1) % length;
            q[rear] = n;
            size++;
        }
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Not allowed[dequeue]");
                System.exit(1);
            }
            int temp = q[front];
            front = (front + 1) % length;
            size--;
            return temp;
        }
        public boolean isEmpty() {
            return 0 == size;
        }
        public boolean isFull() {
            return length == size;
        }
    }
}