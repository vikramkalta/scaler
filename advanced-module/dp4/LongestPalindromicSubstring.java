public class LongestPalindromicSubstring {
    public static void main(String args[]) {
        // String A = "babab";
        String A = "aacabdkacaa";
        System.out.println(longestPalindrome(A));
    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        // int[][] dp = new int[len][len];
        boolean[][] dp = new boolean[len][len];
        int maxI = 0, maxJ = 0;
        int max = Integer.MIN_VALUE;
        // Diagonal iteration.
        for (int g = 0; g < len; g++) {
            for (int i = 0, j = g; j < len; j++,i++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                    if (dp[i][j]) {
                        int x = j - i;
                        if (max < x) {
                            maxI = i;
                            maxJ = j;
                            max = x;
                        }
                    }
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1] ? true : false;
                    if (dp[i][j]) {
                        int x = j - i;
                        if (max < x) {
                            maxI = i;
                            maxJ = j;
                            max = x;
                        }
                    }
                }
            }
        }
        // System.out.println(max);
        StringBuilder sb = new StringBuilder();
        for (int i = maxI; i <= maxJ; i++) {
            sb.append(s.charAt(i));
        }
        // return max == Integer.MIN_VALUE ? new String(sb.append(s.charAt(0))) : new String(sb);
        return new String(sb);
    }

}
