import java.util.ArrayList;
import java.util.HashMap;

public class RottenOranges {
    public static void main(String args[]) {
        // HashMap<Integer, HashMap<Integer, Boolean>> map = new HashMap<>();
        // HashMap<Integer, Boolean> innerMap = new HashMap<>();
        // innerMap.put(1, true);
        // map.put(0, innerMap);
        // boolean x = map.get(0).get(1);
        // System.out.println("x: " + x);
        int[][] arr = { { 2, 1, 0 }, { 1, 1, 0 }, { 0, 1, 1 } };
        // int[][] arr = { { 1, 1, 1 }, { 1, 2, 1 }, { 1, 1, 1 } };
        // int[][] arr = {{2,1,0}, {0,1,1}, {1,0,1}};
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                innerArr.add(arr[i][j]);
            }
            A.add(innerArr);
        }
        System.out.println(solve(A));
    }

    public static Boolean[][] visited;

    public static boolean getIsSafe(int i, int j, int rows, int cols) {
        return i < rows && j < cols && i >= 0 && j >= 0;
    }

    public static int BFS(ArrayList<ArrayList<Integer>> A, int rows, int cols, Queue q) {
        int minTime = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] front = q.dequeue();
            int i = front[0], j = front[1], count = front[2];
            int[] adjI = { i - 1, i, i + 1, i };
            int[] adjJ = { j, j + 1, j, j - 1 };

            for (int x = 0; x < adjI.length; x++) {
                int _i = adjI[x];
                int _j = adjJ[x];
                if (getIsSafe(_i, _j, rows, cols)) {
                    int curr = A.get(_i).get(_j);
                    if (curr == 1) {
                        minTime = count + 1;
                        A.get(_i).set(_j, 2);
                        q.enqueue(new int[] { _i, _j, count + 1 });
                    }
                }
            }
        }
        return minTime;
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();

        Queue q = new Queue(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curr = A.get(i).get(j);
                if (curr == 2) {
                    q.enqueue(new int[] { i, j, 0 });
                }
            }
        }
        int ans = BFS(A, rows, cols, q);
        boolean isAllRotten = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curr = A.get(i).get(j);
                if (curr == 1) {
                    isAllRotten = false;
                    break;
                }
            }
            if (!isAllRotten) {
                break;
            }
        }
        return !isAllRotten ? -1 : ans;
    }

    public static class Queue {
        int front = 0, rear = -1, size = 0, length = 0;
        int[][] queue;

        Queue(int n) {
            queue = new int[n][3];
            length = n;
        }

        public void enqueue(int[] n) {
            if (isFull()) {
                System.out.println("Illegal op[enqueue]");
                System.exit(1);
            }
            rear = (rear % length) + 1;
            queue[rear] = n;
            size++;
        }

        public int[] dequeue() {
            if (isEmpty()) {
                System.out.println("Illegal op[dequeue]");
                System.exit(1);
            }
            int[] temp = queue[front];
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

    public static int ans = 0;
    public static HashMap<Integer, HashMap<Integer, Boolean>> map = new HashMap<>();

    public static void DFS(ArrayList<ArrayList<Integer>> A, int i, int j, int rows, int cols) {
        visited[i][j] = true;

        int[] adjI = { i - 1, i, i + 1, i };
        int[] adjJ = { j, j + 1, j, j - 1 };

        boolean isFresh = false;
        for (int index = 0; index < adjI.length; index++) {
            int _i = adjI[index];
            int _j = adjJ[index];
            if (getIsSafe(_i, _j, rows, cols)) {
                int curr = A.get(_i).get(_j);
                if (curr == 1 && !visited[_i][_j]) {
                    isFresh = true;
                    boolean isBlocked = false;
                    A.get(_i).set(_j, 2);
                    DFS(A, _i, _j, rows, cols);
                }
            }
        }
        if (isFresh) {
            ans++;
        }
        // return ans;
    }

    public static void updateMap(int i, int j, int rows, int cols) {
        int[] adjI = { i - 1, i, i + 1, i };
        int[] adjJ = { j, j + 1, j, j - 1 };
        HashMap<Integer, Boolean> innerMap = new HashMap<>();
        for (int x = 0; x < adjI.length; x++) {
            int _i = adjI[x];
            int _j = adjJ[x];
            if (getIsSafe(_i, _j, rows, cols)) {
                innerMap.put(_j, true);
                map.put(_i, innerMap);
            }
        }
    }
}
