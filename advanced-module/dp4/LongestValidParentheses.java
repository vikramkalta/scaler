public class LongestValidParentheses {
    public static void main(String args[]) {
        // String A = ")()())";
        // String A = ")(())";
        // String A = "((()()))()))))(((((((";
        String A = ")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))(((";
        System.out.println(longestValidParentheses(A));
    }
    public static int longestValidParentheses(String A) {
        int len = A.length();
        int[] dp = new int[len];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            char curr = A.charAt(i);
            if (curr == ')' && A.charAt(i-1) == '(') {
                int x = 0;
                if (i - 2 >= 0) {
                    x = dp[i-2];
                }
                x = x + 2;
                if (max < x) {
                    max = x;
                }
                dp[i] = x;
            } else if (curr == ')') {
                int x = dp[i - 1];
                x = i - x - 1;
                if (x >= 0 && A.charAt(x) == '(' ) {
                    int y = 0;
                    if (i - dp[i - 1] - 2 >= 0) {
                        y = dp[i - dp[i - 1] - 2];
                    }
                    x = dp[i-1] + y + 2;
                    dp[i] = x;
                    if (max < x) {
                        max = x;
                    }
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}