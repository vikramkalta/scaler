import java.util.ArrayList;

public class CoinSum {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3 };
        // int[]arr={2, 5, 3, 6};
        int B = 4;
        // int B= 10;
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A, B));
    }

    static int _ans = 0;

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < B + 1; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                innerList.add(-1);
            }
            dp.add(innerList);
        }
        int ans = coinSum(A, B, 0, dp);
        return ans;
    }

    public static int coinSum(ArrayList<Integer> A, int B, int idx, ArrayList<ArrayList<Integer>> dp) {
        long mod = 1000007l;
        if (B == 0) {
            return 1;
        }
        if (B < 0 || idx >= A.size()) {
            return 0;
        }
        if (dp.get(B).get(idx) != -1) {
            return dp.get(B).get(idx);
        }
        int ans = 0;
        ans += coinSum(A, B - A.get(idx), idx, dp);
        ans = (int)((ans * 1l) % mod);
        ans += coinSum(A, B, idx + 1, dp);
        ans = (int)((ans * 1l) % mod);
        dp.get(B).set(idx, ans);
        return ans;
    }

    public static int coinSum2(ArrayList<Integer> A, int B, int i) {
        if (B == 0) {
            return 1;
        }
        if (B < 0 || i >= A.size()) {
            return 0;
        }
        int x = coinSum2(A, B - A.get(i), i);
        int y = coinSum2(A, B, i + 1);
        return x + y;
    }

    public static int coinSum1(ArrayList<Integer> A, int B, int i, int sum) {
        if (i > A.size() - 1) {
            return _ans;
        }
        if (sum >= B) {
            if (sum == B) {
                _ans++;
            }
            return _ans;
        }
        int curr = A.get(i);
        sum += curr;
        coinSum1(A, B, i, sum);
        sum -= curr;
        coinSum1(A, B, i + 1, sum);
        return _ans;
    }
}
