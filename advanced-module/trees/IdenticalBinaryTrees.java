import java.util.ArrayList;

public class IdenticalBinaryTrees {
    TreeNode root;
    IdenticalBinaryTrees(int x) {
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
        public boolean isFull(){
            return length == size;
        }
        public boolean isEmpty(){
            return length == 0;
        }
    }

    public static TreeNode levelOrder(ArrayList<Integer> A) {
        int len = A.size();
        Queue q = new Queue(len);
        TreeNode x = new TreeNode(A.get(0));
        q.enqueue(x);
        int i = 1;
        while(i < len) {
            TreeNode _root = q.dequeue();
            int left = A.get(i);
            _root.left = new TreeNode(left);
            q.enqueue(_root.left);
            if (i+1 < len) {
                int right = A.get(i+1);
                _root.right = new TreeNode(right);
                q.enqueue(_root.right);
            }
            i+=2;
        }
        return x;
    }

    public static int isSameTree(TreeNode A, TreeNode B) {
        int ans = preorder(A, B);
        return ans;
    }

    public static int preorder(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if ((A == null && B != null) || (A != null && B == null)) {
            return 0;
        }
        if (A.val != B.val) {
            return 0;
        }
        int x = preorder(A.left, B.left);
        int y = preorder(A.right, B.right);
        return x == y ? 1 : 0;
    }

    public static void main(String args[]) {
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {1,2,3,4,5,6};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++)A.add(a[i]);
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < b.length; i++)B.add(b[i]);
        TreeNode x = levelOrder(A);
        TreeNode y = levelOrder(B);
        System.err.println(isSameTree(x, y));
    }
}
