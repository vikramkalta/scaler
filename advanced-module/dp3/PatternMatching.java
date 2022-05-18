public class PatternMatching {
    public static void main(String args[]) {
        // String A = "aaa";
        // String B = "a*";
        // String A = "aa";
        // String B = "a";
        // String A = "acz";
        // String B = "a?a";
        // String A = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        // String B =
        // "a**************************************************************************************";
        // String A = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        // String A = "aa";
        // String B = "*";
        String A = "bbbcbcb";
        // String B = "**b";
        String B = "*b";
        // String A = "acba";
        // String B = "*?b*a*ba*";
        // String A = "cc";
        // String B = "?";
        // String A = "abc";
        // String B = "?c?";
        // String A = "aab";
        // String B = "c*a*b";
        System.out.println(isMatch(A, B));
    }

    public static int isMatch(final String A, final String B) {
        int lenA = A.length();
        int lenB = B.length();
        int allStar = 1;
        for (int i = 0; i < lenB; i++) {
            if (B.charAt(i) != '*') {
                allStar = 0;
                break;
            }
        }
        if (allStar == 1) {
            return allStar;
        }
        int[][] dp = new int[lenA][lenB];
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                dp[i][j] = -1;
            }
        }
        boolean ans = patternMatch1(A, B, lenA - 1, lenB - 1, dp);
        return ans ? 1 : 0;
    }

    public static boolean patternMatch1(String A, String B, int i, int j, int[][] dp) {
        if (i == -1) {
            while(j>=0) {
                if (B.charAt(j) != '*') {
                    return false;
                }
                j--;
            }
            return true;
        }
        if (j < 0 && i >= 0) {
            return false;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }
        boolean ans = false;
        if (B.charAt(j) == '*') {
            boolean x = patternMatch1(A, B, i - 1, j, dp);
            boolean y = patternMatch1(A, B, i, j - 1, dp);
            ans = x || y;
        } else if (A.charAt(i) == B.charAt(j) || B.charAt(j) == '?') {
            ans = patternMatch1(A, B, i - 1, j - 1, dp);
        } else {
            ans = false;
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}
