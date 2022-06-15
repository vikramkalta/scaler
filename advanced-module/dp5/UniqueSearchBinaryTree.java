public class UniqueSearchBinaryTree {
    public static void main(String args[]) {
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
    }
    public static int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int x = i - 1;
            int y = 0;
            int catNum = 0;
            while( x >= 0 && y <= n) {
                int z = dp[x] * dp[y];
                catNum += z;
                x--;
                y++;
            }
            dp[i] = catNum;
        }

        return dp[n];
    }
}