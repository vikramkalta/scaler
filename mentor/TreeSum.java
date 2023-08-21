import java.util.ArrayList;
import java.util.List;

public class TreeSum {
    TreeNode root;

    TreeSum(int x) {
        root = new TreeNode(x);
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

    static class Queue {
        int size;
        TreeNode[] q;
        int rear = -1;
        int front = 0;
        int length = 0;

        Queue(int x) {
            size = x;
            q = new TreeNode[x];
        }

        public void enqueue(TreeNode x) {
            if (isFull()) {
                System.out.println("Full");
                System.exit(1);
            }
            rear = (rear + 1) % size;
            q[rear] = x;
            length++;
        }

        public TreeNode dequeue() {
            if (isEmpty()) {
                System.out.println("Empty");
                System.exit(1);
            }
            TreeNode temp = q[front];
            front = (front + 1) % size;
            return temp;
        }

        public boolean isFull() {
            return length == size;
        }

        public boolean isEmpty() {
            return length == 0;
        }
    }

    public static TreeNode levelOrder(ArrayList<Integer> A) {
        int len = A.size();
        Queue q = new Queue(len);
        TreeNode x = new TreeNode(A.get(0));
        q.enqueue(x);
        int i = 1;
        while (i < len) {
            TreeNode _root = q.dequeue();
            int left = A.get(i);
            _root.left = new TreeNode(left);
            q.enqueue(_root.left);
            if (i + 1 < len) {
                int right = A.get(i + 1);
                _root.right = new TreeNode(right);
                q.enqueue(_root.right);
            }
            i += 2;
        }
        return x;
    }

    public static boolean recur(TreeNode A, int S, int sum) {
        if (A == null) {
            System.out.println("A:" + sum);
            if (sum == S) {
                return true;
            }
            return false;
        }
        // int x = y + recur(A.left, S, sum, A.val);
        int x = sum + A.val;
        recur(A.left, S, x);
        recur(A.right, S, sum);
        sum = sum + A.val;
        // recur(A.right, S, sum);
        int z = sum + A.val;
        return x + z == S;
    }

    public static boolean hasPath(TreeNode A, int S) {
        if (A == null) {
            return false;
        }
        if (A.val == S && A.left == null && A.right == null) {
            return true;
        }
        return hasPath(A.left, S - A.val) || hasPath(A.right, S - A.val);
    }

    public static void isSum(TreeNode A, int S, int[] B, int index) {
        if (A == null) {
            return;
        }
        if (A.val == S && A.left == null && A.right == null) {
            System.out.println("B: " + B);
            return;
        }
        B[index] = A.val;
        isSum(A.left, S - A.val, B, index + 1);
        B[index] = A.val;
        isSum(A.right, S - A.val, B, index + 1);
    }

    private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
            List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;

        currentPath.add(currentNode.val);
        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String args[]) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        // ArrayList<Integer> B = new ArrayList<>();
        TreeNode x = levelOrder(A);
        // System.out.println(hasPath(x, 10));
        int[] b = new int[a.length];
        // System.out.println(isSum(x, 10, b, 0));
        isSum(x, 10, b, 0);
    }
}