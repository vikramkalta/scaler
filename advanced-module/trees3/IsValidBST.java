import java.util.ArrayList;

public class IsValidBST {
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
        // TreeNode root = new TreeNode(8);
        // root.left = new TreeNode(4);
        // root.right = new TreeNode(12);
        // root.left.left = new TreeNode(2);
        // root.left.right = new TreeNode(6);
        // root.right.left = new TreeNode(10);
        // root.right.right = new TreeNode(14);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(isValidBST(root));
        // isValidBST(root);
    }
    public static ArrayList<Integer> bstList = new ArrayList<>();
    public static int isValidBST(TreeNode A) {
        inOrder(A);
        int prev = bstList.get(0);
        for (int i = 1, len = bstList.size(); i < len; i++) {
            int curr = bstList.get(i);
            if (curr <= prev) {
                return 0;
            }
            prev = curr;
        }
        return 1;
    }
    public static void inOrder(TreeNode A) {
        if (A == null) {
            return;
        }
        inOrder(A.left);
        bstList.add(A.val);
        inOrder(A.right);
    }

    // private static int lastInt = -1;
    public static int isValidBST1(TreeNode A) {
        if (A == null) {
            return 1;
        }
        int left = isValidBST1(A.left);
        int right = isValidBST1(A.right);

        if (left == 0 || right == 0) {
            return 0;
        }

        boolean isValid = false;
        if (A.left != null && A.left.val < A.val) {
            isValid = true;
        } else if (A.left == null) {
            isValid = true;
        } else {
            isValid = false;
        }
        if (A.right != null && A.right.val > A.val) {
            isValid = true;
        } else if (A.right == null) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid ? 1 : 0;
    }
}
