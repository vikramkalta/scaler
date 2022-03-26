import java.util.ArrayList;

public class BSmallestElementInSortedMatrix {
    public static void main(String args[]) {
        int[][] a = { { 5, 9, 11 }, { 9, 11, 13 }, { 10, 12, 15 }, { 13, 14, 16 }, { 16, 20, 21 } };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                innerList.add(a[i][j]);
            }
            A.add(innerList);
        }
        System.out.println(solve(A, 12));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int row = A.size();
        int col = A.get(0).size();
        ArrayList<Integer> minHeap = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int curr = A.get(i).get(j);
                insert(minHeap, curr);
            }
        }
        int i = 0;
        int ans = 0;
        while(i < B) {
            ans = extractMin(minHeap);
            i++;
        }
        return ans;
    }

    public static void minHeapify(ArrayList<Integer> A, int root) {
        int smallest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < A.size() && A.get(leftChild) < A.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild < A.size() && A.get(rightChild) < A.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest != root) {
            int temp = A.get(smallest);
            A.set(smallest, A.get(root));
            A.set(root, temp);
            minHeapify(A, smallest);
        }
    }

    public static void insert(ArrayList<Integer> A, int val) {
        A.add(val);
        int i = A.size() - 1;
        while (i > 0 && A.get((i - 1) / 2) > A.get(i)) {
            int temp = A.get((i - 1) / 2);
            A.set((i - 1) / 2, A.get(i));
            A.set(i, temp);
            i = (i - 1) / 2;
        }
    }
    public static int extractMin(ArrayList<Integer> A) {
        int min = A.get(0);
        A.set(0, A.get(A.size() - 1));
        A.remove(A.size() - 1);
        minHeapify(A, 0);
        return min;
    }
}
