import java.util.ArrayList;
import java.util.List;

public class PrintAllRootToLeaf {
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
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(16);
        root.left = new TreeNode(12);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(12);

        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(12);
        root.right.right.left = new TreeNode(12);
        // System.out.println(solve(root));
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode A) {
        List<String> ans = new ArrayList<>();
        rootToLeavesString(A, new ArrayList<>(), ans);
        return ans;
    }
    public static void rootToLeavesString(TreeNode A, ArrayList<Integer> B, List<String> C) {
        if (A == null) {
            return;
        }
        B.add(A.val);
        rootToLeavesString(A.left, B, C);
        rootToLeavesString(A.right, B, C);
        
        if (A.left == null && A.right == null) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < B.size(); i++) {
                str.append(String.valueOf(B.get(i)));
                if (i < B.size() - 1) {
                    str.append("->");
                }
            }
            C.add(new String(str));
        }
        B.remove(B.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // List<List<Integer>> ans = new ArrayList<>();
        rootToLeaves(A, new ArrayList<>(), ans);
        return ans;
    }
    public static void rootToLeaves(TreeNode A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C) {
        if (A == null) {
            return;
        }
        B.add(A.val);
        rootToLeaves(A.left, B, C);
        rootToLeaves(A.right, B, C);
        
        if (A.left == null && A.right == null) {
            ArrayList<Integer> x = new ArrayList<>();
            x.addAll(B);
            C.add(x);
        }
        B.remove(B.size() - 1);
    }
}
