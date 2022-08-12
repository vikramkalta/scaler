public class NodeDistance {
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
        // 5
        // 2  8
        // 1 4 6 11
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(11);
        // System.out.println(solve(root, 2, 11));
        // System.out.println(solve(root, 8, 11));
        // System.out.println(solve(root, 6, 11));
        System.out.println(solve(root, 2, 1));
    }

    public static int distance = 0;

    public static int solve(TreeNode A, int B, int C) {
        TreeNode lca = findLCA(A, B, C);
        int ans = 0;
        if (lca.val == B) {
            findDistance(lca, C);
            ans = distance;
        } else if (lca.val == C) {
            findDistance(lca, B);
            ans = distance;
        } else {
            findDistance(lca, B);
            ans = distance;
            distance = 0;
            findDistance(lca, C);
            ans += distance;
        }
        return ans;
    }

    public static void findDistance(TreeNode lca, int C) {
        if (lca == null) {
            return;
        }
        if (C < lca.val) {
            distance++;
            findDistance(lca.left, C);
        } else if (C > lca.val) {
            distance++;
            findDistance(lca.right, C);
        } else {
            return;
        }
    }

    public static TreeNode findLCA(TreeNode A, int B, int C) {
        if (A == null) {
            return null;
        }
        if (A.val == B || A.val == C) {
            return A;
        }
        TreeNode left = findLCA(A.left, B, C);
        TreeNode right = findLCA(A.right, B, C);

        if (left != null && right != null) {
            return A;
        } else if (left == null && right != null) {
            return right;
        } else if (right == null && left != null) {
            return left;
        } else {
            return null;
        }
    }
    // public static boolean findLCA(TreeNode A, int B, int C) {
    //     if (A == null) {
    //         return false;
    //     }
    //     if (A.val == B || A.val == C) {
    //         return true;
    //     }
    //     boolean left = findLCA(A.left, B, C);
    //     boolean right = findLCA(A.right, B, C);

    //     if (left && right) {
    //         lca = A;
    //         return true;
    //     } else if (!left && right) {
    //         lca = A.right;
    //         return right;
    //     } else if (!right && left) {
    //         lca = A.left;
    //         return left;
    //     }
    //     return left || right;
    // }
}