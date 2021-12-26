import java.util.ArrayList;

public class DistanceOfNearestCell {
    public static void main(String args[]) {
        int[][] a = { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 } };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                int curr = a[i][j];
                innerArr.add(curr);
            }
            A.add(innerArr);
        }
        System.out.println(solve(A));
    }

    public static Boolean[][] visited;
    public static Queue q;

    // , int i, int j
    public static void BFS(ArrayList<ArrayList<Integer>> A, int rows, int cols) {
        // int[] iAdj = { i - 1, i, i + 1, i };
        // int[] jAdj = { j, j + 1, j, j - 1 };

        while (!q.isEmpty()) {
            int[] top = q.dequeue();
            int i = top[1];
            int j = top[2];
            visited[i][j] = true;
            // int val = top[0];
            int val = A.get(i).get(j);
            int[] iAdj = { i - 1, i, i + 1, i };
            int[] jAdj = { j, j + 1, j, j - 1 };

            for (int pos = 0; pos < iAdj.length; pos++) {
                int _i = iAdj[pos];
                int _j = jAdj[pos];
                if (getIsSafe(_i, _j, rows, cols) && !visited[_i][_j] && A.get(_i).get(_j) == 0) {
                    // visited[_i][_j] = true;
                    // int dist = Math.abs(i - _i) + Math.abs(j - _j);
                    // int prevDist = A.get(i).get(j);
                    q.enqueue(new int[] { val + 1, _i, _j });
                    A.get(_i).set(_j, val + 1);
                }
            }
        }
    }

    public static boolean getIsSafe(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        visited = new Boolean[rows][cols];

        q = new Queue(rows * cols);
        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int curr = A.get(i).get(j);
                    if (curr == 1) {
                        visited[i][j] = true;
                        A.get(i).set(j, 0);
                        q.enqueue(new int[] { 0, i, j });
                    } else {
                        visited[i][j] = false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("e: " + e.toString());
        }
        BFS(A, rows, cols);
        return A;
    }

    static class Queue {
        int length = 0, size = 0, rear = -1, front = 0;
        int[][] q;

        Queue(int n) {
            length = n;
            q = new int[n][3];
        }

        public void enqueue(int[] n) {
            if (isFull()) {
                System.exit(1);
                System.out.println("Ill op[E]");
            }
            rear = (rear + 1) % length;
            q[rear] = n;
            size++;
        }

        public int[] dequeue() {
            if (isEmpty()) {
                System.exit(1);
                System.out.println("Ill op[D]");
            }
            int[] temp = q[front];
            front = (front + 1) % length;
            size--;
            return temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return length == size;
        }
    }
}
