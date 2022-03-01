public class ConvertArrayToBST {
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
        int[] nums = { -10, -3, 0, 5, 9 };
        System.out.println(sortedArrayToBST(nums));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = generateBST(0, nums.length, nums);
        return root;
    }

    public static TreeNode generateBST(int l, int r, int[] nums) {
        if (l >= r) {
            return null;
        }
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = generateBST(l, m, nums);
        root.right = generateBST(m + 1, r, nums);
        return root;
    }
}