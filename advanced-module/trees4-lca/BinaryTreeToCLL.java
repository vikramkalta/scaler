public class BinaryTreeToCLL {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(solve(root));
    }

    public static TreeNode cllRoot;
    public static TreeNode last;

    public static TreeNode solve(TreeNode root) {
        inorder(root);
        return cllRoot;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        if (last == null) {
            cllRoot = root;
        } else {
            root.left = last;
            last.right = root;
        }
        last = root;

        inorder(root.right);
    }

    static class Holder {
        TreeNode head;
        TreeNode tail;
    }

    public static TreeNode solve1(TreeNode root) {
        Holder holder = new Holder();
        helper(root, holder);
        if (holder.tail != null && holder.head != null) {
            holder.tail.right = holder.head;
            holder.head.left = holder.tail;
        }
        return holder.head;
    }

    public static void helper(TreeNode root, Holder holder) {
        if (root == null)
            return;
        helper(root.left, holder);
        if (holder.head == null) {
            holder.head = root;
        } else {
            holder.tail.right = root;
            root.left = holder.tail;
        }
        holder.tail = root;
        helper(root.right, holder);
    }
}