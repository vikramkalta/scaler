import java.util.ArrayList;

public class SpecialInteger {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 4, 5 };
        int[] arr = { 5, 17, 100, 11 };

        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 10));
        System.out.println(solve(A, 130));
        // System.out.println(solve(A, 24));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();

        int l = 0, r = len, m = (l + r) / 2;

        int maxK = Integer.MIN_VALUE;
        while (l <= r) {
            int sum = 0;
            int count = 0;
            boolean isAns = true;
            // {1,2,3,4,5,6}, 10
            for (int i = 0; i < len; i++) {
                int curr = A.get(i);

                if (count >= m) {
                    sum -= A.get(i - count);
                    count--;
                }

                sum += curr;
                count++;

                if (sum > B) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) {
                if (maxK < m) {
                    maxK = m;
                }
                l = m + 1;
            } else {
                r = m - 1;
            }

            m = (l + r) / 2;
        }
        return maxK;
    }
}
