public class SameTree {
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
        // 1
        // 2 3
        // 4 5 6 7
        // int[] A = {1,2,4,5,3,6,7};
        // int[] B = {4,2,5,1,6,3,7};
        // int[] C = {4,5,2,6,7,3,1};
        int[] A = { 3, 18, 26, 16, 5 };
        int[] B = { 16, 5, 18, 3, 26 };
        int[] C = { 3, 16, 5, 18, 26 };

        System.out.println(solve(A, B, C));
    }

    public static int solve(int[] A, int[] B, int[] C) {
        int len = A.length;
        TreeNode inPreRoot = buildTreeInPre(A, B, 0, len - 1, 0, len - 1);
        TreeNode inPostRoot = buildTreeInPost(B, C, 0, len - 1, 0, len - 1);
        boolean isSame = checkIfSame(inPreRoot, inPostRoot);
        return isSame ? 1 : 0;
    }

    public static boolean checkIfSame(TreeNode A, TreeNode B) {
        if (A == null && B != null || A != null && B == null) {
            return false;
        }
        if (A == null && B == null) {
            return true;
        }
        if (A.val != B.val) {
            return false;
        }
        boolean x = checkIfSame(A.left, B.left);
        boolean y = checkIfSame(A.right, B.right);
        return x || y;
    }

    public static TreeNode buildTreeInPre(int[] A, int[] B, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(A[preStart]);
        }
        int rootPre = A[preStart];
        int rootIn = findRootIn(B, inStart, inEnd, rootPre);
        if (rootIn == -1) {
            return null;
        }
        int _preEnd = (rootIn - 1 - inStart) + preStart + 1;
        TreeNode left = buildTreeInPre(A, B, preStart + 1, _preEnd, inStart, rootIn - 1);
        int x = inEnd - (rootIn + 1);
        int _preStart = preEnd - x;
        TreeNode right = buildTreeInPre(A, B, _preStart, preEnd, rootIn + 1, inEnd);
        TreeNode root = new TreeNode(rootPre);
        root.left = left;
        root.right = right;
        return root;
    }

    public static int findRootIn(int[] B, int inStart, int inEnd, int rootEl) {
        int foundIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootEl == B[i]) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    public static TreeNode buildTreeInPost(int[] A, int[] B, int postStart, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(B[postEnd]);
        }
        int rootPost = B[postEnd];
        int rootIn = findRootInPre(A, inStart, inEnd, rootPost);
        if (rootIn == -1) {
            return null;
        }
        int _postEnd = postStart + ((rootIn - 1) - inStart);
        TreeNode left = buildTreeInPost(A, B, postStart, _postEnd, inStart, rootIn - 1);
        int _postStart = postEnd - 1 - (inEnd - (rootIn + 1));
        TreeNode right = buildTreeInPost(A, B, _postStart, postEnd - 1, rootIn + 1, inEnd);
        TreeNode root = new TreeNode(rootPost);
        root.left = left;
        root.right = right;
        return root;
    }

    public static int findRootInPre(int[] A, int inStart, int inEnd, int roolEl) {
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (A[i] == roolEl) {
                index = i;
                break;
            }
        }
        return index;
    }
}