import java.util.ArrayList;

public class LongestPalindromicSub {
    public static void main(String args[]) {
        String A = "aedsead";
        // String A = "bebeeed";
        System.out.println(solve(A));
    }

    public static int solve(String A) {
        int len = A.length();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                innerArr.add(-1);
            }
            dp.add(innerArr);
        }
        int ans = findLongestPalindrome(A, 0, len - 1, dp);
        return ans;
    }

    public static int findLongestPalindrome(String A, int i, int j, ArrayList<ArrayList<Integer>> dp) {
        if (j == i) {
            return 1;
        }
        if (j < i) {
            return 0;
        }

        int curr = dp.get(i).get(j);
        if (curr > -1) {
            return curr;
        }
        int ans = 0;
        if (A.charAt(i) == A.charAt(j)) {
            ans = findLongestPalindrome(A, i + 1, j - 1, dp) + 2;
        } else {
            int x = findLongestPalindrome(A, i + 1, j, dp);
            int y = findLongestPalindrome(A, i, j - 1, dp);
            ans += Math.max(x, y);
        }
        dp.get(i).set(j, ans);
        return ans;
    }
}