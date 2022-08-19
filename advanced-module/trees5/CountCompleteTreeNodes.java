public class CountCompleteTreeNodes {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        System.out.println(solve(root));
    }

    public static int solve(TreeNode A) {
        int lHeight = getLeftHeight(A);
        int rHeight = getRightHeight(A);
        if (lHeight != rHeight) {
            return 1 + solve(A.left) + solve(A.right);
        } else {
            int x = 1 << rHeight;
            return x - 1;
        }
    }

    public static int getLeftHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return getLeftHeight(A.left) + 1;
    }

    public static int getRightHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return getRightHeight(A.right) + 1;
    }
}
