public class MergeTwoBST {
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
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(3);
        A.right = new TreeNode(8);
        TreeNode B = new TreeNode(7);
        B.left = new TreeNode(2);
        B.right = new TreeNode(9);
        System.out.println(solve(A, B));
    }

    static Stack stackA = new Stack(10000);
    static Stack stackB = new Stack(10000);
    public static int[] solve(TreeNode A, TreeNode B) {
        int[] ans = new int[100000000];
        // int[] ans = new int[10];
        leftTraverser(A, stackA);
        leftTraverser(B, stackB);

        int i = 0;
        TreeNode a = getNext(stackA);
        TreeNode b = getNext(stackB);

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (a.val < b.val) {
                ans[i] = a.val;
                a = getNext(stackA);
            } else {
                ans[i] = b.val;
                b = getNext(stackB);
            }
            i++;
        }
        if (a.val < b.val) {
            ans[i] = a.val;
            ans[i+1] = b.val;
        } else {
            ans[i] = b.val;
            ans[i+1] = a.val;
        }
        i+=2;
        while (hasNext(stackA)) {
            TreeNode x = getNext(stackA);
            ans[i] = x.val;
            i++;
        }
        while(hasNext(stackB)) {
            TreeNode x = getNext(stackB);
            ans[i] = x.val;
            i++;
        }
        int[] result = new int[i];
        for (int ind = 0; ind < i; ind++) {
            result[ind] = ans[ind];
        }
        return result;
    }
    public static TreeNode getNext(Stack s) {
        TreeNode top = s.pop();
        if (top.right != null) {
            leftTraverser(top.right, s);
        }
        return top;
    }
    public static boolean hasNext(Stack s) {
        return !s.isEmpty();
    }
    public static void leftTraverser(TreeNode A, Stack s) {
        if (A == null) {
            return;
        }
        s.push(A);
        leftTraverser(A.left, s);
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
                System.out.println("err_push");
                System.exit(1);
            }
            top++;
            stack[top] = n;
        }
        public TreeNode pop() {
            if (isEmpty()) {
                System.out.println("err_pop");
                System.exit(1);
            }
            TreeNode temp = stack[top];
            top--;
            return temp;
        }
        public boolean isFull() {
            return top == len - 1;
        }
        public boolean isEmpty() {
            return top == -1;
        }
    }
}
