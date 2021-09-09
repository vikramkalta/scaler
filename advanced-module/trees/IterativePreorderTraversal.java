import java.util.ArrayList;

public class IterativePreorderTraversal {
    TreeNode root;
    IterativePreorderTraversal(int data) {
        root = new TreeNode(data);
    }

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

    static class Stack {
        int size;
        TreeNode[] stack;
        int length = 0;

        Stack(int n) {
            stack = new TreeNode[n];
            size = n;
        }

        public void push(TreeNode x) {
            if (isFull()) {
                System.out.println("Full");
                System.exit(1);
            }
            stack[length] = x;
            length++;
        }

        public TreeNode pop() {
            if (isEmpty()) {
                System.out.println("empty");
                System.exit(1);
            }
            TreeNode temp = stack[length - 1];
            length--;
            return temp;
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public boolean isFull() {
            return length == size;
        }
    }

    public static void insert(TreeNode root, int data) {
        if (root.val > data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new TreeNode(data);
            }
        } else {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new TreeNode(data);
            }
        }
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack stack = new Stack(100000);
        TreeNode temp = A;
        while(temp!=null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                result.add(temp.val);
                temp = temp.left;
            }else{
                TreeNode x = stack.pop();
                temp = x.right;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        // int[] arr = {1,2,3,-1,-1,4,-1,-1,5,-1,-1};
        // int[] arr = {1,2,3,4,5};
        // int[] arr = {1,3,2,5,4};
        int[]arr={5,3,8,2,4,7,9};
        // ArrayList<Integer> A = new ArrayList<>();
        IterativePreorderTraversal t = new IterativePreorderTraversal(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            // A.add(arr[i]);
            insert(t.root, arr[i]);
        }
        System.out.println(preorderTraversal(t.root));
    }
}
