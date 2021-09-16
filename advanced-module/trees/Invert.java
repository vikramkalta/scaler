import java.util.ArrayList;

public class Invert {
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
        Queue(int x){
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
        while(i < len) {
            TreeNode x = q.dequeue();
            int left = A.get(i);
            x.left = new TreeNode(left);
            q.enqueue(x.left);
            if (i + 1 < len) {
                int right = A.get(i+1);
                x.right = new TreeNode(right);
                q.enqueue(x.right);
            }
            i+=2;
        }
        return root;
    }

    public static TreeNode invert(TreeNode A) {
        TreeNode ans = inOrder(A);
        return ans;
    }

    public static TreeNode inOrder(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode left = inOrder(A.left);
        TreeNode right = inOrder(A.right);
        A.right = left;
        A.left = right;
        return A;
    }

    public static void main(String args[]) {
        int[] a = {1,2,3,4,5,6,7};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) A.add(a[i]);
        TreeNode root = createTree(A);
        System.out.println("root: " + root);
        System.out.println(invert(root));
    }
}
