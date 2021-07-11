import java.util.ArrayList;
import java.util.Collections;

public class Triplets {
    public static void main(String args[]) {
        // int[] arr = { 100, 4, 100, 1, 3, 2, 2 };
        int[] arr = { -3, -1, 1, 2 };
        // int[] arr = { -1, 2, 3, -2, 4, 5 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A, 0));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int start = i + 1, end = len - 1;
            // -3,-1,2=-2 < 0
            // -3,-1,1=-3 < 0
            // -1,1,2=2>0
            while (start < end) {
                int currStart = A.get(start);
                int currEnd = A.get(end);
                int sum = currStart + currEnd + curr;
                int diff = B - sum;
                // int diff = Math.abs(sum-B);
                int x = Math.abs(sum - B);
                if (min > x) {
                    minSum = sum;
                    min = x;
                }
                if (diff == 0) {
                    break;
                } else if (diff > 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return minSum;
    }
}
// public static int solve(int[] arr, int targetSum) {
// if (arr == null || arr.length < 3)
// throw new IllegalArgumentException();

// Arrays.sort(arr);
// int smallestDifference = Integer.MAX_VALUE;
// for (int i = 0; i < arr.length - 2; i++) {
// int left = i + 1, right = arr.length - 1;
// while (left < right) {

// int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
// if (targetDiff == 0) // we've found a triplet with an exact sum
// return targetSum - targetDiff; // return sum of all the numbers

// if (Math.abs(targetDiff) < Math.abs(smallestDifference)
// || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff >
// smallestDifference))
// smallestDifference = targetDiff;

// if (targetDiff > 0)
// left++;
// else
// right--;
// }
// }
// return targetSum - smallestDifference;
// }