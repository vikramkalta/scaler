import java.util.ArrayList;

public class ShipCompany {
    public static void main(String args[]) {
        // int[] c = { 2, 1, 1 };
        // int[] c = {2, 2, 2};
        int[] c= {1, 2, 3, 4, 5, 6, 7, 10, 10, 10};
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            C.add(c[i]);
        }
        // System.out.println(solve(4, 3, C));
        System.out.println(solve(40, 10, C));
    }

    public static ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        ArrayList<Integer> originalList = new ArrayList<>();
        for (int i = 0; i < C.size(); i++) {
            originalList.add(C.get(i));
        }

        for (int i = (B - 2) /2; i >= 0; i--) {
            maxHeap(C, i);
        }
        int index = 0;
        int maxProfit = 0;
        while (index < A) {
            int max = extractMax(C);
            maxProfit+= max;
            max--;
            if (max > 0) {
                insertMax(C, max);
            }
            index++;
        }

        for (int i = (B - 2)/ 2; i>=0; i--) {
            minHeap(originalList, i);
        }
        index = 0;
        int minProfit = 0;
        while (index < A) {
            int min = extractMin(originalList);
            minProfit+=min;
            min--;
            if (min>0) {
                insertMin(originalList, min);
            }
            index++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(maxProfit);
        result.add(minProfit);
        return result;
    }

    public static void minHeap(ArrayList<Integer> A, int root) {
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
            minHeap(A, smallest);
        }
    }

    public static void maxHeap(ArrayList<Integer> A, int root) {
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
            maxHeap(A, largest);
        }
    }
    public static void insertMax(ArrayList<Integer> A, int value) {
        A.add(value);
        int i = A.size() - 1;
        while (i > 0 && A.get((i-1) / 2) < A.get(i)) {
            int temp = A.get((i-1)/2);
            A.set((i-1)/2, A.get(i));
            A.set(i, temp);
            i = (i-1) / 2;
        }
    }
    public static int extractMax(ArrayList<Integer> A) {
        int max = A.get(0);
        A.set(0, A.get(A.size() - 1));
        A.remove(A.size()-1);
        maxHeap(A, 0);
        return max;
    }
    public static void insertMin(ArrayList<Integer> A, int value) {
        A.add(value);
        int i = A.size()-1;
        while(i > 0 && A.get((i-1)/2) > A.get(i)) {
            int temp = A.get((i-1)/2);
            A.set((i-1)/2, A.get(i));
            A.set(i, temp);
            i = (i-1)/2;
        }
    }
    public static int extractMin(ArrayList<Integer> A) {
        int min = A.get(0);
        A.set(0, A.get(A.size()-1));
        A.remove(A.size()-1);
        minHeap(A, 0);
        return min;
    }
}