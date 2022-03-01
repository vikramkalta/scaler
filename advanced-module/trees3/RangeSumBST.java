import java.util.ArrayList;

public class RangeSumBST {
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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        // root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 7, 15));
    }

    private static int sum = 0;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = inOrder(root, low, high);
        return sum;
    }
    public static int inOrder(TreeNode root, int low, int high) {
        if (root == null) {
            return sum;
        }
        inOrder(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        inOrder(root.right, low, high);
        return sum;
    } 
}