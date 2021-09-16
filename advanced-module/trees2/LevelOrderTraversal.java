import java.util.ArrayList;
import java.util.HashMap;

public class LevelOrderTraversal {
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

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, ArrayList<TreeNode>> hm = new HashMap<>();
        createHashmap(hm, A);
        ArrayList<TreeNode> root = hm.get(1);
        result.add(root.get(0).val);
        for (int i = 2; i <= max+1; i++) {
            ArrayList<TreeNode> nodeList = hm.get(i);

            int nodeListLen = nodeList.size();
            for (int j = 0; j < nodeListLen; j++) {
                TreeNode currNode = nodeList.get(j);
                result.add(currNode.val);
            }
        }

        return result;
    }

    private static int height = 0;
    private static int max = Integer.MIN_VALUE;

    public static HashMap<Integer, ArrayList<TreeNode>> createHashmap(HashMap<Integer, ArrayList<TreeNode>> hm,
            TreeNode A) {
        if (A == null) {
            if (hm.containsKey(height+1)){
                ArrayList<TreeNode> x = hm.get(height+1);
                x.add(new TreeNode(-1));
                hm.put(height+1, x);
            }else{
                ArrayList<TreeNode> x = new ArrayList<>();
                x.add(new TreeNode(-1));
                hm.put(height+1, x);
            }
            return hm;
        }
        height++;
        if (height > max) {
            max = height;
        }
        if (hm.containsKey(height)) {
            ArrayList<TreeNode> x = hm.get(height);
            x.add(A);
            hm.put(height, x);
        } else {
            ArrayList<TreeNode> x = new ArrayList<>();
            x.add(A);
            hm.put(height, x);
        }

        createHashmap(hm, A.left);
        createHashmap(hm, A.right);
        height--;
        return hm;
    }

    public static ArrayList<Integer> levelOrder(TreeNode A, ArrayList<Integer> B) {
        if (A == null) {
            return B;
        }
        return B;
    }

    public static void main(String args[]) {
        int[] a = { 1, 2, 3, 4, 5, -1, -1, -1, -1, -1, 6, -1, -1 };
        // int[] a = { 1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1 };
        // int[] a= {9,6,17,23,7,-1,-1,-1,-1,-1,-1};
        // int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        TreeNode root = createTree(A);
        System.out.println(solve(root));
    }
}
