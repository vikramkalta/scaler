import java.util.ArrayList;

public class MaxNonNegativeSubarray {
    public static void main(String args[]) {
        // int[]arr={10, -1, 2, 3, -4, 100};
        // int[] arr = {10,-1,5,5};
        // int[] arr = {2,2,1,-1,1,2,2};
        int[] arr = {1967513926, 1540383426, -1303455736, -521595368};
        // int[] arr = {1, 2, 5, -7, 2, 3};
        // int[] arr = {2, 5, 6, 8, 6, 1, 2, 4, 5};
        // int[] arr = {9, 9, 9, 9, 9};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(maxNonNegativeSubarray(A));
    }

    public static ArrayList<Integer> maxNonNegativeSubarray(ArrayList<Integer> A) {
        int len = A.size();

        // ArrayList<Long> prefix = new ArrayList<>();
        long max = Long.MIN_VALUE;
        int maxIndex = -1;
        long sum = 0;
        int lenOfMaxSubarray = Integer.MIN_VALUE;
        int lenCounter = 0;

        for (int i = 0; i < len; i++) {
            long curr = A.get(i);
            if (curr < 0) {
                sum = -1;
                lenCounter = 0;
            } else {
                if (sum == -1) {
                    sum = 0;
                }
                lenCounter++;
                sum = (sum + curr);
            }
            if (max == sum && lenOfMaxSubarray < lenCounter) {
                maxIndex = i;
                if (lenOfMaxSubarray < lenCounter) {
                    lenOfMaxSubarray = lenCounter;
                }
            }
            if (max < sum) {
                max = sum;
                maxIndex = i;
                if (lenOfMaxSubarray < lenCounter) {
                    lenOfMaxSubarray = lenCounter;
                }
            }
            // prefix.add(sum);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i--) {
            int curr = A.get(i);
            if (curr < 0) {
                break;
            }
            result.add(curr);
        }
        int resultLen = result.size();
        int mid = resultLen / 2;
        for (int i = 0; i < mid; i++) {
            int curr = result.get(i);
            int rev = result.get(resultLen - i - 1);
            result.set(i, rev);
            result.set(resultLen - i - 1, curr);
        }
        return result;
    }
}