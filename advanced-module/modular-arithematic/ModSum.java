import java.util.ArrayList;

public class ModSum {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 4 };
        int[] arr = { 1, 2, 3 };
        // int[] arr = { 686, 675, 758, 659, 377, 965, 430, 220, 599, 699 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        long mod = 1000000007l;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            long curr = A.get(i);
            // sum = (sum + curr) % mod;
            sum += curr;
        }
        // sum /= 2;
        long ans = 0;
        for (int i = 0; i < len; i++) {
            long curr = A.get(i);
            long remainder = sum % curr;
            // ans = (ans + remainder) % mod;
            ans += remainder;
        }
        // sum = sum % mod;if (sum < 0)sum += mod;
        return (int) ans;
    }

    public static int solve2(ArrayList<Integer> A) {
        int len = A.size();
        long mod = 1000000007l;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            long currI = A.get(i);
            for (int j = 0; j < len; j++) {
                if (i == j)
                    continue;
                long currJ = A.get(j);
                long remainder = currI % currJ;
                sum += remainder;
            }
        }
        sum = sum % mod;
        if (sum < 0)
            sum += mod;
        return (int) sum;
    }

    public static int solve1(ArrayList<Integer> A) {
        int len = A.size();
        long mod = 1000000007l;
        ArrayList<Long> modArr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            long curr = A.get(i);
            modArr.add(curr % mod);
        }
        long sum = 0l;
        long occurrence = len - 1;
        for (int i = 0; i < len; i++) {
            long curr = modArr.get(i);
            long x = (curr * occurrence) % mod;
            sum = (sum + x) % mod;
        }
        sum = sum % mod;
        if (sum < 0)
            sum += mod;
        return (int) sum;
    }
}
