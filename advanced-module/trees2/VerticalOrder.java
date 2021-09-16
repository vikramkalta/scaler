import java.util.ArrayList;
import java.util.HashMap;

public class VerticalOrder {
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

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<TreeNode>> B = new HashMap<>();
        breadth(A, B);
        System.out.println("breadth: " + breadth);
        for (int i = 1; i <= max; i++) {
            ArrayList<TreeNode> currNodes = B.get(i);
            int currNodesLen = currNodes.size();
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = currNodesLen - 1; j >= 0; j--) {
                int curr = currNodes.get(j).val;
                innerArr.add(curr);
            }
            result.add(innerArr);
        }
        return result;
    }

    private static int breadth = 0;
    // private static int max = Integer.MIN_VALUE;
    public static HashMap<Integer, ArrayList<TreeNode>> breadth(TreeNode A, HashMap<Integer, ArrayList<TreeNode>> B) {
        if (A == null) {
            return B;
        }
        TreeNode x = A;
        breadth(A.left, B);
        if (x.left != null && x.left.right != null) {
            System.out.println("x");
        } 
        else if ((x.right != null && x.right.left != null)) {
            System.out.println("y");
        }
        else {
            breadth++;
        }
        
        if (max < breadth) {
            max = breadth;
        }
        if (B.containsKey(breadth)) {
            ArrayList<TreeNode> curr = B.get(breadth);
            curr.add(new TreeNode(A.val));
            B.put(breadth, curr);
        }else{
            ArrayList<TreeNode> curr = new ArrayList<>();
            curr.add(new TreeNode(A.val));
            B.put(breadth, curr);
        }
        breadth(A.right, B);
        return B;
    }
   
    public static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<TreeNode>> B = new HashMap<>();
        vertical(A, B, 0);

        for (int i = min; i <= max; i++) {
            ArrayList<TreeNode> x = B.get(i);
            int xLen = x.size();
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < xLen; j++) {
                int curr = x.get(j).val;
                innerArr.add(curr);
            }
            result.add(innerArr);
        }

        return result;
    }

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    public static HashMap<Integer, ArrayList<TreeNode>> vertical(TreeNode A, HashMap<Integer, ArrayList<TreeNode>> B, int x) {
        if (A == null) {
            return B;
        }
        if (max < x) {
            max = x;
        }
        if (min > x) {
            min = x;
        }
        if (B.containsKey(x)) {
            ArrayList<TreeNode> y = B.get(x);
            y.add(A);
            B.put(x, y);
        }else{
            ArrayList<TreeNode> y = new ArrayList<>();
            y.add(A);
            B.put(x, y);
        }
        vertical(A.left, B, x-1);
        vertical(A.right, B, x+1);
        return B;
    }

    public static void main(String args[]) {
        // int[] a = { 1, 2, 3, 4, 5, -1, -1, -1, -1, -1, 6, -1, -1 };
        // int[] a = { 1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1 };
        int[] a = {1,2,3,4,5,6,7};
        // int[] a = { 6, 3, 7, 2, 5, -1, 9 };
        // int[] a = {818,-1,2510,212,-1,-1,9881};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        TreeNode root = createTree(A);
        // System.out.println(verticalOrderTraversal(root));
        System.out.println(solve(root));
    }
}
