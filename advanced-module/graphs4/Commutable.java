import java.util.ArrayList;

public class Commutable {
    public static void main(String args[]) {
        int A = 4;
        int[][] B = {
            {1, 2, 1},
            {2, 3, 4},
            {1, 4, 3},
            {4, 3, 2},
            {1, 3, 10},
        };
        // int A = 2;
        // int[][] B = {{1, 2, 5}};
        // int A = 3;
        // int[][] B = {{1, 2, 10},{2, 3, 5},{1, 3, 9}};
        // int A = 4;
        // int[][] B = {{1, 2, 1},{2, 3, 2},{3, 4, 4},{1, 4, 3}};
        System.out.println(solve(A, B));
    }

    public static int solve(int A, int[][] B) {
        merge(0, B.length - 1, B);
        int[] parent = new int[A];
        int[] rank = new int[A];
        for (int i = 0; i < A; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        int cost = 0;
        // int i = 0;
        // while(i < B.length) { 
        // }
        for (int i = 0; i < B.length; i++) {
            int edge = B[i][0] - 1;
            int vertex = B[i][1] - 1;
            int x = find_set(edge, parent);
            int y = find_set(vertex, parent);
            if (x != y) {
                cost += B[i][2];
                if (rank[x] < rank[y]) {
                    int temp = x;
                    x = y;
                    y = temp;
                }
                parent[y] = x;
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }
            }
        }
        return cost;
    }
    public static int find_set(int v, int[] parent) {
        if (v == parent[v]) {
            return v;
        }
        return find_set(parent[v], parent);
    } 
    public static void merge(int start, int end, int[][] B) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid, B);
        merge(mid+1, end, B);
        mergeSort(start, mid, end, B);
    }
    public static void mergeSort(int start, int mid, int end, int[][] B) {
        ArrayList<int[]> leftArr = new ArrayList<>();
        ArrayList<int[]> rightArr = new ArrayList<>();
        for (int i = start; i <= mid; i++) {
            leftArr.add(B[i]);
        }
        for (int i = mid + 1; i <= end; i++) {
            rightArr.add(B[i]);
        }
        int i = 0, j = 0, k = start;
        while(i < leftArr.size() && j < rightArr.size()) {
            if (leftArr.get(i)[2] <= rightArr.get(j)[2]) {
                B[k] = leftArr.get(i);
                i++;
            } else {
                B[k] = rightArr.get(j);
                j++;
            }
            k++;
        }
        while(i < leftArr.size()) {
            B[k] = leftArr.get(i);
            i++;
            k++;
        }
        while(j < rightArr.size()) {
            B[k] = rightArr.get(j);
            j++;
            k++;
        }
    }
}
