import java.util.ArrayList;

public class MinPriorityQueue {
    public static void main(String args[]) {
        int[] arr = {8,7,4,3,1};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        minHeapify(A, 0);
        insertValue(A, 9);
        insertValue(A, 11);
        insertValue(A, 13);
        while(A.size() > 1) {
            int x = extractMinimum(A);
            System.out.println(x);
        }
        System.out.println(A.get(0));
    }

    public static void minHeapify(ArrayList<Integer> A, int root) {
        int smallest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        int bothSmall = 0;
        if (leftChild < A.size() && A.get(leftChild) < A.get(root)) {
            smallest = leftChild;
            bothSmall++;
        }
        if (rightChild < A.size() && A.get(rightChild) < A.get(root)) {
            smallest = rightChild;
            bothSmall++;
        }
        if (bothSmall == 2) {
            smallest = A.get(leftChild) < A.get(rightChild) ? leftChild : rightChild;
        }
        if (smallest != root) {
            int temp = A.get(smallest);
            A.set(smallest, A.get(root));
            A.set(root, temp);
            minHeapify(A, smallest);
        }
    }

    public static int extractMinimum(ArrayList<Integer> A) {
        int top = A.get(0);
        int bottom = A.get(A.size() - 1);
        A.remove(A.size() - 1);
        A.set(0, bottom);
        int len = A.size();
        for (int i = len / 2 - 1; i >= 0; i--) {
            minHeapify(A, i);
        }
        return top;
    }

    public static void insertValue(ArrayList<Integer> A, int val) {
        A.add(val);
        int len = A.size();
        for (int i = len / 2 - 1; i >= 0; i--) {
            minHeapify(A, i);
        }
    }
}
