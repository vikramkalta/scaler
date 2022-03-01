import java.util.ArrayList;

public class FloorAndCeil {
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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        // root.right.left = new TreeNode(18);
        // root.right.right = new TreeNode(18);
        int[] arr = {4,19};
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            B.add(arr[i]);
        }
        System.out.println(solve(root, B));
    }

    public static ArrayList<ArrayList<Integer>> solve(TreeNode A, ArrayList<Integer> B) {
        int len = B.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int curr = B.get(i);
            ArrayList<Integer> innerList = new ArrayList<>();
            int low = traverseFloorBST(A, curr);
            innerList.add(low);
            int high = traverseCeilBST(A, curr);
            innerList.add(high);
            result.add(innerList);
        }
        return result;
    }

    public static int traverseFloorBST(TreeNode root, int num) {
        if (root == null) {
            return -1;
        }
        if (root.val < num && root.right == null) {
            return root.val;
        }
        // if (root.val < num && root.right.val > num) {
        //     return root.val;
        // }
        if (root.val < num && root.right != null && root.right.val > num) {
            return root.val;
        }
        if (root.val > num && root.left != null && root.left.val < num) {
            return root.left.val;
        }
        if (root.val > num) {
            return traverseFloorBST(root.left, num);
        } else if (root.val < num) {
            return traverseFloorBST(root.right, num);
        } else {
            return root.val;
        }
    }

    public static int traverseCeilBST(TreeNode root, int num) {
        if (root== null) {
            return -1;
        }
        if (root.val > num && root.left == null) {
            return root.val;
        }
        // if (root.val > num && root.left.val < num) {
        //     return root.val;
        // }
        if (root.val < num && root.right != null && root.right.val > num) {
            return root.right.val;
        }
        if(root.val > num && root.left != null && root.left.val < num) {
            return root.val;
        }
        if (root.val > num) {
            return traverseCeilBST(root.left, num);
        } else if (root.val < num) {
            return traverseCeilBST(root.right, num);
        } else {
            return root.val;
        }
    }

}