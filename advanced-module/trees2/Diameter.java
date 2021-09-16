import java.util.ArrayList;

public class Diameter {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val=x;
            left=null;
            right=null;
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

    public static int solve(TreeNode A) {
        int ans = diameter(A);
        // getHeight(A);
        // int h = getH(A);
        // System.out.println("height: " + h);
        // return h;
        return ans;
    }
    private static int maxHeight = Integer.MIN_VALUE;
    public static int diameter(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int leftHeight = getH(A.left);
        int rightHeight = getH(A.right);
        diameter(A.left);
        diameter(A.right);
        int x = leftHeight + rightHeight;
        if (maxHeight < x) {
            maxHeight = x;
        }
        return maxHeight;
    }

    private static int height = 0;
    private static int max= Integer.MIN_VALUE;
    public static void getHeight(TreeNode A) {
        if (A == null) {
            return;
        }
        height++;
        if (max<height){
            max=height;
        }
        getHeight(A.left);
        getHeight(A.right);
        height--;
    }
    
    public static int getH(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int l = getH(A.left);
        int r = getH(A.right);
        return Integer.max(l, r) + 1;
    }

    public static void main(String args[]) {
        ArrayList<Integer> A= new ArrayList<>();
        // int[]a={1,2,3,4,5,6,7};
        int[]a={1,2,3,4,5,-1,-1,6,-1,8,-1,7,-1,9,-1,10,-1,-1,-1,-1,-1};
        // int[]a={11,9,6,17,23,7,-1,-1,-1,-1,-1,-1};
        for (int i = 0; i < a.length; i++)A.add(a[i]);
        TreeNode root = createTree(A);
        System.out.println("x: " + solve(root));
    }
}
