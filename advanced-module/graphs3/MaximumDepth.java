import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MaximumDepth {
    public static void main(String[] args) {
        // int A = 5;
        // int[] B = { 1, 4, 3, 1 };
        // int[] C = { 5, 2, 4, 4 };
        // int[] D = { 7, 38, 27, 37, 1 };
        // int[] E = { 1, 1, 2 };
        // int[] F = { 32, 18, 26 };
        int A = 3;
        int[] B = { 1, 2 };
        int[] C = { 3,1};
        int[] D = { 7, 15, 27 };
        int[] E = { 1, 10, 1 };
        int[] F = { 29, 6, 26 };
        System.out.println(solve(A, B, C, D, E, F));
    }

    public static int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < C.length; i++) {
            int edge = B[i] - 1;
            int vertex = C[i] - 1;
            adjList.get(edge).add(vertex);
            adjList.get(vertex).add(edge);
        }
        int[] visited = new int[A];
        HashMap<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
        Queue q = new Queue(A);
        q.enqueue(new Pair(0, 0, D[0]));
        ArrayList<Integer> x = new ArrayList<>();
        x.add(D[0]);
        levelMap.put(0, x);

        int maxDepth = 0;
        while (!q.isEmpty()) {
            Pair front = q.dequeue();
            visited[front.node] = 1;
            ArrayList<Integer> list = new ArrayList<>();
            // if (front == null) {
            // continue;
            // }
            for (int i = 0; i < adjList.get(front.node).size(); i++) {
                int currNode = adjList.get(front.node).get(i);
                if (visited[currNode] == 0) {
                    if (levelMap.containsKey(front.level + 1)) {
                        list = levelMap.get(front.level + 1);
                    }
                    list.add(D[currNode]);
                    levelMap.put(front.level + 1, list);
                    q.enqueue(new Pair(front.level + 1, currNode, D[currNode]));
                    maxDepth = front.level + 1;
                }
                Collections.sort(list);
            }
        }
        int[] result = new int[E.length];
        for (int i = 0; i < E.length; i++) {
            int level = E[i] % (maxDepth + 1);
            ArrayList<Integer> list = levelMap.get(level);
            int ans = -1;
            if (list != null) {
                ans = binarySearch(list, F[i]);
            }
            result[i] = ans;
        }
        return result;
    }

    public static int binarySearch(ArrayList<Integer> arr, int element) {
        int ans = -1;
        for (int i = 0; i < arr.size(); i++) {
            int curr = arr.get(i);
            if (curr == element) {
                return curr;
            }
            if (curr > element) {
                return curr;
            }
        }
        return ans;
        // int left = 0;
        // int right = arr.size() - 1;
        // int mid = (left + right) / 2;
        // while(left < right) {
        // if (right - left == 1 && arr.get(right) > element && arr.get(left) < element)
        // {
        // return arr.get(right);
        // }
        // if (arr.get(mid) < element) {
        // left = mid;
        // mid = (left + right) / 2;
        // } else if (arr.get(mid) > element) {
        // right = mid;
        // mid = (left + right) / 2;
        // } else {
        // return element;
        // }
        // }
        // return -1;
    }

    static class Pair {
        int level;
        int node;
        int val;

        Pair(int level, int node, int val) {
            this.level = level;
            this.node = node;
            this.val = val;
        }
    }

    static class Queue {
        int front = 0;
        int rear = -1;
        int size = 0;
        int len = 0;
        Pair[] q;

        Queue(int n) {
            this.len = n;
            q = new Pair[n];
        }

        public void enqueue(Pair n) {
            if (isFull()) {
                System.out.println("err[d]");
                System.exit(1);
            }
            rear = (rear + 1) % len;
            q[rear] = n;
            this.size++;
        }

        public Pair dequeue() {
            if (isEmpty()) {
                System.out.println("err[d]");
                System.exit(1);
            }
            Pair temp = q[front];
            front = (front + 1) % len;
            this.size--;
            return temp;
        }

        public boolean isFull() {
            return this.len == this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }
    }
}
