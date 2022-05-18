public class LongestPalindromic {
    public static void main(String args[]) {
        String A = "aedsead";
        System.out.println(solve(A));
    }

    public static int solve(String A) {
        int len = A.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j]=-1;
            }
        }
        int ans = longestPalindrome(A, 0, len-1, dp);
        return ans;
    }
    public static int longestPalindrome(String A, int l, int r, int[][] dp) {
        if (l >= r) {
            if (l == r) {
                return 1;
            }
            return 0;
        }
        if (dp[l][r]!=-1) {
            return dp[l][r];
        }
        int ans = 0;
        if (A.charAt(l) == A.charAt(r)) {
            ans = 2 + longestPalindrome(A, l+1, r-1, dp);
        } else {
            int x = longestPalindrome(A, l+1, r, dp);
            int y = longestPalindrome(A, l, r-1, dp);
            ans = Math.max(x, y);
        }
        dp[l][r] = ans;
        return ans;
    }
}
