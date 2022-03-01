import java.util.ArrayList;

public class FloorAndCeil2 {
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
        // TreeNode root = new TreeNode(10);
        // root.left = new TreeNode(4);
        // root.right = new TreeNode(15);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(8);
        // root.right.left = new TreeNode(18);
        // root.right.right = new TreeNode(18);
        // TreeNode root = new TreeNode(14);
        // root.left = new TreeNode(8);
        // root.right = new TreeNode(21);
        // root.left.left = new TreeNode(5);
        // root.left.right = new TreeNode(10);
        // root.right.left = new TreeNode(17);
        // root.right.right = new TreeNode(24);
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        // int[] arr = {1,2,3};
        int[] arr = { 11, 21, 13 };
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            B.add(arr[i]);
        }
        System.out.println(solve(root, B));
    }

    private static int ceil = -1;
    private static int ceilDiff = Integer.MAX_VALUE;
    private static int floor = -1;
    private static int floorDiff = Integer.MAX_VALUE;

    public static ArrayList<ArrayList<Integer>> solve(TreeNode A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int len = B.size();
        for (int i = 0; i < len; i++) {
            // ceil = -1;
            ceilDiff = Integer.MAX_VALUE;
            // floor = -1;
            floorDiff = Integer.MAX_VALUE;
            int curr = B.get(i);
            ArrayList<Integer> innerList = new ArrayList<>();
            floor = traverseFloorBST(A, curr);
            innerList.add(floor);
            ceil = traverseCeilBST(A, curr);
            innerList.add(ceil);
            result.add(innerList);
        }
        return result;
    }

    public static int traverseCeilBST(TreeNode A, int num) {
        if (A == null) {
            return ceil != -1 ? ceil : -1;
        }
        if (A.val > num) {
            int diff = A.val - num;
            if (ceilDiff > diff) {
                ceilDiff = diff;
                ceil = A.val;
            }
            if (diff == -1) {
                ceil = diff;
            }
            return traverseCeilBST(A.left, num);
        } else if (A.val < num) {
            return traverseCeilBST(A.right, num);
        } else {
            ceilDiff = 0;
            ceil = A.val;
            return A.val;
        }
    }

    public static int traverseFloorBST(TreeNode A, int num) {
        if (A == null) {
            return floor != -1 ? floor : -1;
        }
        if (A.val > num) {
            return traverseFloorBST(A.left, num);
        } else if (A.val < num) {
            int diff = num - A.val;
            if (floorDiff > diff) {
                floorDiff = diff;
                floor = A.val;
            }
            return traverseFloorBST(A.right, num);
        } else {
            floorDiff = 0;
            floor = A.val;
            return A.val;
        }
    }

    public static int traverseCeilBST1(TreeNode A, int num) {
        if (A == null) {
            return -1;
        }
        if (A.val > num) {
            if (A.left != null && A.left.val < num) {
                return A.val;
            }
            if (A.left == null) {
                return A.val;
            }
            return traverseCeilBST(A.left, num);
        } else if (A.val < num) {
            if (A.right != null && A.right.val > num) {
                return A.right.val;
            }
            return traverseCeilBST(A.right, num);
        } else {
            return A.val;
        }
    }

    public static int traverseFloorBST1(TreeNode A, int num) {
        if (A == null) {
            return -1;
        }
        if (A.val > num) {
            if (A.left != null && A.left.val < num) {
                return A.left.val;
            }
            return traverseFloorBST(A.left, num);
        } else if (A.val < num) {
            if (A.right != null && A.right.val > num) {
                return A.val;
            }
            if (A.right == null) {
                return A.val;
            }
            return traverseFloorBST(A.right, num);
        } else {
            return A.val;
        }
    }
}