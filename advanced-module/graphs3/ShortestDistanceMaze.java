import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestDistanceMaze {
    public static void main(String args[]) {
        // int[][] A = {{0,0},{0,0}};
        // int[] B = {0,0};
        // int[] C = {0,1};
        // int[][] A = {
        // {1, 1, 0, 1},
        // {0, 0, 0, 1},
        // {1, 0, 0, 1},
        // {0, 0, 1, 0},
        // };
        // int[] B = {1, 1};
        // int[] C = {2, 1};
        int[][] A = {
                { 0, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
        };
        int[] B = { 7, 5 };
        int[] C = { 8, 3 };
        System.out.println(solve(A, B, C));
    }

    static int maxn = 100009;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    public static boolean inside(int x, int y, int n, int m) {
        return (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1);
    }
    public static int solve(int[][] A, int[] B, int[] C) {
        return findMinDist(A, B, C);
    }
    public static int findMinDist(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int sx = start[0];
        int sy = start[1];
        int ex = destination[0];
        int ey = destination[1];
        int[][] v = new int[n][m];
        for (int[] row: v)
            Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue < Pair > pq = new PriorityQueue < Pair > (new CustomComp());
        int i;
        int d, d1;
        int x, y;
        int x1, y1;
        int x2, y2;
        pq.offer(new Pair(0, sx, sy));
        while (pq.size() != 0 && v[ex][ey] == Integer.MAX_VALUE) {
            Pair temp = pq.poll();
            x = temp.b;
            y = temp.c;
            d = temp.a;
            if (v[x][y] != Integer.MAX_VALUE) {
                continue;
            } else {
                v[x][y] = d;
            }
            for (i = 0; i < 4; ++i) {
                x1 = x;
                y1 = y;
                d1 = 0;
                while (true) {
                    x2 = x1 + dx[i];
                    y2 = y1 + dy[i];
                    if (inside(x2, y2, n, m) == true && maze[x2][y2] == 0) {
                        x1 = x2;
                        y1 = y2;
                        ++d1;
                    } else {
                        break;
                    }
                }
                if (d1 > 0 && v[x1][y1] == Integer.MAX_VALUE) {
                    pq.offer(new Pair(d + d1, x1, y1));
                }
            }
        }
        int res = -1;
        if (v[ex][ey] != Integer.MAX_VALUE)
            res = v[ex][ey];
        return res;
    }

    static class Pair {
        int a, b, c;
        public Pair(int u, int v, int w) {
            this.a = u;
            this.b = v;
            this.c = w;
        }
    }
    static class CustomComp implements Comparator < Pair > {
        @Override
        public int compare(Pair aa, Pair bb) {
            return aa.a - bb.a;
        }
    }

    // public static int solve(int[][] A, int[] B, int[] C) {
    //     int rows = A.length;
    //     int cols = A[0].length;
    //     int[][] dist = new int[rows][cols];
    //     for (int i = 0; i < rows; i++) {
    //         for (int j = 0; j < cols; j++) {
    //             dist[i][j] = Integer.MAX_VALUE;
    //         }
    //     }
    //     ArrayList<int[]> minHeap = new ArrayList<>();
    //     // insert(minHeap, new int[] {B[0], B[1], 0});
    //     insert(minHeap, new int[] { C[0], C[1], 0 });
    //     dist[C[0]][C[1]] = 0;
    //     int[] indexIs = { -1, 0, 1, 0 };
    //     int[] indexJs = { 0, 1, 0, -1 };
    //     int[] opIs = { 1, 0, -1, 0 };
    //     int[] opJs = { 0, -1, 0, 1 };

    //     int start = 1;

    //     while (minHeap.size() > 0) {
    //         int[] min = getMin(minHeap);
    //         if (start == 1) {
    //             for (int i = 0; i < 4; i++) {
    //                 int x = min[0] + indexIs[i];
    //                 int y = min[1] + indexJs[i];
    //                 int x1 = min[0] + opIs[i];
    //                 int y1 = min[1] + opJs[i];
    //                 // int temp = dist[min[0]][min[1]] + 1;
    //                 if (
    //                     (
    //                         getBoundary(x, y, rows, cols) && A[x][y] == 1
    //                         ||
    //                         !getBoundary(x, y, rows, cols)
    //                     )

    //                         && getBoundary(x1, y1, rows, cols) && A[x1][y1] == 0) {
    //                     dist[x1][y1] = 1;
    //                     insert(minHeap, new int[] { x1, y1, 1 });
    //                 }
    //             }
    //             start = 0;
    //         } else {
    //             for (int i = 0; i < 4; i++) {
    //                 int x = min[0] + indexIs[i];
    //                 int y = min[1] + indexJs[i];
    //                 int temp = dist[min[0]][min[1]] + 1;
    //                 if (getBoundary(x, y, rows, cols) && A[x][y] == 0 && dist[x][y] > temp) {
    //                     dist[x][y] = temp;
    //                     insert(minHeap, new int[] { x, y, temp });
    //                 }
    //             }
    //         }
    //     }
    //     return dist[B[0]][B[1]] == Integer.MAX_VALUE ? -1 : dist[B[0]][B[1]];
    // }

    // public static boolean getBoundary(int i, int j, int rows, int cols) {
    //     return i >= 0 && j >= 0 && i < rows && j < cols;
    // }

    // public static void minHeap(ArrayList<int[]> A, int root) {
    //     int smallest = root;
    //     int leftChild = 2 * root + 1;
    //     int rightChild = 2 * root + 2;
    //     if (leftChild < A.size() && A.get(leftChild)[2] < A.get(smallest)[2]) {
    //         smallest = leftChild;
    //     }
    //     if (rightChild < A.size() && A.get(rightChild)[2] < A.get(smallest)[2]) {
    //         smallest = rightChild;
    //     }
    //     if (smallest != root) {
    //         int[] temp = A.get(smallest);
    //         A.set(smallest, A.get(root));
    //         A.set(root, temp);
    //         minHeap(A, smallest);
    //     }
    // }

    // public static void insert(ArrayList<int[]> A, int[] x) {
    //     A.add(x);
    //     int curr = A.size() - 1;
    //     int parent = A.size() / 2 - 1;
    //     while (parent >= 0 && A.get(parent)[2] > A.get(curr)[2]) {
    //         int[] temp = A.get(parent);
    //         A.set(parent, A.get(curr));
    //         A.set(curr, temp);
    //         curr = parent;
    //         parent = parent / 2 - 1;
    //     }
    // }

    // public static int[] getMin(ArrayList<int[]> A) {
    //     int[] min = A.get(0);
    //     int[] last = A.get(A.size() - 1);
    //     A.set(0, last);
    //     A.remove(A.size() - 1);
    //     minHeap(A, 0);
    //     return min;
    // }
}