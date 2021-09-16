import java.util.ArrayList;

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

    public static ArrayList<Integer> boundaryTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        return result;
    }

    // public static 

    public static void main(String args[]) {
        int[] a = { 1, 2, 3, 4, 5, -1, 7 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        TreeNode root = createTree(A);
        System.out.println("root: " + root);
    }
}
