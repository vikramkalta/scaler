import java.util.ArrayList;

public class BuildTree {
    // TreeNode root;
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

        int rootElement = B.get(len-1);
        TreeNode root = new TreeNode(rootElement);
        TreeNode ans = build(root, A, B, 0, len - 1, 0, len - 1);
        return ans;
    }

    public static TreeNode build(TreeNode root, ArrayList<Integer> A, ArrayList<Integer> B, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(A.get(inStart));
        }
        int breakIndex = searchBreakIndex(A, B, inStart, postEnd);
        TreeNode left = build(root, A, B, inStart, breakIndex - 1, inStart, breakIndex - 1);
        TreeNode right = build(root, A, B, breakIndex + 1, inEnd, breakIndex, inEnd - 1);
        TreeNode _root = new TreeNode(A.get(breakIndex));
        _root.left = left;
        _root.right = right;
        return _root;
    }

    public static int searchBreakIndex(ArrayList<Integer> A, ArrayList<Integer> B, int startIndex, int endIndex) {
        int foundIndex = -1;
        int rootElement = B.get(endIndex);
        for (int i = startIndex; i <= endIndex; i++) {
            int curr = A.get(i);
            if (curr == rootElement) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    public static void preOrder(TreeNode A) {
        if (A == null){return;}
        System.out.println("A.val " + A.val);
        preOrder(A.left);
        preOrder(A.right);
    }

    public static TreeNode build1(TreeNode root, ArrayList<Integer> A, ArrayList<Integer> B, int len, int l, int r) {
        if (l > r) {
            return root;
        }
        int mid = (l+r) / 2;
        build1(root, A, B, len, l, mid);
        build1(root, A, B, len, mid + 1, r);
        _buildTree(root, A, B, len, l, mid, r);
        return root;
    }

    public static void _buildTree(TreeNode root, ArrayList<Integer> A, ArrayList<Integer> B, int len, int l, int m, int r) {
        System.out.println("l: " + l);
        System.out.println("a[l]: " + A.get(l));
        System.out.println("B[l]: " + B.get(l));
        System.out.println("r: " + r);
        System.out.println("a[r]: " + A.get(r));
        System.out.println("B[r]: " + B.get(r));
        System.out.println("end");
    }

    public static void main(String args[]) {
        // int[] a = {4,2,5,1,6,3,7};
        int[] a = {7, 5, 6, 2, 3, 1, 4};
        // int[] b = {4,5,2,6,7,3,1};
        int[] b = {5, 6, 3, 1, 4, 2, 7};
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B= new ArrayList<>();
        for (int i = 0; i < a.length; i++) A.add(a[i]);
        for (int i = 0; i < b.length; i++) B.add(b[i]);
        // System.out.println(buildTree(A, B));
        TreeNode ans = buildTree(A, B);

    }
}
