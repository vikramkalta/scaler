import java.util.ArrayList;

public class ConnectRopes {
    public static void main(String args[]) {
        // int[] a = { 1, 2, 3, 4, 5 };
        // int[] a = {2,10,9,5,6,1};
        // int[] a = {5, 17, 100, 11};
        int[] a = { 16, 7, 3, 5, 9, 8, 6, 15 };
        // int[] a = { 5,4,3,2,1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        // Get the root node and check 2nd smallest number from left and right child.
        // Then take out root node.
        // Repeat
        int totalCost = 0;
        int startIndex = 0;
        while (len > 2) {
            for (int i = len / 2 - 1; i >= startIndex; i--) {
                minHeapify(A, i);
            }
            int min = A.get(0);
            int secondMinIndex = -1;
            if (A.get(1) < A.get(2)) {
                secondMinIndex = 1;
            } else {
                secondMinIndex = 2;
            }
            int secondMin = A.get(secondMinIndex);
            int cost = min + secondMin;
            totalCost += cost;
            // Swap cost and secondMin
            A.set(secondMinIndex, cost);
            A.remove(0);
            len--;
        }
        totalCost = totalCost + A.get(0) + A.get(1);
        return totalCost;
    }

    public static void maxHeapify(ArrayList<Integer> A, int i) {
        int len = A.size();
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;
        if (leftChild < len && A.get(leftChild) > A.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < len && A.get(rightChild) > A.get(largest)) {
            largest = rightChild;
        }
        if (largest != i) {
            int temp = A.get(largest);
            A.set(largest, A.get(i));
            A.set(i, temp);
            maxHeapify(A, largest);
        }
    }

    public static void minHeapify(ArrayList<Integer> A, int i) {
        int len = A.size();
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int smallest = i;
        if (leftChild < len && A.get(leftChild) < A.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild < len && A.get(rightChild) < A.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest != i) {
            int temp = A.get(smallest);
            A.set(smallest, A.get(i));
            A.set(i, temp);
            minHeapify(A, smallest);
        }
    }

    public static void merge(ArrayList<Integer> A, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        merge(A, l, mid);
        merge(A, mid + 1, r);
        mergeSort(A, l, mid, r);
    }

    public static void mergeSort(ArrayList<Integer> A, int l, int mid, int r) {
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        for (int i = l; i <= mid; i++) {
            leftList.add(A.get(i));
        }
        for (int i = mid + 1; i <= r; i++) {
            rightList.add(A.get(i));
        }
        int leftLen = leftList.size(), rightLen = rightList.size();
        int left = 0, right = 0, k = l;
        while (left < leftLen && right < rightLen) {
            int x = leftList.get(left);
            int y = rightList.get(right);
            if (x < y) {
                A.set(k, x);
                left++;
            } else {
                A.set(k, y);
                right++;
            }
            k++;
        }

        while (left < leftLen) {
            A.set(k, A.get(left));
            k++;
            left++;
        }
        while (right < rightLen) {
            A.set(k, A.get(right));
            k++;
            right++;
        }
    }
}