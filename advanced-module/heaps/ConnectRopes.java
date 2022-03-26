import java.util.ArrayList;

public class ConnectRopes {
    public static void main(String args[]) {
        // int[] arr = {9,2,7,4,6,1};
        // int[] arr = {5, 17, 100, 11};
        // int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {106, 17, 58, 35, 163, 52, 92, 171, 115, 73, 79, 130, 121, 95, 18, 5, 128, 180, 181, 196};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        int startIndex = A.size() / 2 - 1;
        for (int i = startIndex; i >= 0; i--) {
            minHeapify(A, i);
        }
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int startIndex = len / 2 - 1;
        // Min heapify
        for (int i = startIndex; i >= 0; i--) {
            minHeapify(A, i);
        }

        int sum = 0;
        while(A.size() > 0) {
            int min1 = remove(A);
            int min2 = remove(A);
            int connected = min1 + min2;
            sum += connected;
            if (A.size() == 0) {
                break;
            }
            add(A, connected);
        }
        return sum;
    }

    public static void minHeapify(ArrayList<Integer> A, int root) {
        int smallest = root;
        int leftChildIndex = 2 * root + 1;
        int rightChildIndex = 2 * root + 2; 
        int rootEl = A.get(root);
        
        if (leftChildIndex < A.size() && rootEl > A.get(leftChildIndex)) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < A.size() && A.get(smallest) > A.get(rightChildIndex)) {
            smallest = rightChildIndex;
        }
        if (smallest != root) {
            int temp = A.get(smallest);
            A.set(smallest, A.get(root));
            A.set(root, temp);
            minHeapify(A, smallest);
        }
    }
    public static int remove(ArrayList<Integer> A) {
        int len = A.size();
        int min = A.get(0);
        A.set(0, A.get(len - 1));
        A.remove(len - 1);
        if (A.size() == 0) {
            return min;
        }
        minHeapify(A, 0);
        return min;
    }
    public static void add(ArrayList<Integer> A, int B) {
        A.add(B);
        int len = A.size();
        int i = len - 1;
        while(i > 0 && A.get((i - 1) / 2) > B) {
            int temp = A.get(i);
            int parentIndex = (i - 1) / 2;
            A.set(i, A.get(parentIndex));
            A.set(parentIndex, temp);
            i = parentIndex;
        }
    }
}