import java.util.ArrayList;
import java.util.Collections;

public class LeafNodesBST {
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
        //    5
        //  3   8
        // 1 4 7 9
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(3);
        // root.right = new TreeNode(8);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(4);
        // root.right.left = new TreeNode(7);
        // root.right.right = new TreeNode(9);
        ArrayList<Integer> A=new ArrayList<>();
        // int[] a = {5,3,1,4,8,7,9};
        int[] a = {42, 22, 17, 11, 19, 38, 31};
        // int[] a = {3,2,4};
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        
        // 5,3,1,4,8,7,9
        // 1,3,4,5,7,8,9
        System.out.println(solve(A));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> preorder = new ArrayList<>();
        preorder.addAll(A);
        Collections.sort(A);
        int len = A.size();
        TreeNode root = createBTFromInAndPre(preorder, A, 0, len -1, 0, len - 1);
        getLeafNodes(root, result);
        return result;
    }
    public static TreeNode createBTFromInAndPre(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootPre = preorder.get(preStart);
        int rootIndex = getInRoot(inorder, rootPre, inStart, inEnd);
        int leftInLen = (rootIndex - 1) - inStart;
        TreeNode left = createBTFromInAndPre(preorder, inorder, preStart + 1, preStart + 1 + leftInLen  , inStart, rootIndex - 1);
        int rightInLen = inEnd - (rootIndex + 1);
        TreeNode right = createBTFromInAndPre(preorder, inorder, preEnd - rightInLen, preEnd, rootIndex + 1, inEnd);
        TreeNode root = new TreeNode(rootPre);
        root.left = left;
        root.right = right;
        return root;
    }
    public static int getInRoot(ArrayList<Integer> inorder, int rootPre, int inStart, int inEnd) {
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootPre == inorder.get(i)) {
                rootIndex = i;
                break;
            }
        }
        return rootIndex;
    }
    public static void getLeafNodes(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        getLeafNodes(root.left, result);
        getLeafNodes(root.right, result);
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
    }
}
