public class HasPathSum {
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
        // 26
        // 10 3
        // 4 6 3
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        // System.out.println(hasPathSum(root, 8));
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // System.out.println(hasPathSum(root, 1));
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root, 22));
    }

    public static int ans = 0;
    public static int hasPathSum(TreeNode A, int B) {
        backtrack(A, B);
        return ans;
    }
    public static int sum = 0;
    public static void backtrack(TreeNode A, int B) {
        if (A==null) {
            return;
        }
        sum += A.val;
        if (A.left == null && A.right == null && sum == B) {
            ans = 1;
        }
        backtrack(A.left, B);
        backtrack(A.right, B);
        sum -= A.val;
    }
}
