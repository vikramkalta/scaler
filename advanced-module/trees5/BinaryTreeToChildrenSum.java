public class BinaryTreeToChildrenSum {
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
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);
        solve(root);
        System.out.println();

    }

    public static TreeNode solve(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode left = solve(A.left);
        TreeNode right = solve(A.right);
        int val = A.val;
        int leftVal = left != null ? left.val : 0;
        int rightVal = right != null ? right.val : 0;
        int x = leftVal + rightVal;
        int diff = x - val;
        if (diff > 0) {
            A.val = A.val + diff;
        } else if (diff < 0) {
            increment(A, diff);
        }
        return A;
    }

    /* This function is used to increment subtree by diff */
    public static void increment(TreeNode node, int diff) {
        /* IF left child is not NULL then increment it */
        if (node.left != null) {
            node.left.val = node.left.val + diff;

            // Recursively call to fix the descendants of node->left
            increment(node.left, diff);
        } else if (node.right != null) // Else increment right child
        {
            node.right.val = node.right.val + diff;

            // Recursively call to fix the descendants of node->right
            increment(node.right, diff);
        }
    }

    // if (left != null) {
    // left.val = left.val + diff;
    // } else if (right != null) {
    // right.val = right.val + diff;
    // }
}