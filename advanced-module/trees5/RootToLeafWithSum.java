import java.util.ArrayList;
import java.util.List;

public class RootToLeafWithSum {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        rootToLeavesLeetcode(root, new ArrayList<>(), ans, targetSum, 0);
        return ans;
    }
    public static void rootToLeavesLeetcode(TreeNode A, ArrayList<Integer> B, List<List<Integer>> C, int sum, int x) {
        if (A == null) {
            return;
        }
        B.add(A.val);
        x += A.val;
        rootToLeavesLeetcode(A.left, B, C, sum, x);
        rootToLeavesLeetcode(A.right, B, C, sum, x);

        if (A.left == null && A.right == null && x == sum) {
            ArrayList<Integer> y = new ArrayList<>();
            y.addAll(B);
            C.add(y);
        }
        B.remove(B.size() - 1);
        x -= A.val;
    }

    public static ArrayList<ArrayList<Integer>> solve(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        rootToLeaves(A, new ArrayList<>(), ans, B, 0);
        return ans;
    }

    public static void rootToLeaves(TreeNode A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int sum, int x) {
        if (A == null) {
            return;
        }
        B.add(A.val);
        x += A.val;
        rootToLeaves(A.left, B, C, sum, x);
        rootToLeaves(A.right, B, C, sum, x);

        if (A.left == null && A.right == null && x == sum) {
            ArrayList<Integer> y = new ArrayList<>();
            y.addAll(B);
            C.add(y);
        }
        B.remove(B.size() - 1);
        x -= A.val;
    }
}
