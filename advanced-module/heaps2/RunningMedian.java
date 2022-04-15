import java.util.ArrayList;

public class RunningMedian {
    public static void main(String args[]) {
        int[] a = { 1, 2, 5, 4, 3 };
        // int[] a = { 5, 17, 100, 11 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int len = A.size();
        // for (int i = (len - 2) / 2; i >= 0; i--) {
        //     maxHeapify(A, i, len);
        // }
        // for (int i = len - 1; i >= 0; i--) {
        //     extractMax(A, i);
        // }
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            B.add(curr);
            for (int j = (B.size() - 2) / 2; j >= 0; j--) {
                maxHeapify(B, j, B.size());
            }
            for (int j = B.size() - 1; j >= 0; j--) {
                extractMax(B, j);
            }

            int i1 = i + 1;
            if (i1 % 2 != 0) {
                ans.add(B.get(i1 / 2));
            } else {
                ans.add(B.get(i1 / 2 - 1));
            }
        }
        return ans;
    }

    // public static void minHeapify(ArrayList<Integer> A, int root, int startIndex) {
    //     int smallest = root;
    //     int leftChild = 2 * root + 1;
    //     int rightChild = 2 * root + 2;
    //     if (leftChild < A.size() && A.get(startIndex + leftChild) < A.get(smallest)) {
    //         smallest = leftChild;
    //     }
    //     if (rightChild < A.size() && A.get(startIndex + rightChild) < A.get(smallest)) {
    //         smallest = rightChild;
    //     }
    //     if (smallest != root) {
    //         int temp = A.get(startIndex);
    //     }
    // }

    public static void maxHeapify(ArrayList<Integer> A, int root, int len) {
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < len && A.get(leftChild) > A.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < len && A.get(rightChild) > A.get(largest)) {
            largest = rightChild;
        }
        if (largest != root) {
            int temp = A.get(largest);
            A.set(largest, A.get(root));
            A.set(root, temp);
            maxHeapify(A, largest, len);
        }
    }

    public static int extractMax(ArrayList<Integer> A, int len) {
        int max = A.get(0);
        A.set(0, A.get(len));
        A.set(len, max);
        maxHeapify(A, 0, len);
        return max;
    }
}