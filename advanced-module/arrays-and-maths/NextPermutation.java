import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
    public static void main(String args[]) {
        // int[] arr ={1,2,3};
        // int[] arr = { 1, 4, 3, 2, 1 };
        int[] arr = {251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991};
        // 1,2,6,8,2
        // 1,2,8,6,2
        // 1,2,8,2,6
        // {856, 701, 319, 695, 52}; -- original problem;
        // {856, 701, 695, 319, 52};
        // {856, 701, 695, 52, 319};
        // {856, 701, 695, 319, 52}; -- my solution;
        // int[] arr = { 444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838,
        // 890, 758, 675, 424, 199, 201, 788,
        // 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515,
        // 488, 846, 321, 908, 469, 84,
        // 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312,
        // 499, 274, 213, 208, 472, 265,
        // 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351,
        // 241, 526, 311, 164, 98, 422,
        // 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(nextPerm(A));
    }

    // 1,2,4,5
    public static ArrayList<Integer> nextPerm(ArrayList<Integer> A) {
        int len = A.size();
        int prev = A.get(len - 1);
        int permIndex = -1;
        // 319, 695, 52
        // 695, 319, 52
        for (int i = len - 2; i >= 0; i--) {
            int curr = A.get(i);
            if (prev > curr) {
                permIndex = i;
                break;
            }
            prev = curr;
        }
        if (permIndex == -1) {
            int mid = len / 2;
            for (int i = 0; i < mid; i++) {
                int curr = A.get(i);
                int rev = A.get(len - 1 - i);
                A.set(i, rev);
                A.set(len - 1 - i, curr);
            }
        } else {
            boolean isSorted = true;
            for (int i = permIndex + 1; i < len - 1; i++) {
                int curr = A.get(i);
                int next = A.get(i + 1);
                if (curr > next) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                int mid = (len - permIndex) / 2;
                mid = permIndex + mid;
                int iter = 0;
                for (int i = permIndex; i < mid; i++) {
                    int curr = A.get(i);
                    int revIndex = (mid - iter);
                    iter++;
                    int rev = A.get(revIndex);
                    A.set(i, rev);
                    A.set(revIndex, curr);
                }
            } else {
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                int pivot = A.get(permIndex);
                for (int i = permIndex + 1; i < len; i++) {
                    int curr = A.get(i);
                    if (min >= curr && curr >= pivot) {
                        min = curr;
                        minIndex = i;
                    }
                }
                A.set(permIndex, min);
                A.set(minIndex, pivot);
                ArrayList<Integer> x = new ArrayList<>();
                for (int i = permIndex + 1; i < len; i++) {
                    x.add(A.get(i));
                }
                Collections.sort(x);
                int iter = 0;
                for (int i = permIndex + 1; i < len; i++) {
                    A.set(i, x.get(iter));
                    iter++;
                }
            }
        }
        return A;
    }
}
// 1,4,3,2,1
// 1,1,2,3,4
// 1,3,2,1
// 1,1,2,3
// 1,4,3,2 -> 1
// 2,1,3,4
// 2,3,1 -> 2
// 3,1,2
// 2,1,3 -> 3
// 2,3,1
// 2,1,3,4 -> 4
// 2,1,4,3