import java.util.ArrayList;
import java.util.HashMap;

public class BoundaryTraversal {
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
        // int[] a = { 1, 2, 3, 4, 5, -1, 7 };
        // int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        // ArrayList<Integer> A = new ArrayList<>();
        // for (int i = 0; i < a.length; i++)
        // A.add(a[i]);
        // TreeNode root = createTree(A);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(boundaryTraversal(root));
    }

    private static ArrayList<Integer> leftList = new ArrayList<>();
    private static ArrayList<Integer> rightList = new ArrayList<>();
    private static ArrayList<Integer> leaves = new ArrayList<>();
    public static ArrayList<Integer> boundaryTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        leftTraversal(A.left);
        rightTraversal(A.right);
        postOrder(A);
        result.add(A.val);
        for (int i = 0; i < leftList.size(); i++) {
            result.add(leftList.get(i));
        }
        for (int i = 0; i < leaves.size(); i++) {
            result.add(leaves.get(i));
        }
        for (int i = 0, len = rightList.size(); i < len / 2; i++) {
            int curr = rightList.get(i);
            int rev = rightList.get(len - 1 - i);
            rightList.set(i, rev);
            rightList.set(len - 1 - i, curr);
        }
        for (int i = 0, len = rightList.size(); i < len; i++) {
            result.add(rightList.get(i));
        }
        return result;
    }
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
    }
    public static void leftTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            leftList.add(root.val);
        }
        leftTraversal(root.left);
    }
    public static void rightTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            rightList.add(root.val);
        }
        rightTraversal(root.right);
    }

    public static ArrayList<Integer> boundaryTraversal1(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
        PairQueue q = new PairQueue(100000);
        q.enqueue(new Pair(0, A));
        ArrayList<Integer> rootList = new ArrayList<>();
        rootList.add(A.val);
        levelMap.put(0, rootList);

        while (!q.isEmpty()) {
            Pair front = q.dequeue();
            if (front != null) {
                ArrayList<Integer> innerList = new ArrayList<>();

                if (front.node.left != null) {
                    if (levelMap.containsKey(front.level + 1)) {
                        innerList = levelMap.get(front.level + 1);
                        innerList.add(front.node.left.val);
                    } else {
                        innerList.add(front.node.left.val);
                    }
                    q.enqueue(new Pair(front.level + 1, front.node.left));
                }

                if (front.node.right != null) {
                    if (levelMap.containsKey(front.level + 1)) {
                        innerList = levelMap.get(front.level + 1);
                        innerList.add(front.node.right.val);
                    } else {
                        innerList.add(front.node.right.val);
                    }
                    q.enqueue(new Pair(front.level + 1, front.node.right));
                }

                if (innerList.size() > 0) {
                    levelMap.put(front.level + 1, innerList);
                }
            }
        }
        int i = 0;
        while (levelMap.containsKey(i)) {
            ArrayList<Integer> innerList = levelMap.get(i);
            result.add(innerList.get(0));
            i++;
        }

        return result;
    }

    static class Pair {
        int level;
        TreeNode node;

        Pair(int _level, TreeNode _node) {
            this.level = _level;
            this.node = _node;
        }
    }

    static class PairQueue {
        int size = 0, len = 0, rear = -1, front = 0;
        Pair[] q;

        PairQueue(int n) {
            q = new Pair[n];
            len = n;
        }

        public void enqueue(Pair node) {
            if (isFull()) {
                System.out.println("ill op[e]");
                System.exit(1);
            }
            rear = (rear + 1) % len;
            size++;
            q[rear] = node;
        }

        public Pair dequeue() {
            if (isEmpty()) {
                System.out.println("ill op[d]");
                System.exit(1);
            }
            Pair temp = q[front];
            front = (front + 1) % len;
            size--;
            return temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == len;
        }
    }

    static class Queue {
        int length = 0;
        int size;
        int rear = -1;
        int front = 0;
        TreeNode[] q;

        Queue(int x) {
            q = new TreeNode[x];
            size = x;
        }

        public void enqueue(TreeNode x) {
            if (isFull()) {
                System.out.println("Illegal e");
                System.exit(1);
            }
            rear = (rear + 1) % size;
            length++;
            q[rear] = x;
        }

        public TreeNode dequeue() {
            if (isEmpty()) {
                System.out.println("Illegal d");
                System.exit(1);
            }
            TreeNode temp = q[front];
            front = (front + 1) % size;
            length--;
            return temp;
        }

        public boolean isFull() {
            return length == size;
        }

        public boolean isEmpty() {
            return length == 0;
        }
    }

    public static TreeNode createTree(ArrayList<Integer> A) {
        int len = A.size();
        Queue q = new Queue(len);
        TreeNode root = new TreeNode(A.get(0));
        q.enqueue(root);

        int i = 1;
        while (i < len) {
            TreeNode x = q.dequeue();
            int curr = A.get(i);
            if (curr != -1) {
                x.left = new TreeNode(curr);
                q.enqueue(x.left);
            }
            if (i + 1 < len) {
                int next = A.get(i + 1);
                if (next != -1) {
                    x.right = new TreeNode(next);
                    q.enqueue(x.right);
                }
            }
            i += 2;
        }
        return root;
    }
}
