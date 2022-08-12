import java.util.HashMap;

public class EqualPartition {
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
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(3);
        // root.right = new TreeNode(7);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(6);
        // root.right.left = new TreeNode(5);
        // root.right.right = new TreeNode(6);
        System.out.println(solve(root));
    }
    public static int equalCount = 0;
    public static int solve(TreeNode A) {
        long sum = sum(A);
        checkSum(A, sum / 2l);
        return equalCount == 2 ? 1 : 0;
    }

    public static long checkSum(TreeNode A, long halfSum) {
        if (A == null) {
            return 0l;
        }
        long _sum = A.val * 1l;
        long x = checkSum(A.left, halfSum);
        long y = checkSum(A.right, halfSum);
        _sum = _sum + x + y;
        if (_sum == halfSum) {
            equalCount++;
            _sum = 0;
        }
        return _sum;
    }

    public static long sum(TreeNode A) {
        if (A == null) {
            return 0l;
        }
        long _sum = A.val * 1l;
        long x = sum(A.left);
        long y = sum(A.right);
        _sum = _sum + x + y;
        return _sum;
    }
}
