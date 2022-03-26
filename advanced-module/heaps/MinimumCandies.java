import java.util.ArrayList;

public class MinimumCandies {
    public static void main(String args[]) {
        int[] a = { 3, 2, 3 };
        // int[] a = {1, 2, 1};
        // int[] a = {705};
        // int[] a = {497, 937, 528, 417, 493, 76, 204, 473, 955, 542, 435, 583, 787, 497, 595, 596, 574, 256, 106, 391, 330, 362, 610, 751};
        // int[] a = {110, 289, 585, 135, 314, 259, 238, 798, 954, 399, 492, 282, 311, 177, 804, 769, 191, 539, 830, 806, 854, 50, 373, 329, 549, 202, 399, 542, 166, 986, 446, 346, 58, 269, 103, 267, 547, 171, 713, 408, 847, 988, 704, 162, 850, 493, 59, 584, 588, 117, 639, 310, 615, 871, 977, 136, 973, 324, 450, 737, 778, 139, 606, 98, 968, 275, 911, 558, 849, 62, 495, 512, 106, 682, 980, 9, 517, 104, 80, 540, 689, 696, 396, 681, 541, 468, 12, 482, 459, 438, 924, 507, 725, 388, 579, 754, 421, 30, 151};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        System.out.println(solve(A, 4));
        // System.out.println(solve(A, 2));
        // System.out.println(solve(A, 895));
        // System.out.println(solve(A, 289));
        // System.out.println(solve(A, 80));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        for (int i = (len - 2) / 2; i >= 0; i--) {
            minHeapify(A, i);
        }
        int min = 0;
        int sum = 0;
        int min2 = 0;
        while (min <= B && min2 <= B && A.size() > 0) {
            min = extractMin(A);
            if (min <= B) {
                int candiesToEat = (int) Math.floor(min / 2);
                sum += candiesToEat;
                if (A.size() > 0) {
                    min2 = extractMin(A);
                    if (min2 <= B) {
                        int updatedCandies = min2 + (min - candiesToEat);
                        insert(A, updatedCandies);
                    }
                    
                }
            }

        }
        return sum;
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
            int temp = A.get((i - 1) / 2);
            A.set((i - 1) / 2, A.get(i));
            A.set(i, temp);
            i = (i - 1) / 2;
        }
    }
}