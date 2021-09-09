import java.util.ArrayList;

public class PreInPost {
    TreeNode root;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    static class Queue {
        int size;
        int length = 0;
        int rear = -1;
        int front = 0;
        TreeNode[] q;
        Queue(int n) {
            size = n;
            q=new TreeNode[n];
        }
        public void enqueue(TreeNode x) {
            if (isFull()){
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
            length--;
            return temp;
        }
        public boolean isFull() {
            return size == length;
        }
        public boolean isEmpty() {
            return 0 == length;
        }
    }
    public static TreeNode levelOrder(ArrayList<Integer> A) {
        int len = A.size();
        Queue queue = new Queue(len);
        int a = A.get(0);
        TreeNode t = new TreeNode(a);
        queue.enqueue(t);
        int i = 1;
        while(i < len) {
            TreeNode _root = queue.dequeue();
            _root.left = new TreeNode(A.get(i));
            queue.enqueue(_root.left);
            if ((i + 1) < len) {
                _root.right = new TreeNode(A.get(i + 1));
                queue.enqueue(_root.right);
            }
            i+=2;
        }
        return t;
    }
    public static void preOrder(TreeNode A) {
        if (A == null) {
            return;
        }
        System.out.println("val: " + A.val);
        preOrder(A.left);
        preOrder(A.right);
    }

    public static int solve(ArrayList<Integer>A, ArrayList<Integer>B, ArrayList<Integer>C) {
        int len = A.size();
        TreeNode postIn = createTreeFromPostAndIn(B, C, new TreeNode(-1), 0, len - 1, 0, len - 1);
        TreeNode preIn = createTreeFromPreAndIn(B, A, new TreeNode(-1), 0, len - 1, 0, len - 1);
        int ans = preOrder(preIn, postIn);
        return ans;
    }

    public static int preOrder(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if ((A == null && B != null) || (A != null && B == null)) {
            return 0;
        }
        int x = A.val;
        int y = B.val;
        if (x != y) {
            return 0;
        }
        int left = preOrder(A.left, B.left);
        int right = preOrder(A.right, B.right);
        return left == right ? 1 : 0;
    }

    public static TreeNode createTreeFromPostAndIn(ArrayList<Integer> A, ArrayList<Integer> B, TreeNode _root, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart >= A.size()){
            return null;
        }
        if (inStart >= inEnd) {
            return new TreeNode(A.get(inStart));
        }
        int searchIndex = searchIndex(A, B, inStart, inEnd, postEnd);
        // _root = searchIndex == -1 ? new TreeNode(-1) : new TreeNode(A.get(searchIndex));
        _root = new TreeNode(A.get(searchIndex));
        TreeNode rootLeft = createTreeFromPostAndIn(A, B, _root, inStart, searchIndex - 1, postStart, searchIndex - 1);
        TreeNode rootRight = createTreeFromPostAndIn(A, B, _root, searchIndex + 1, postEnd, searchIndex, postEnd - 1);
        _root.left = rootLeft;
        _root.right = rootRight;
        return _root;
    }
    public static TreeNode createTreeFromPreAndIn(ArrayList<Integer> A, ArrayList<Integer> B, TreeNode _root, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart >= A.size()){
            return null;
        }
        if (inStart >= inEnd) {
            return new TreeNode(A.get(inStart));
        }
        int searchIndex = searchIndexPre(A, B, inStart, inEnd, preStart, preEnd);
        if (searchIndex == -1) {
            return null;
        }
        // _root = searchIndex == -1 ? new TreeNode(-1) : new TreeNode(A.get(searchIndex));
        _root = new TreeNode(A.get(searchIndex));
        TreeNode left = createTreeFromPreAndIn(A, B, _root, inStart, searchIndex - 1, preStart + 1, searchIndex);
        TreeNode right = createTreeFromPreAndIn(A, B, _root, searchIndex + 1, inEnd, searchIndex + 1, preEnd);
        _root.left = left;
        _root.right = right;
        return _root;
    }
    public static int searchIndex(ArrayList<Integer> A, ArrayList<Integer> B, int isStart, int inEnd, int postEnd) {
        int root = B.get(postEnd);
        int index = -1;
        for (int i = isStart; i <= inEnd; i++) {
            int curr = A.get(i);
            if (curr == root) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static int searchIndexPre(ArrayList<Integer> A, ArrayList<Integer> B, int start, int inEnd, int preStart, int end) {
        int rootEl = B.get(preStart);
        int index = -1;
        for (int i = start; i <= inEnd; i++) {
            int curr = A.get(i);
            if (curr == rootEl) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        // int[] pre = {1,2,4,5,3,6,7};
        // int[] pre = {17, 8, 7, 31, 22, 32};
        // int[] pre={3, 18, 26, 16, 5};
        int[] pre={45, 30, 37, 10, 41, 18, 15, 26, 46, 56};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < pre.length; i++) A.add(pre[i]);
        // int[] in = {4,2,5,1,6,3,7};
        // int[] in = {7, 8, 31, 17, 32, 22};
        // int[] in = {16, 5, 18, 3, 26};
        int[] in = {10, 37, 41, 30, 15, 18, 45, 46, 26, 56};
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < in.length; i++) B.add(in[i]);
        // int[] post = {4,5,2,6,7,3,1};
        // int[] post = {7, 31, 8, 32, 22, 17};
        // int[] post = {3, 16, 5, 18, 26};
        int[] post = {10, 41, 37, 15, 18, 30, 46, 56, 26, 45};
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < post.length; i++) C.add(post[i]);
        System.out.println(solve(A, B, C));
        // int[] a = {1,2,3,4,5,6,7};
        // ArrayList<Integer> A = new ArrayList<>();
        // for (int i = 0; i < a.length; i++) A.add(a[i]);
        // TreeNode t = levelOrder(A);
    }
}
