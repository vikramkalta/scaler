import java.util.ArrayList;

public class KPlacesApart {
    public static void main(String args[]) {
        // int[] a = { 1, 40, 2, 3 };
        int[] a = {25, 16, 11, 31, 28, 20, 3, 8};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        // System.out.println(solve(A, 2));
        System.out.println(solve(A, 6));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int len = A.size();

        for (int i = B / 2; i >= 0; i--) {
            minHeapify(A, i, B+1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (ans.size() != len) {
            minHeapify(A, 0, Math.min(B+1, A.size() - 1));
            int min = extractMin(A, Math.min(B+1, A.size() - 1));
            ans.add(min);
        }
        return ans;
    }

    public static void minHeapify(ArrayList<Integer> A, int root, int high) {
        int smallest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < high && A.get(leftChild) < A.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild < high && A.get(rightChild) < A.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest != root) {
            int temp = A.get(smallest);
            A.set(smallest, A.get(root));
            A.set(root, temp);
            minHeapify(A, smallest, high);
        }
    }

    public static int extractMin(ArrayList<Integer> A, int high) {
        int min = A.get(0);
        A.set(0, A.get(high));
        A.remove(high);
        minHeapify(A, 0, high);
        return min;
    }
}