import java.util.ArrayList;

public class BuildTreePreIn {
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

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();
        TreeNode root = createTreePreAndIn(B, A, 0, len - 1, 0, len - 1);
        return root;
    }

    public static TreeNode createTreePreAndIn(ArrayList<Integer> A, ArrayList<Integer> B, int inStart, int inEnd,
            int preStart, int preEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(A.get(inStart));
        }
        int searchIndex = searchRootIndex(A, B, inStart, inEnd, preStart);
        TreeNode left = createTreePreAndIn(A, B, inStart, searchIndex - 1, preStart + 1, (preStart + 1) + (searchIndex - 1 - inStart));
        TreeNode right = createTreePreAndIn(A, B, searchIndex + 1, inEnd, preEnd - (inEnd - (searchIndex+1)), preEnd);
        TreeNode root = new TreeNode(A.get(searchIndex));
        root.left = left;
        root.right = right;
        return root;
    }

    public static int searchRootIndex(ArrayList<Integer> A, ArrayList<Integer> B, int inStart, int inEnd,
            int preStart) {
        int rootEl = B.get(preStart);
        int searchIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            int curr = A.get(i);
            if (curr == rootEl) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    public static void main(String args[]) {
        // int[] in = {4,2,5,1,6,3,7};
        int[] in = {5, 6, 1, 2, 3, 4};
        // int[] pre = {1,2,4,5,3,6,7};
        int[] pre = {2, 1, 6, 5, 3, 4};
        ArrayList<Integer>A=new ArrayList<>();
        ArrayList<Integer>B=new ArrayList<>();
        for (int i = 0; i < in.length; i++)A.add(in[i]);
        for (int i = 0; i < pre.length; i++)B.add(pre[i]);
        System.out.println(buildTree(B, A));
    }
}
