import java.util.ArrayList;

public class WeirdFunction {
    public static void main(String args[]) {
        // int[] arr = { 4, 2, 5, 1 };
        int[] arr = { 1, 2, 3 };

        ArrayList<Integer> A = new ArrayList<>();
        // for (int i = 0; i < arr.length; i++) {
        // A.add(arr[i]);
        // }
        for (int i = 0; i < 50000; i++) {
            A.add(1);
        }
        System.out.println(solve(A.size(), A));
    }

    public static int solve(int A, ArrayList<Integer> B) {
        int len = B.size();
        long mod = 1000000007l;
        long sum = 0l;
        for (int i = 0; i < len; i++) {
            int curr = B.get(i);
            for (int j = i + 1; j < len; j++) {
                int currJ = B.get(j);
                int weird = weird(curr, currJ);
                sum += (long) weird;
            }
        }
        sum = sum % mod;
        if (sum < 0)
            sum += mod;
        return (int) sum;
    }

    private static int weird(int a, int b) {
        int diff = Math.abs(a - b);
        if (diff > 1) {
            return b - a;
        } else {
            return 0;
        }
    }
}