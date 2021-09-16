public class Height {
    public static void main(String args[]) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    private static int height = 0;
    private static int max = Integer.MIN_VALUE;
    public static void height(TreeNode A) {
        if (A ==null) {
            return;
        }
        if (A.val == -1) {
            return;
        }
        height++;
        if (max < height) {
            max = height;
        }
        height(A.left);
        height(A.right);
        height--;
    }
}
