import java.util.HashMap;

public class EqualPartition {
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(solve(root));
    }
    public static int solve(TreeNode A) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = sum(A, sumMap);
        if (sum % 2 != 0) {
            return 0;
        }
        int halfSum = sum / 2;
        if (sumMap.containsKey(halfSum)) {
            return 1;
        }
        return 0;
    }
    public static int sum(TreeNode A, HashMap<Integer, Integer> sumMap) {
        if (A == null) {
            return 0;
        }
        int left = sum(A.left, sumMap);
        int right = sum(A.right, sumMap);
        sumMap.put(left + right + A.val, 1);
        return left + right + A.val;
    }
    
    // public static void sumLeft(TreeNode A, int halfSum) {
    //     if (A == null) {
    //         return;
    //     }
    //     runningSum += A.val;
    //     if (runningSum == halfSum) {
    //         isFound = 1;
    //         return;
    //     }
    //     sumLeft(A.left, halfSum);
    //     sumLeft(A.right, halfSum);
    // }
}
