public class DistinctSubsequences {
    public static void main(String args[]) {
        // String A = "ABCDE";
        // String B = "ACE";
        String A = "RABBBIT";
        String B = "RABBIT";
        System.out.println(numDistinct(A, B));
    }
    public static int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int[][] dp = new int[lenS][lenT];
        for (int i = 0; i < lenS; i++) {
            for (int j = 0; j < lenT; j++) {
                dp[i][j] = -1;
            }
        }
        return dp(s, t, lenS - 1, lenT - 1, dp);
    }
    public static int dp(String s, String t, int i, int j, int[][] dp) {
        if (j < 0 && i >= 0 || i < 0 && j < 0) {
            return 1;
        }
        if (i < 0 && j >= 0) {
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            int x = dp(s, t, i-1, j, dp);
            int y = dp(s, t, i-1, j-1, dp);
            ans = x + y;
        } else {
            ans = dp(s, t, i-1, j, dp);
        }
        dp[i][j] = ans;
        return ans;
    }
}