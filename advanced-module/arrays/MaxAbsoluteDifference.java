import java.util.ArrayList;

public class MaxAbsoluteDifference {
    public static void main(String args[]) {
        int[] arr = { 1, 3, -1 };
        // int[] arr = { 3, -1, 6, 8 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(maxAbsDiff(A));
    }

    public static int maxAbsDiff(ArrayList<Integer> A) {
        int len = A.size();

        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int sum = curr + i;
            if (max1 < sum) {
                max1 = sum;
            }
            if (min1 > sum) {
                min1 = sum;
            }
        }
        int ans1 = getAbsDiff(max1, min1);

        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int sum = curr - i;
            if (max2 < sum) {
                max2 = sum;
            }
            if (min2 > sum) {
                min2 = sum;
            }
        }
        int ans2 = getAbsDiff(max2, min2);
        int ans = ans1 > ans2 ? ans1 : ans2;
        return ans;
        
    }

    public static int maxAbsDiff1(ArrayList<Integer> A) {
        int len = A.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            for (int j = i + 1; j < len; j++) {
                int diffIndex = j - i;
                int diffAbs = getAbsDiff(currI, A.get(j));
                int sum = diffIndex + diffAbs;
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int getAbsDiff(int A, int B) {
        int diff = 0;
        if (A >= 0 && B >= 0) {
            diff = A - B;
            return diff < 0 ? -diff : diff;
        } else if (A >= 0 && B < 0) {
            diff = A - B;
            return diff;
        } else if (A < 0 && B >= 0) {
            diff = B - A;
            return diff;
        } else {
            // both negative
            if (A > B) {
                diff = A - B;
            } else if (B > A) {
                diff = B - A;
            } else {
                diff = 0;
            }
        }
        return diff;
    }
}
