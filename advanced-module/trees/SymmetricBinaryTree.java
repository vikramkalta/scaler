import java.util.ArrayList;

public class SymmetricBinaryTree {
    TreeNode root;

    SymmetricBinaryTree(int x) {
        root = new TreeNode(x);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    static class Queue {
        int size;
        TreeNode[] q;
        int length=0;
        int rear = -1;
        int front= 0;
        Queue(int n) {
            q=new TreeNode[n];
            size=n;
        }
        public void enqueue(TreeNode x) {
            if (isFull()){
                System.out.println("Full");
                System.exit(1);
            }
            rear = (rear + 1) % size;
            q[rear]=x;
            length++;
        }
        public TreeNode dequeue() {
            if (isEmpty()){
                System.out.println("Empty");
                System.exit(1);
            }
            TreeNode temp = q[front];
            front = (front + 1) % size;
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
    
    public static TreeNode levelOrder(ArrayList<Integer> A) {
        int len = A.size();
        Queue q = new Queue(len);
        TreeNode x = new TreeNode(A.get(0));
        q.enqueue(x);
        int i = 1;
        while(i < len) {
            TreeNode y = q.dequeue();
            y.left = new TreeNode(A.get(i));
            q.enqueue(y.left);
            if (i+1 < len) {
                y.right = new TreeNode(A.get(i + 1));
                q.enqueue(y.right);
            }
            i+=2;
        }
        return x;
    }

    public static int isSymmetric1(TreeNode A) {
        ArrayList<Integer> result = inorder(A, new ArrayList<>());
        int len = result.size();

        for (int i = 0; i < len / 2; i++) {
            int curr = result.get(i);
            int rev= result.get(len-i-1);
            if (curr!=rev){
                return 0;
            }
        }
        return 1;
    }
    public static int isSymmetric(TreeNode A) {
        boolean ans = isMirror(A.left, A.right);
        return ans == true ? 1 : 0;
    }

    public static boolean isMirror(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 != null) || (root2 == null && root1 != null)) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val!=root2.val){
            return false;
        }
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public static ArrayList<Integer> inorder(TreeNode A, ArrayList<Integer> B) {
        if (A == null) {
            return B;
        }
        inorder(A.left, B);
        System.out.println("x: " + A.val);
        B.add(A.val);
        inorder(A.right, B);
        return B;
    }

    public static void main(String args[]) {
        int[] arr = {1,2,2,3,4,4,3};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // SymmetricBinaryTree x = new SymmetricBinaryTree(A.get(0));
        // TreeNode x = new TreeNode(A.get(0));
        TreeNode x = levelOrder(A);
        // System.out.println("x"+x);
        System.out.println(isSymmetric(x));
    }
}
