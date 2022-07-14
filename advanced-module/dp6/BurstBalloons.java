public class BurstBalloons {
    public static void main(String args[]) {
        int[] A = { 3, 1, 5, 8 };
        System.out.println(maxCoins(A));
    }

    public static int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            int row = 0;
            for (int j = i; j < len; row++, j++) {
                int max = Integer.MIN_VALUE;
                for (int k = row; k <= j; k++) {
                    int left = row == k ? 0 : dp[row][k - 1];
                    int right = j == k ? 0 : dp[k + 1][j];
                    int x = (row > 0 ? nums[row - 1] : 1) * (j < len - 1 ? nums[j + 1] : 1) * nums[k];
                    max = Math.max(max, left + right + x);
                }
                dp[row][j] = max;
            }
        }
        return dp[0][len - 1];
    }
}