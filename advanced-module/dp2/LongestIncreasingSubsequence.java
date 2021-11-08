import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        // int[] a = { 1, 2, 1, 5 };
        int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        // int[]a ={1, 3, 5};
        // int[]a={1};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        ArrayList<Integer> dp = new ArrayList<>();
        
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                int currJ = A.get(j);
                if (currI > currJ) {
                    int maxLength = dp.get(j);
                    if (max < maxLength) {
                        max = maxLength;
                    }
                }
            }
            if (max == Integer.MIN_VALUE) {
                max = 1;
            } else {
                max++;
            }
            if (ans < max) {
                ans = max;
            }
            dp.add(max);
        }
        return ans == Integer.MIN_VALUE ? 1 : ans;
    }

    public static int solve1(ArrayList<Integer> A) {
        int len = A.size();
        ArrayList<ArrayList<Integer>> subsequences = new ArrayList<>();
        int[] temp = new int[len];
        subsequences(A, temp, len, 0, subsequences);
        // System.out.println("len: " + subsequences.size());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < subsequences.size(); i++) {
            ArrayList<Integer> innerArr = subsequences.get(i);
            // System.out.println(innerArr);
            boolean isIncreasingSubsequence = true;
            if (innerArr.size() == 0) {
                isIncreasingSubsequence = false;
                continue;
            }
            int prev= innerArr.get(0);
            for (int j = 1; j < innerArr.size(); j++) {
                int curr = innerArr.get(j);
                if (prev >= curr) {
                    isIncreasingSubsequence = false;
                    break;
                }
            }
            if (isIncreasingSubsequence) {
                int innerArrLen = innerArr.size();
                if (max < innerArrLen) {
                    max = innerArrLen;
                }
            }
        }
        return max;
    }

    public static void subsequences(ArrayList<Integer> A, int[] temp, int len, int index,
            ArrayList<ArrayList<Integer>> subsequences) {
        if (index > len - 1) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (temp[i] == 1) {
                    innerArr.add(A.get(i));
                }
            }
            subsequences.add(innerArr);
            return;
        }
        temp[index] = 1;
        subsequences(A, temp, len, index + 1, subsequences);
        temp[index] = 0;
        subsequences(A, temp, len, index + 1, subsequences);
    }
}
