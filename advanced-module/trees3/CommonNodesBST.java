public class CommonNodesBST {
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
        TreeNode A = new TreeNode(8);
        A.left = new TreeNode(4);
        A.right = new TreeNode(12);
        A.left.left = new TreeNode(2);
        A.left.right = new TreeNode(6);
        A.right.left = new TreeNode(10);
        A.right.right = new TreeNode(14);
        TreeNode B = new TreeNode(8);
        B.left = new TreeNode(5);
        B.right = new TreeNode(12);
        B.left.left = new TreeNode(2);
        B.left.right = new TreeNode(6);
        B.right.left = new TreeNode(11);
        B.right.right = new TreeNode(15);
        System.out.println(solve(A, B));
    }
    private static long sum = 0l;
    private static long mod = 1000000007l;
    public static int solve(TreeNode A, TreeNode B) {
        preOrder(A, B);
        if (sum < 0) {
            sum += mod;
        }
        return (int)sum;
    }

    public static void preOrder(TreeNode A, TreeNode B) {
        if (A == null) {
            return;
        }
        int isDuplicate = bst(A.val, B);
        if (isDuplicate > 0) {
            sum = sum + (1l * isDuplicate);
            if (sum > mod) {
                sum = sum % mod;
            }
        }
        preOrder(A.left, B);
        preOrder(A.right, B);
    }
    public static int bst(int num, TreeNode B) {
        if (B == null) {
            return 0;
        }
        if (num > B.val) {
            return bst(num, B.right);
        } else if (num < B.val) {
            return bst(num, B.left);
        } else {
            return num;
        }
    }
}