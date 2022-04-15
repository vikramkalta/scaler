import java.util.ArrayList;

public class HeapSort {
    public static void main(String args[]) {
        int[] a = { 12, 6, 10, 5, 1, 9 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int len = A.size();
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
        }
        return A;
    }

    public static void maxHeapify(ArrayList<Integer> A, int root) {
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < A.size() && A.get(leftChild) > A.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < A.size() && A.get(rightChild) > A.get(largest)) {
            largest = rightChild;
        }
        if (largest != root) {
            int temp = A.get(largest);
            A.set(largest, A.get(root));
            A.set(root, temp);
            maxHeapify(A, largest);
        }
    }
}
