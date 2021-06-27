import java.util.ArrayList;

public class AllocateBooks {
    public static void main(String args[]) {
        // int[] arr = { 3, 6, 9, 4 };
        int[] arr = { 97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68,
                90, 24 };
        // int[] arr = { 12, 34, 67, 90 };
        // int[] arr = { 10, 15, 18, 25, 35, 40, 26 };
        // int[] arr = { 73, 58, 30, 72, 44, 78, 23, 9 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 3));
        System.out.println(solve(A, 26));
        // System.out.println(solve(A, 2));
        // System.out.println(solve(A, 4));
        // System.out.println(solve(A, 5));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (max < curr) {
                max = curr;
            }
            sum += curr;
        }
        if (B > len) {
            return -1;
        }

        int l = max, r = sum, m = 0;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            m = (l + r) / 2;
            int pagesAllocated = 0;
            int count = 1;
            for (int i = 0; i < len; i++) {
                int curr = A.get(i);
                pagesAllocated += curr;
                if (pagesAllocated > m) {
                    count++;
                    pagesAllocated = curr;
                }
            }

            if (count <= B) {
                r = m - 1;
                if (count == B && min > m) {
                    min = m;
                }
            } else if (count > B) {
                l = m + 1;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return max;
        }
        return min;
    }

    public static int solve2(ArrayList<Integer> A, int B) {
        int len = A.size();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (min > curr) {
                min = curr;
            }
            sum += curr;
        }

        int l = min, r = sum, m = (l + r) / 2;
        int max = Integer.MIN_VALUE;
        while (l <= r) {
            int maxPages = 0;
            int students = 0;
            int lastIndex = -1;
            for (int i = 0; i < len; i++) {
                int curr = A.get(i);
                maxPages += curr;
                if (maxPages > m) {
                    if (max < maxPages) {
                        max = maxPages;
                    }
                    maxPages = 0;
                    lastIndex = i;
                    students++;
                }
            }
            int x = len - 1 - lastIndex;
            if (students + x >= B) {
                l = m + 1;
            } else {
                r = m - 1;
            }
            m = (l + r) / 2;
            // if (l == r) {
            // System.out.println(m);
            // }
        }
        return m + 1;
    }

    public static int solve1(ArrayList<Integer> A, int B) {
        int len = A.size();
        int maxSubArrayLen = len - B + 1;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            sum += curr;
        }

        int min = Integer.MAX_VALUE;

        int l = 0, r = len - 1, m = (l + r) / 2;

        int sw = (int) Math.ceil(len / B);
        while (sw <= maxSubArrayLen) {
            int sumMax = 0;
            // int max = Integer.MIN_VALUE;
            int minSum = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 0; i < len; i++) {
                int curr = A.get(i);
                if (count == sw) {
                    sumMax = sumMax - A.get(i - sw);
                    count--;
                }

                sumMax += curr;
                count++;

                if (minSum > sumMax && count == sw) {
                    minSum = sumMax;
                }
            }
            if (min > minSum) {
                min = minSum;
            }
            sw++;
        }

        return min;
    }
}
