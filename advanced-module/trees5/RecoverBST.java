import java.util.ArrayList;

public class RecoverBST {
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
        // Original BST.
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(3);
        // root.right = new TreeNode(8);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(4);
        // root.right.left = new TreeNode(7);
        // root.right.right = new TreeNode(9);
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(3);
        // root.right = new TreeNode(8);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(7);
        // root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(9);
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // TreeNode root = new TreeNode(2);
        // root.left = new TreeNode(3);
        // root.right = new TreeNode(1);
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(3);
        // root.left.right = new TreeNode(2);
        // 3
        // 1 4
        // 2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        System.out.println(recoverTree(root));
    }

    static int swapped1 = -1;
    static int swapped2 = -1;
    static TreeNode prev = null;

    public static ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        getSwapped(A);
        ans.add(swapped1);
        ans.add(swapped2);
        swap(A);
        return ans;
    }

    public static void swap(TreeNode A) {
        if (A == null) {
            return;
        }
        if (A.val == swapped1) {
            A.val = swapped2;
        }
        if (A.val == swapped2) {
            A.val = swapped1;
        }
        swap(A.left);
        swap(A.right);
    }

    public static void getSwapped(TreeNode A) {
        if (A == null) {
            return;
        }
        getSwapped(A.left);
        if (prev != null && prev.val > A.val) {
            if (swapped1 == -1) {
                swapped2 = prev.val;
                swapped1 = A.val;
            } else {
                swapped1 = A.val;
            }
        }
        prev = A;
        getSwapped(A.right);
    }

    public static Info findSwapped(TreeNode A) {
        if (A == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, null);
        }
        Info left = findSwapped(A.left);
        Info right = findSwapped(A.right);
        int leftMax = Math.max(Math.max(left.leftMax, right.leftMax), A.val);
        int rightMin = Math.min(Math.min(left.rightMin, right.rightMin), A.val);
        boolean isBST = left.isBST && right.isBST && A.val > left.leftMax && A.val < right.rightMin;

        if (A.val > right.rightMin && A.val < left.leftMax) {
            swapped1 = left.leftMax;
            swapped2 = right.rightMin;
        } else if (A.val < left.leftMax && A.val < right.rightMin) {
            swapped1 = left.leftMax;
            swapped2 = A.val;
        } else if (A.val < left.leftMax || A.val > right.rightMin) {
            swapped1 = left.leftMax;
            swapped2 = right.rightMin;
        }
        return new Info(leftMax, rightMin, isBST, A);
    }

    static class Info {
        int leftMax;
        int rightMin;
        boolean isBST;
        TreeNode nodeRef;

        public Info(int leftMax, int rightMin, boolean isBST, TreeNode nodeRef) {
            this.leftMax = leftMax;
            this.rightMin = rightMin;
            this.isBST = isBST;
            this.nodeRef = nodeRef;
        }
    }
}
