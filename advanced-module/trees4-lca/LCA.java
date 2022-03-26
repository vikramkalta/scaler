public class LCA {
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
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // root.left.left.left = new TreeNode(8);
        // root.left.left.right = new TreeNode(9);
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(1);
        // System.out.println(lca(root, 1, 1));
        // System.out.println(lca(root, 8, 4));
        // System.out.println(lca(root, 8, 5));
        // System.out.println(lca(root, 4, 11));
        System.out.println(lca(root, 4, 7));
        // System.out.println(ans.val);
    }

    // public static TreeNode ans;
    public static int lca(TreeNode A, int B, int C) {
        TreeNode ans = lcaT(A, B, C);
        lcaT1(A, B, C);
        if (bFound && cFound) {
            return ans.val;
        }
        return -1;
    }

    public static TreeNode lcaT(TreeNode A, int B, int C) {
        if (A == null || A.val == B || A.val == C) {
            return A;
        }
        TreeNode left = lcaT(A.left, B, C);
        TreeNode right = lcaT(A.right, B, C);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return A;
        }
    }

    private static boolean bFound = false;
    private static boolean cFound = false;

    public static void lcaT1(TreeNode A, int B, int C) {
        if (A == null) {
            return;
        }
        lcaT1(A.left, B, C);
        lcaT1(A.right, B, C);
        if (A.val == B) {
            bFound = true;
        }
        if (A.val == C) {
            cFound = true;
        }
    }
}
