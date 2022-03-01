public class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
     * 
     *       8
     *   4      12
     * 2   6  10  14
     */
    public static void main(String args[]) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        BSTIterator bstIterator = new BSTIterator(root);
        while(bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }

    private static Stack stack = new Stack(100);
    public  BSTIterator(TreeNode root) {
        leftTraverser(root);
    }

    public static void leftTraverser(TreeNode node) {
        if (node == null) {
            return;
        }
        stack.push(node);
        leftTraverser(node.left);
    }

    /** @return whether we have a next smallest number */
    public static boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public static int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            leftTraverser(top.right);
        }
        return top.val;
    }

    static class Stack {
        int len = 0, size = 0;
        TreeNode[] stack;
        Stack(int n) {
            len = n;
            stack = new TreeNode[n];
        }
        public void push(TreeNode node) {
            if (isFull()) {
                System.out.println("ill op[push]");
                System.exit(1);
            }
            stack[size] = node;
            size++;
        }
        public TreeNode pop() {
            if (isEmpty()) {
                System.out.println("ill op[pop]");
                System.exit(1);
            }
            size--;
            TreeNode top = stack[size];
            return top;
        }
        public boolean isEmpty() {
            return size==0;
        }
        public boolean isFull() {
            return size==len;
        }
    }
}

/**
 * Your Solution will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) System.out.print(i.next());
 */