import java.util.ArrayList;

public class MinSwaps {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 4, 0 };
        // {0,1,2,3,4}
        // {7, 6, 5, 4, 3};
        // {3, 4, 5, 6, 7}
        // {-1, -1, -1, 0, 1, 2, 3, 4};
        // {-1, -1, -1, 3, 4, 5, 6, 7};
        int[] arr = { 6, 50, 16, 30, 37, 12, 43, 52, 24, 2, 53, 28, 31, 36, 10, 32, 51, 60, 64, 38, 3, 46, 7, 4, 55, 72,
                75, 66, 73, 68, 54, 22, 25, 65, 5, 49, 0, 8, 47, 78, 35, 57, 83, 90, 27, 9, 19, 26, 76, 41, 39, 40, 1,
                11, 67, 61, 71, 56, 58, 108, 110, 102, 15, 70, 59, 14, 42, 23, 29, 20, 118, 13, 106, 17, 69, 18, 21, 34,
                44, 62, 33, 80, 45, 87, 48, 63, 74, 131, 134, 111, 77, 79, 81, 139, 132, 124, 82, 84, 85, 86, 88, 89,
                91, 92, 93, 130, 94, 98, 95, 96, 151, 97, 99, 100, 109, 101, 142, 103, 143, 104, 105, 146, 107, 112,
                113, 138, 114, 115, 116, 117, 160, 119, 120, 148, 145, 121, 122, 123, 125, 126, 127, 135, 128, 153, 129,
                133, 144, 136, 137, 140, 141, 147, 149, 150, 152, 154, 155, 156, 157, 158, 159 };

        // int[] arr = { 2, 0, 1, 3 };
        // {0,1,2,3}
        // int[] arr = { 3, 2, 1, 4, 5, 6, 9, 8, 7, 10 };
        // Arrays.sort(arr);
        // System.out.println(arr);
        // int[] arr = { 927, 707, 374, 394, 279, 799, 878, 937, 431, 112 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(A);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (max < curr) {
                max = curr;
            }
        }
        ArrayList<Boolean> count = new ArrayList<>();
        // ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            count.add(false);
            // count.add(0);
        }
        for (int i = 0; i < len; i++) {
            // count.set(A.get(i), true);
            count.set(A.get(i), true);
        }
        // System.out.println(count);
        ArrayList<Integer> sortedCount = new ArrayList<>();
        int tracker = 0;
        for (int i = 0; i <= max; i++) {
            boolean b = count.get(i);
            if (b) {
                sortedCount.add(tracker);
                tracker++;
            } else {
                sortedCount.add(-1);
            }
        }
        count.clear();
        // System.out.println(sortedCount);
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int countPos = sortedCount.get(curr);
            if (i != countPos) {
                int temp = A.get(countPos);
                A.set(countPos, curr);
                A.set(i, temp);
                ans++;
                i--;
            }
        }
        return ans;
    }

    public static int solve1(ArrayList<Integer> A) {
        int len = A.size();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i; j < len; j++) {
                int currJ = A.get(j);
                if (min > currJ) {
                    min = currJ;
                    index = j;
                }
            }
            if (i != index) {
                ans++;
            }
            int temp = A.get(i);
            A.set(i, A.get(index));
            A.set(index, temp);
        }
        return ans;
    }
}
