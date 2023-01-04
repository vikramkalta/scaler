import java.util.ArrayList;

public class MatrixAbsDiff {
    public static void main(String[] args) {
        int A = 3;
        int B = 3;
        int[][] C = { 
            { 1, 5, 6 },
            { 10, 7, 2 },
            { 3, 6, 9 }};
        System.out.println(solve(A, B, C));
    }

    public static int solve(int A, int B, int[][] C) {
        int[] _i = {-1,0,1,0};
        int[] _j = {0,1,0,-1};

        int[][][] parent = new int[A][B][2];
        int[][] mst = new int[A][B];
        ArrayList<int[]> heap = new ArrayList<>();
        heap.add(new int[] {0, 0, 0});

        int totalCost = 0;
        while(heap.size() > 0) {
            int[] min = remove(heap);
            mst[min[1]][min[2]] = 1;
            // B[]
            // totalCost += C[min[1]][min[2]];

            for (int i = 0; i < 4; i++) {
                int __i = min[1] - _i[i];
                int __j = min[2] - _j[i];
                if (checkBoundary(__i, __j, A, B)) {
                    int cost = C[__i][__j];
                    if (mst[__i][__j] == 0) {
                        parent[__i][__j] = new int[] {min[1], min[2]};
                        insert(heap, new int[] {cost, __i, __j});
                    }
                }
            }
        }
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {

            }
        }
        return totalCost;
    }
    public static boolean checkBoundary(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }
    public static void minHeap(ArrayList<int[]> heap, int root) {
        int x = root;
        int leftChild = root * 2 + 1;
        int rightChild = root * 2 + 2;
        if (leftChild < heap.size() && heap.get(root)[0] > heap.get(leftChild)[0]) {
            root = leftChild;
        }
        if (rightChild < heap.size() && heap.get(root)[0] > heap.get(rightChild)[0]) {
            root = rightChild;
        }
        if (x != root) {
            int[] temp = heap.get(x);
            heap.set(x, heap.get(root));
            heap.set(root, temp);
            minHeap(heap, root);
        }
    }
    public static int[] remove(ArrayList<int[]> heap) {
        int[] first = heap.get(0);
        int[] last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);
        minHeap(heap, 0);
        return first;
    }
    public static void insert(ArrayList<int[]> heap, int[] element) {
        heap.add(element);
        int parent = (heap.size() - 1) / 2;
        int curr = heap.size() - 1;
        while(parent > 0) {
            if (heap.get(parent)[0] > heap.get(curr)[0]) {
                int[] temp = heap.get(curr);
                heap.set(curr, heap.get(parent));
                heap.set(parent, temp);
            }
            curr = parent;
            parent = curr / 2;
        }
    }
}