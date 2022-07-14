public class MaxPathSum {
    public static void main(String args[]) {
        // 9 -100 -200 -1 -300 -400 -1 -1 -1 -1
        // TreeNode root = new TreeNode(9);
        // root.left = new TreeNode(-100);
        // root.right = new TreeNode(-200);
        // root.left.right = new TreeNode(-300);
        // root.right.left = new TreeNode(-400);
        // TreeNode root = new TreeNode(-10);
        // TreeNode root = new TreeNode(-10);
        // root.left = new TreeNode(9);
        // root.right = new TreeNode(20);
        // root.right.left = new TreeNode(15);
        // root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }
    public static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }
    public static int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int x = Math.max(0, solve(root.left));
        int y = Math.max(0, solve(root.right));
        int val = root.val;
        max = Math.max(max, (x + y) + val);
        return Math.max(x, y) + val;
    }
    public static int solve1(TreeNode root) {
        int a = -1000000;
        if (root == null) {
            // return 0;
            return a;
        }
        int ans = 0;
        int x = solve(root.left);
        int y = solve(root.right);
        // ans = Math.max(ans, x + y + root.val);
        // ans = x + y + root.val;
        int z = root.val;
        // ans = Math.max(x, Math.max(y, z));
        ans = z;
        if (x == a) {
            x = 0;
        }
        if (y == a) {
            y = 0;
        }
        // ans = Math.max(ans, Math.max(0, x) + Math.max(0, y) + z);
        ans = Math.max(ans, x + y + z);
        ans = Math.max(ans, x + z);
        ans = Math.max(ans, y + z);
        if (max < ans) {
            max = ans;
        }
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}