import java.util.ArrayList;

public class NodesInRange {
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
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(12);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(27);
        root.left.left.left = new TreeNode(8);
        System.out.println(solve(root, 12, 20));
    }

    private static ArrayList<Integer> list = new ArrayList<>();
    private static int count = 0;

    public static int solve(TreeNode A, int B, int C) {
        inOrder(A, B, C);
        return count;
    }

    public static void inOrder(TreeNode A, int B, int C) {
        if (A == null) {
            return;
        }
        inOrder(A.left, B, C);
        if (A.val >= B && A.val <= C) {
            count++;
        }
        inOrder(A.right, B, C);
    }
}
