import java.util.ArrayList;

public class LeftView {
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
        int length;
        int size;
        TreeNode[] q;
        int rear = -1;
        int front = 0;

        Queue(int x) {
            size = x;
            q = new TreeNode[x];
        }

        public void enqueue(TreeNode x) {
            if (isFull()) {
                System.out.println("Error enq: " + x);
                System.exit(1);
            }
            rear = (rear + 1) % size;
            length++;
            q[rear] = x;
        }

        public TreeNode dequeue() {
            if (isEmpty()) {
                System.out.println("Error deq");
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

    static TreeNode createTree(ArrayList<Integer> A) {
        int len = A.size();
        Queue q = new Queue(len);
        TreeNode root = new TreeNode(A.get(0));
        q.enqueue(root);
        int i = 1;
        while (i < len) {
            TreeNode x = q.dequeue();
            int left = A.get(i);
            if (left != -1) {
                x.left = new TreeNode(left);
                q.enqueue(x.left);
            }

            if (i + 1 < len) {
                int right = A.get(i + 1);
                if (right != -1) {
                    x.right = new TreeNode(right);
                    q.enqueue(x.right);
                }
            }
            i += 2;
        }
        return root;
    }

    public static ArrayList<Integer> leftView(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        // preOrderTraversal(A, result);
        getLeftView(A, result);
        return result;
    }

    private static int height = 0;
    private static int MAX_HEIGHT = Integer.MIN_VALUE;
    public static ArrayList<Integer> getLeftView(TreeNode A, ArrayList<Integer> B) {
        if (A == null) {
            return B;
        }
        height++;
        if (height > MAX_HEIGHT) {
            MAX_HEIGHT = height;
            int val = A.val;
            B.add(val);
            // if (val != -1) {
            //     B.add(val);
            // }
        }

        getLeftView(A.left, B);
        getLeftView(A.right, B);
        height--;
        return B;
    }

    public static ArrayList<Integer> preOrderTraversal(TreeNode A, ArrayList<Integer> B) {
        if (A == null) {
            System.out.println("height: " + height);
            return B;
        }
        height++;
        preOrderTraversal(A.left, B);
        preOrderTraversal(A.right, B);
        height--;
        return B;
    }

    public static ArrayList<Integer> preOrder(TreeNode A, ArrayList<Integer> B) {
        if (A == null) {
            return B;
        }
        int x = A.val;
        if (x != -1) {
            B.add(x);
        }

        TreeNode left = A.left;
        preOrder(A.left, B);
        if (left == null || left.val == -1) {
            preOrder(A.right, B);
        }
        return B;
    }

    public static void main(String args[]) {
        // int[] a = {1,2,3,4,5,6,7,8,-1};
        // int[] a = {1,2,3,-1,4,-1,-1,-1,-1,-1,5};
        int[] a = { 1, 2, 3, -1, -1, 4, -1, -1, 5 };
        // int[] a= {9,6,17,23,7,-1,-1,-1,-1,-1,-1};
        // int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        TreeNode root = createTree(A);
        System.out.println(leftView(root));
    }
}
