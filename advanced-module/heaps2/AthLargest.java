import java.util.ArrayList;

public class AthLargest {
    public static void main(String args[]) {
        // int[] a = { 1, 2, 3, 4, 5, 6 };
        int[] a = { 11, 9, 7, 5, 8, 1, 10 };
        // int[] a= {15, 20, 99, 1};
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            B.add(a[i]);
        }
        // System.out.println(solve(4, B));
        System.out.println(solve(3, B));
        // System.out.println(solve(2, B));
    }

    public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        int len = B.size();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> minHeap = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int curr = B.get(i);
            if (i < A - 1) {
                ans.add(-1);
                insert(minHeap, curr);
            } else {
                if (minHeap.size() < A) {
                    insert(minHeap, curr);
                    // Insert minimum element which the Ath largest element.
                    ans.add(minHeap.get(0));
                } else {
                    // If curr is less than Ath largest then ignore this element and Ath largest will remain as it is.
                    if (curr < minHeap.get(0)) {
                        ans.add(minHeap.get(0));
                    } else {
                        insert(minHeap, curr);
                        extractMin(minHeap);
                        ans.add(minHeap.get(0));
                    }
                }
            }
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

    public static int extractMin(ArrayList<Integer> A) {
        int min = A.get(0);
        A.set(0, A.get(A.size() - 1));
        A.remove(A.size() - 1);
        minHeapify(A, 0);
        return min;
    }

    public static void insert(ArrayList<Integer> A, int val) {
        A.add(val);
        int i = A.size() - 1;
        while (i > 0 && A.get((i - 1) / 2) > A.get(i)) {
            int temp = A.get(i);
            A.set(i, A.get((i - 1) / 2));
            A.set((i - 1) / 2, temp);
            i = (i - 1) / 2;
        }
    }
}