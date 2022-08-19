public class LargestBST {
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
        // TreeNode root = new TreeNode(10);
        // root.left = new TreeNode(5);
        // root.right = new TreeNode(15);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(8);
        // root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(solve(root));
    }

    static int maxSize = 0;
    public static int solve(TreeNode A) {
        getBSTSize(A);
        return maxSize;
    }

    public static Info getBSTSize(TreeNode A) {
        if (A == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
        }
        Info left = getBSTSize(A.left);
        Info right = getBSTSize(A.right);
        int leftMax = Math.max( Math.max(left.leftMax, right.leftMax), A.val );
        int rightMin = Math.min( Math.min(right.rightMin, left.rightMin ), A.val );
        boolean isBST = left.isBST && right.isBST && A.val > left.leftMax && A.val < right.rightMin;
        int size = left.size + right.size + 1;
        if (isBST && maxSize < size) {
            maxSize = size;
        }
        return new Info(leftMax, rightMin, isBST, size, A.val);
    }

    static class Info {
        int leftMax;
        int rightMin;
        boolean isBST;
        int size;
        int val;
        public Info(int leftMax, int rightMin, boolean isBST, int size, int val) {
            this.leftMax = leftMax;
            this.rightMin = rightMin;
            this.isBST = isBST;
            this.size = size;
            this.val = val;
        }
    }
}