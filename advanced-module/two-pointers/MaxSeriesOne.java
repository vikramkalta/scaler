import java.util.ArrayList;

public class MaxSeriesOne {
    public static void main(String args[]) {
        // int[] arr = { 1, 1, 0, 1, 1, 0, 0, 1, 1, 1 };
        // int[] arr = { 1, 0, 0, 0, 1, 0, 1 };
        // int[] arr = { 1, 1, 0 };
        int[] arr = { 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1,
                0, 1, 1, 0, 0 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 1));
        // System.out.println(solve(A, 2));
        System.out.println(solve(A, 0));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        int start = 0, end = 1;
        int maxStart = 0, maxEnd = 0, max = Integer.MIN_VALUE;
        if (B == 0) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                int curr = A.get(i);
                if (count == 0) {
                    start = i;
                }
                if (curr == 1) {
                    count++;
                    end = i;
                } else {
                    count = 0;
                }
                if (max < count) {
                    maxStart = start;
                    maxEnd = end;
                    max = count;
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = maxStart; i <= maxEnd; i++) {
                result.add(i);
            }
            return result;
        }
        if (A.get(start) == 0)
            B--;
        // 1, 0, 0, 0, 1, 0, 1
        while (start < len && end < len) {
            int currEnd = A.get(end);
            if (B < 0) {
                while (B != 0) {
                    if (A.get(start) == 0) {
                        B++;
                    }
                    start++;
                }
                end++;
                continue;
            }
            if (currEnd == 0) {
                B--;
                if (B < 0) {
                    int diff = end - start;
                    if (max < diff) {
                        maxStart = start;
                        maxEnd = end;
                        max = diff;
                    }
                } else {
                    end++;
                }
            }
            if (currEnd == 1) {
                end++;
            }
            if (end == len && B >= 0) {
                int diff = end - start;
                if (max < diff) {
                    maxStart = start;
                    maxEnd = end;
                    max = diff;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = maxStart; i < maxEnd; i++) {
            result.add(i);
        }
        return result;
    }

    public static ArrayList<Integer> solve1(ArrayList<Integer> A, int B) {
        int len = A.size();
        int s = 0, e = 0;
        int maxLen = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (curr == 1) {
                maxLen++;
            } else {
                maxLen = 0;
            }
            if (max < maxLen) {
                max = maxLen;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        return result;
    }
}
