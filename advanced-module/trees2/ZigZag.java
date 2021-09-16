import java.util.ArrayList;

public class ZigZag {
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

    public static ArrayList<ArrayList<Integer>> zigzagTrav(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue q = new Queue(100000);
        q.enqueue(A);
        ArrayList<Integer> rootArr = new ArrayList<>();
        rootArr.add(A.val);
        result.add(rootArr);

        int i = 0;
        while (!q.isEmpty()) {

            ArrayList<TreeNode> inner = new ArrayList<>();
            ArrayList<Integer> intArr = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode xNode = q.dequeue();
                if (i % 2 == 0) {
                    if (xNode.right != null) {
                        inner.add(xNode.right);
                        intArr.add(xNode.right.val);
                    }
                    if (xNode.left != null) {
                        inner.add(xNode.left);
                        intArr.add(xNode.left.val);
                    }
                } else {
                    if (xNode.left != null) {
                        inner.add(xNode.left);
                        intArr.add(xNode.left.val);
                    }
                    if (xNode.right != null) {
                        inner.add(xNode.right);
                        intArr.add(xNode.right.val);
                    }
                }
            }
            int len = inner.size();
            for (int x = len - 1; x >= 0; x--) {
                TreeNode curNode = inner.get(x);
                q.enqueue(curNode);
            }
            // if (i % 2 == 0) {
            //     for (int x = len - 1; x >= 0; x--) {
            //         TreeNode curNode = inner.get(x);
            //         q.enqueue(curNode);
            //     }
            // } else {
            //     for (int x = 0; x < len; x++) {
            //         TreeNode currNode = inner.get(x);
            //         q.enqueue(currNode);
            //     }
            // }
            if (intArr.size() > 0)
                result.add(intArr);
            i++;
        }

        return result;
    }

    public static ArrayList<ArrayList<Integer>> levelOrder2d(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue q = new Queue(100000);
        q.enqueue(A);
        ArrayList<Integer> rootArr = new ArrayList<>();
        rootArr.add(A.val);
        result.add(rootArr);

        while (!q.isEmpty()) {

            ArrayList<TreeNode> inner = new ArrayList<>();
            ArrayList<Integer> intArr = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode xNode = q.dequeue();
                if (xNode.left != null) {
                    inner.add(xNode.left);
                    intArr.add(xNode.left.val);
                }
                if (xNode.right != null) {
                    inner.add(xNode.right);
                    intArr.add(xNode.right.val);
                }
            }
            int len = inner.size();
            for (int x = 0; x < len; x++) {
                TreeNode currNode = inner.get(x);
                q.enqueue(currNode);
            }
            result.add(intArr);
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue q = new Queue(100000);
        q.enqueue(A);

        ArrayList<Integer> levelOrder = new ArrayList<>();
        levelOrder.add(A.val);

        while (!q.isEmpty()) {
            TreeNode root = q.dequeue();
            TreeNode left = root.left;
            if (left != null) {
                levelOrder.add(left.val);
                q.enqueue(left);
            }

            TreeNode right = root.right;
            if (right != null) {
                levelOrder.add(right.val);
                q.enqueue(right);
            }
        }
        System.out.println(levelOrder);
        return result;
    }

    public static ArrayList<ArrayList<Integer>> zigzagTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int h = getH(A);
        for (int i = 0; i < h; i++) {
            result.add(new ArrayList<>());
        }
        zigzag(A, result);
        return result;
    }

    private static int getH(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int l = getH(A.left);
        int r = getH(A.right);
        return Integer.max(l, r) + 1;
    }

    private static int h = 0;

    public static ArrayList<ArrayList<Integer>> zigzag(TreeNode A, ArrayList<ArrayList<Integer>> B) {
        if (A == null) {
            return B;
        }
        // System.out.println("x: " + A.val);
        h++;
        B.get(h - 1).add(A.val);
        zigzag(A.right, B);
        zigzag(A.left, B);
        h--;
        return B;
    }

    public static void main(String args[]) {
        // int[] a = { 1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15 };
        int[] a = { 129, 97, 98, 93, 106, 27, 61, -1, 173, 40, 78, 22, 152, 99, 114, 47, 69, -1, -1, 110, 144, 14, 56,
                165, 174, 49, 1, 57, 126, 123, 100, 30, -1, -1, -1, 161, 13, 139, 2, 85, 128, 119, 177, -1, 169, 135,
                77, 112, 50, 17, 140, 138, 58, -1, -1, 105, -1, -1, -1, -1, 70, -1, -1, 102, -1, -1, 103, -1, 176, -1,
                -1, 115, 132, 154, 125, 5, -1, 108, 36, 32, 7, -1, -1, 148, -1, 153, 16, 130, 72, -1, -1, 95, 116, 48,
                104, -1, -1, 20, 156, -1, -1, 88, -1, 142, 175, -1, 64, 133, 83, 94, -1, 4, 71, 101, -1, -1, -1, -1, 42,
                -1, -1, -1, -1, 134, 166, 28, 92, 33, 82, 74, 45, -1, -1, 168, -1, 9, -1, 44, 26, -1, -1, 170, 6, -1,
                -1, 89, 143, 160, -1, 68, 178, 111, 167, -1, 109, 151, -1, -1, -1, 81, 23, -1, -1, -1, -1, -1, -1, 66,
                11, 10, 179, 15, 96, -1, 127, 18, 163, -1, -1, 24, 29, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, 21, 118, -1, 31, -1, 35, -1, 37, -1, 122, 162, 3, -1, -1, -1, 121, 59, -1, -1,
                -1, 19, 158, 157, -1, 171, 84, 46, 149, -1, -1, -1, -1, 76, 147, 54, 150, -1, -1, -1, -1, 63, 62, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, 86, 43, 55, -1, -1, -1, -1, 172, 120, -1, -1, 91, 155, 8, 107, -1,
                -1, -1, 164, -1, -1, 113, -1, 73, 137, -1, -1, 39, -1, -1, 41, -1, -1, -1, 75, 146, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, 90, -1, 145, -1, -1, 117, 51, -1, -1, 136, -1, 79, 80, -1, 53, 52, -1,
                -1, -1, 159, -1, -1, -1, 60, -1, -1, -1, 131, -1, 38, 12, -1, -1, -1, -1, 124, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, 67, 65, -1, 87, -1, 25, -1, 141, -1, -1, -1, -1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        TreeNode root = createTree(A);
        // System.out.println(zigzagTraversal(root));
        System.out.println(zigzagTrav(root));
    }
}
// if (i % 2 == 0) {
// TreeNode right = root.right;
// if (right != null) {
// levelOrder.add(right.val);
// q.enqueue(right);
// }
// TreeNode left = root.left;
// if (left != null) {
// levelOrder.add(left.val);
// q.enqueue(left);
// }
// } else {
// TreeNode left = root.left;
// if (left != null) {
// levelOrder.add(left.val);
// q.enqueue(left);
// }

// TreeNode right = root.right;
// if (right != null) {
// levelOrder.add(right.val);
// q.enqueue(right);
// }
// }
// i++;