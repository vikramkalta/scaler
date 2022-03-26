public class FlattenToLinkedList {
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
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(3);
        // root.right = new TreeNode(7);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(6);
        // root.right.left = new TreeNode(5);
        // root.right.right = new TreeNode(6);
        // System.out.println(solve(root));
        flatten(root);
        System.out.println();
    }
    
    public static TreeNode prev;
    public static void flatten(TreeNode root) {
        prev = new TreeNode(root.val);
        preOrder(root);
    }
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (prev != root) {
            prev.left = null;
            prev.right = root;
            prev = prev.right;
        }
        preOrder(root.left);
        preOrder(root.right);
    }
}
