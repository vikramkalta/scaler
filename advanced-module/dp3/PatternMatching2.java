public class PatternMatching2 {
    public static void main(String args[]) {
        // String A = "abc";
        // String B = "a*b*c";
        // String S = "b";
        // String A = "ab";
        // String A = "aab";
        // String B = "a*b";
        String A = "efw";
        String B = ".*";
        System.out.println(isMatch(A, B));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int isMatch(final String A, final String B) {
        int lenA = A.length() + 1;
        int lenB = B.length() + 1;
        int[][] dp = new int[lenB][lenA];
        dp[0][0] = 1;
        for (int i = 1; i < lenA; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < lenB; i++) {
            if (i - 2 >= 0 && B.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 2][0];
            } else {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i < lenB; i++) {
            for (int j = 1; j < lenA; j++) {
                if (A.charAt(j-1) == B.charAt(i-1) || B.charAt(i-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (B.charAt(i-1) == '*') {
                    if (B.charAt(i-2) == A.charAt(j-1) || B.charAt(i-2) == '.') {
                        dp[i][j] = (dp[i-2][j] == 1 || dp[i][j-1] == 1) ? 1 : 0;
                    } else {
                        dp[i][j] = dp[i-2][j] == 1 ? 1 : 0;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[lenB - 1][lenA - 1];
    }

    public static int isMatch1(final String A, final String B) {
        int lenA = A.length();
        int lenB = B.length();
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 0; i < lenA + 1; i++) {
            for (int j = 0; j < lenB + 1; j++) {
                dp[i][j] = -1;
            }
        }
        boolean ans = patternMatch(A, B, 0, 0, dp);
        return ans ? 1 : 0;
    }

    public static boolean patternMatch(String A, String B, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }
        boolean ans = false;
        if (j == B.length()) {
            ans = i == A.length();
        } else {
            boolean isMatch = i < A.length() && (A.charAt(i) == B.charAt(j) || B.charAt(j) == '.');
            if (j + 1 < B.length() && B.charAt(j + 1) == '*') {
                boolean x = patternMatch(A, B, i, j + 2, dp);
                boolean y = patternMatch(A, B, i + 1, j, dp);
                ans = x || (isMatch && y);
            } else {
                ans = isMatch && patternMatch(A, B, i + 1, j + 1, dp);
            }
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}