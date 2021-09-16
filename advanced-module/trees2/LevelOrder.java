import java.util.ArrayList;
import java.util.HashMap;

public class LevelOrder {
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

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        HashMap<Integer, ArrayList<TreeNode>> B = new HashMap<>();
        level(A, B);
        ArrayList<TreeNode> rootNode = B.get(1);
        ArrayList<Integer> root = new ArrayList<>();
        root.add(rootNode.get(0).val);
        result.add(root);

        for (int i = 2; i <= max; i++) {
            ArrayList<TreeNode> currNodeList = B.get(i);
            int currNodeLen = currNodeList.size();
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < currNodeLen; j++) {
                int curr = currNodeList.get(j).val;
                innerArr.add(curr);
            }
            result.add(innerArr);
        }
        return result;
    }
    private static int height = 0;
    private static int max = Integer.MIN_VALUE;
    public static HashMap<Integer, ArrayList<TreeNode>> level(TreeNode A, HashMap<Integer, ArrayList<TreeNode>> B) {
        if (A==null){
            return B;
        }
        height++;
        if (max < height){
            max = height;
        }
        if (B.containsKey(height)) {
            ArrayList<TreeNode> x = B.get(height);
            x.add(A);
            B.put(height, x);
        }else{
            ArrayList<TreeNode> x = new ArrayList<>();
            x.add(A);
            B.put(height, x);
        }
        level(A.left, B);
        level(A.right, B);
        height--;
        return B;
    }
    public static void main(String args[]) {
        int[] a = { 3, 9, 20, -1, -1, 15, 7 };
        // int[] a = { 1, 2, 3, 4, 5, -1, -1, -1, -1, -1, 6, -1, -1 };
        // int[] a = { 1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1 };
        // int[] a= {9,6,17,23,7,-1,-1,-1,-1,-1,-1};
        // int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        TreeNode root = createTree(A);
        System.out.println(levelOrder(root));
    }
}
