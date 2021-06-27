import java.util.ArrayList;

public class SpecialInt {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 4, 5 };
        // int[] arr = { 5, 17, 100, 11 };
        int[] arr = { 5, 10, 20, 100, 105 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 10));
        // System.out.println(solve(A, 130));
        System.out.println(solve(A, 130));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        int l = 0, r = len, m = (l + r) / 2;
        int max = Integer.MIN_VALUE;
        while (l <= r) {
            int sum = 0;
            int count = 1;
            boolean isValid = true;
            for (int i = 0; i < len; i++) {
                int curr = A.get(i);
                sum += curr;
                if (count == m) {
                    if (sum > B) {
                        isValid = false;
                        break;
                    }
                    sum -= A.get(i - (m - 1));
                    count--;
                }
                count++;
            }
            if (isValid) {
                if (max < m) {
                    max = m;
                }
                l = m + 1;
            } else {
                r = m - 1;
            }
            m = (l + r) / 2;
        }

        return max;
    }
}
