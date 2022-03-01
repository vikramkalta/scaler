public class MinDepth {
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
        // int[] a = { 1, 2, 3, 4, 5, -1, 7 };
        // int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        // ArrayList<Integer> A = new ArrayList<>();
        // for (int i = 0; i < a.length; i++)
        // A.add(a[i]);
        // TreeNode root = createTree(A);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }
    private static int min = Integer.MAX_VALUE;
    public static int minDepth(TreeNode root) {
        postOrder(root, 0);
        return min == Integer.MAX_VALUE ? 0 : min + 1;
    }
    public static int postOrder(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        postOrder(root.left, level + 1);
        postOrder(root.right, level + 1);
        if (root.left == null && root.right == null) {
            if (min > level) {
                min = level;
            }
        }
        return level;
    }
}
