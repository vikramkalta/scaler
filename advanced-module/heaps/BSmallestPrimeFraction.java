import java.util.ArrayList;

public class BSmallestPrimeFraction {
    public static void main(String args[]) {
        int[] a = { 1, 2, 3, 5 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        int B = 6;
        System.out.println(solve(A, B));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        ArrayList<ArrayList<Integer>> primeFractionHeap = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            insert(primeFractionHeap, A.get(i), A.get(len - 1), i,  len - 1);
        }
        int i = 0;
        ArrayList<Integer> top = new ArrayList<>();
        while (i < B - 1) {
            System.out.println(primeFractionHeap);
            top = extractMin(primeFractionHeap);
            int _i = top.get(2);
            int _j = top.get(3) - 1;
            if (_i < _j) {
                insert(primeFractionHeap, A.get(_i), A.get(_j), _i, _j);
            }
            i++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(primeFractionHeap.get(0).get(0));
        result.add(primeFractionHeap.get(0).get(1));
        return result;
    }

    public static ArrayList<Integer> solve1(ArrayList<Integer> A, int B) {
        int len = A.size();
        ArrayList<ArrayList<Integer>> primeFractionList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            for (int j = i + 1; j < len; j++) {
                int currJ = A.get(j);
                // insert(primeFractionList, currI, currJ);
            }
        }
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < B) {
            ans = extractMin(primeFractionList);
            i++;
        }
        return ans;
    }

    public static void minHeapify(ArrayList<ArrayList<Integer>> A, int root) {
        int smallest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < A.size() && (double) (A.get(leftChild).get(0))
                / (double) (A.get(leftChild).get(1)) < (double) (A.get(smallest).get(0))
                        / (double) (A.get(smallest).get(1))) {
            smallest = leftChild;
        }
        if (rightChild < A.size() && (double) (A.get(rightChild).get(0))
                / (double) (A.get(rightChild).get(1)) < (double) (A.get(smallest).get(0))
                        / (double) (A.get(smallest).get(1))) {
            smallest = rightChild;
        }
        if (smallest != root) {
            ArrayList<Integer> temp = A.get(smallest);
            A.set(smallest, A.get(root));
            A.set(root, temp);
            minHeapify(A, smallest);
        }
    }

    public static void insert(ArrayList<ArrayList<Integer>> A, int numerator, int denominator, int _i, int _j) {
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(numerator);
        newList.add(denominator);
        newList.add(_i);
        newList.add(_j);
        A.add(newList);

        int i = A.size() - 1;

        while (i > 0 && (double) (A.get((i - 1) / 2).get(0))
                / (double) (A.get((i - 1) / 2).get(1)) > (double) (A.get(i).get(0)) / (double) (A.get(i).get(1))) {
            ArrayList<Integer> temp = A.get((i - 1) / 2);
            A.set((i - 1) / 2, A.get(i));
            A.set(i, temp);
            i = (i - 1) / 2;
        }
    }

    public static ArrayList<Integer> extractMin(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = A.get(0);
        A.set(0, A.get(A.size() - 1));
        A.remove(A.size() - 1);
        minHeapify(A, 0);
        return ans;
    }
}
