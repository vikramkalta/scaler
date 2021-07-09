import java.util.ArrayList;
import java.util.Collections;

public class FindMaxMinSum {
    public static void main(String args[]) {
        int[] arr = { 1, 2 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int mod = 1000000007;
        Collections.sort(A);
        long sum = 0l;
        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            for (int j = i + 1; j < len; j++) {
                int currJ = A.get(j);
                long diff = 1l * (currJ - currI);
                long distance = 1l * (j - i - 1);
                long occurrence = binaryExp(2, distance);
                long x = (diff * occurrence) % mod;
                sum = (sum + x) % mod;
            }
        }
        sum = sum % mod;
        if (sum < 0) {
            sum += mod;
        }
        return (int) (sum);
    }

    public static long binaryExp(long a, long b) {
        long mod = 1000000007l;
        if (b == 0) {
            return 1;
        }
        long res = binaryExp(a, b / 2);
        if (b % 2 != 0) {
            res = (res * res) % mod;
            if (res < 0) {
                res += mod;
            }
            res = (res * a) % mod;
            if (res < 0) {
                res += mod;
            }
            return res;
        } else {
            res = (res * res) % mod;
            if (res < 0) {
                res += mod;
            }
            return res;
        }

    }
}
