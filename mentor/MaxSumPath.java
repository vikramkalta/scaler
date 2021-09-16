import java.util.ArrayList;

public class MaxSumPath {
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

    static int max = 0;

    public static int findPath(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int sumLeft = findPath(A.left);
        int sumRight = findPath(A.right);

        int _sum = sumLeft + sumRight + A.val;
        if (max < _sum) {
            max = _sum;
        }
        return _sum;
    }

    static int globalMaxLength = Integer.MIN_VALUE;

    public static int findDiameter(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int leftLength = findDiameter(A.left);
        int rightLength = findDiameter(A.right);
        
        if( leftLength !=0 && rightLength !=0 ) {
            int localMaxLength = leftLength + rightLength + 1;
            if (globalMaxLength < localMaxLength) {
                globalMaxLength = localMaxLength;
            }
        }
        return Math.max(leftLength,rightLength) + 1;
    }

    static class Queue {
        int size = 0;
        int length = 0;
        int rear = -1;
        int front = 0;
        TreeNode[] q;

        Queue(int x) {
            q = new TreeNode[x];
            size = x;
        }

        public TreeNode dequeue() {
            if (isEmpty()) {
                System.out.print("Error");
                System.exit(1);
            }
            TreeNode temp = q[front];
            front = (front + 1) % size;
            length--;
            return temp;
        }

        public void enqueue(TreeNode x) {
            if (isFull()) {
                System.out.print("Error");
                System.exit(1);
            }
            rear = (rear + 1) % size;
            q[rear] = x;
            length++;
        }

        public boolean isFull() {
            return length == size;
        }

        public boolean isEmpty() {
            return length == 0;
        }
    }

    public static TreeNode levelTraversal(ArrayList<Integer> A) {
        int len = A.size();
        Queue q = new Queue(len);
        TreeNode x = new TreeNode(A.get(0));
        q.enqueue(x);
        int i = 1;
        while (i < len) {
            TreeNode _root = q.dequeue();
            int left = A.get(i);
            if (left == -1) {
                continue;
            }
            _root.left = new TreeNode(left);
            q.enqueue(_root.left);
            if (i + 1 < len) {
                int right = A.get(i + 1);
                // if (right == -1) {
                //     continue;
                // }
                _root.right = new TreeNode(right);
                q.enqueue(_root.right);
            }
            i += 2;
        }
        return x;
    }

    public static void main(String args[]) {
        int[] a = { 1, 2, 3, 1, 3, 5, 6, -1, -1, -1, -1, 7, 8, -1, 9 };
//         1
//     2     3
// 4       5    6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        // int[] a = { 1, 2, 3, 4,5,6,7 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        // TreeNode x = levelTraversal(A);
        // System.out.println(findPath(x));
        System.out.println(findDiameter(root));
    }
}

// private static int globalMaximumSum;

//   public static int findMaximumPathSum(TreeNode root) {
//     globalMaximumSum = Integer.MIN_VALUE;
//     findMaximumPathSumRecursive(root);
//     return globalMaximumSum;
//   }

//   private static int findMaximumPathSumRecursive(TreeNode currentNode) {
//     if (currentNode == null)
//       return 0;

//     int maxPathSumFromLeft = findMaximumPathSumRecursive(currentNode.left);
//     int maxPathSumFromRight = findMaximumPathSumRecursive(currentNode.right);

//     // ignore paths with negative sums, since we need to find the maximum sum we should
//     // ignore any path which has an overall negative sum.
//     maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
//     maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

//     // maximum path sum at the current node will be equal to the sum from the left subtree +
//     // the sum from right subtree + val of current node
//     int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.val;

//     // update the global maximum sum
//     globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

//     // maximum sum of any path from the current node will be equal to the maximum of 
//     // the sums from left or right subtrees plus the value of the current node
//     return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.val;
//   }