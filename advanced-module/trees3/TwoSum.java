import java.util.ArrayList;

public class TwoSum {
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
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        System.out.println(findTarget(root, 24));
    }

    public static boolean findTarget(TreeNode root, int k) {
        Stack leftStack = new Stack(100);
        leftTraverser(root, leftStack);
        Stack rightStack = new Stack(100);
        rightTraverser(root, rightStack);

        TreeNode left = nextLeft(leftStack);
        TreeNode right = nextRight(rightStack);
        while(left.val < right.val) {
            int target = left.val + right.val;
            if (target < k) {
                left = nextLeft(leftStack);
            } else if (target > k) {
                right = nextRight(rightStack);
            } else {
                return true;
            }
        }
        return false;
    }

    public static TreeNode nextLeft(Stack stack) {
        TreeNode top = stack.pop();
        if (top.right != null) {
            leftTraverser(top.right, stack);
        }
        return top;
    }

    public static TreeNode nextRight(Stack stack) {
        TreeNode top = stack.pop();
        if (top.left != null) {
            rightTraverser(top.left, stack);
        }
        return top;
    }

    public static void leftTraverser(TreeNode root, Stack stack) {
        if (root == null) {
            return;
        }
        stack.push(root);
        leftTraverser(root.left, stack);
    }

    public static void rightTraverser(TreeNode root, Stack stack) {
        if (root == null) {
            return;
        }
        stack.push(root);
        rightTraverser(root.right, stack);
    }

    public static boolean findTarget1(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int currLow = list.get(low);
            int currHigh = list.get(high);
            int target = currLow + currHigh;
            if (target < k) {
                low++;
            } else if (target > k) {
                high--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    static class Stack {
        int len = 0, size = 0;
        TreeNode[] stack;

        Stack(int n) {
            stack = new TreeNode[n];
            len = n;
        }

        public void push(TreeNode n) {
            if (isFull()) {
                System.out.println("ill op[push]");
                System.exit(1);
            }
            stack[size] = n;
            size++;
        }

        public TreeNode pop() {
            if (isEmpty()) {
                System.out.println("ill op[pop]");
                System.exit(1);
            }
            size--;
            TreeNode temp = stack[size];
            return temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == len;
        }
        public TreeNode top() {
            return stack[size - 1];
        }
    }
}
