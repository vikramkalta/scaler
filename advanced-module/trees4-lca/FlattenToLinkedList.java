public class FlattenToLinkedList {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(3);
        // root.right = new TreeNode(7);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(6);
        // root.right.left = new TreeNode(5);
        // root.right.right = new TreeNode(6);
        // System.out.println(solve(root));
        flatten(root);
        System.out.println();
    }
    
    public static TreeNode flatten(TreeNode a) {
        TreeNode temp = new TreeNode(-1);
        TreeNode ans = temp;
        Stack s = new Stack(100000);
        leftTraverser(a, s, temp);
        return ans.right;
    }
    public static void leftTraverser(TreeNode root, Stack s, TreeNode temp) {
        if (root == null) {
            while (!s.isEmpty()) {
                TreeNode top = s.pop();
                if (top.right != null) {
                    leftTraverser(top.right, s, temp);
                }
            }
            return;
        }
        s.push(root);
        temp.left = null;
        temp.right = new TreeNode(root.val);
        leftTraverser(root.left, s, temp.right);
    }
    
    static class Stack {
        int len = 0;
        int top = -1;
        TreeNode[] stack;
        Stack(int n) {
            len = n;
            stack = new TreeNode[n];
        }
        public void push(TreeNode n) {
            if (isFull()) {
                System.out.println("err push");
                System.exit(1);
            }
            top++;
            stack[top]=n;
        }
        public TreeNode pop() {
            if (isEmpty()) {
                System.out.println("err pop");
                System.exit(1);
            }
            TreeNode temp = stack[top];
            top--;
            return temp;
        }
        public boolean isEmpty() {
            return top == -1;
        }
        public boolean isFull() {
            return top == len - 1;
        }
    }
}
