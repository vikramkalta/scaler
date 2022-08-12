public class SumBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String args[]) {
        //     26
        //   10  3
        // 4   6   3
        // TreeNode root = new TreeNode(26);
        // root.left = new TreeNode(10);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(6);
        // root.right.right = new TreeNode(3);
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.println(solve(root));
    }

    public static int ans = 1;
    public static int solve(TreeNode A) {
        isSumBinary(A);
        return ans;
    }

    public static int isSumBinary(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        int leftSum = isSumBinary(root.left);
        int rightSum = isSumBinary(root.right);
        int x = leftSum + rightSum;
        if (x != 0 && x != sum) {
            ans = 0;
        }
        return sum + x;
    }
}
