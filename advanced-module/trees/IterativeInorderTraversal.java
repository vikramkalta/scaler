import java.util.ArrayList;

public class IterativeInorderTraversal {
    TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static class Stack {
        public int size;
        public TreeNode[] arr;
        public int length;

        Stack(int n) {
            size = n;
            arr = new TreeNode[n];
        }

        public void push(TreeNode data) {
            if (isFull()) {
                System.out.println("Stack is full");
                System.exit(1);
            }
            arr[this.length] = data;
            this.length++;
        }

        public TreeNode pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                System.exit(1);
            }
            TreeNode temp = arr[this.length - 1];
            this.length--;
            return temp;
        }

        public boolean isFull() {
            return this.size == this.length;
        }

        public boolean isEmpty() {
            return this.length == 0;
        }

        public void print() {
            for (int i = 0; i < this.length; i++) {
                System.out.println("el : " + arr[i]);
            }
        }
    }

    IterativeInorderTraversal(int data) {
        root = new TreeNode(data);
    }

    public static void insert(TreeNode root, int data) {
        TreeNode temp = root;
        if (temp.val > data) {
            if (temp.left != null) {
                insert(temp.left, data);
            } else {
                temp.left = new TreeNode(data);
            }
        } else {
            if (temp.right != null) {
                insert(temp.right, data);
            } else {
                temp.right = new TreeNode(data);
            }
        }
    }

    public static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println("el: " + node.val);
        inorder(node.right);
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack st = new Stack(100000);
        TreeNode temp = A;
        while (temp != null || !st.isEmpty()) {
            if (temp == null) {
                TreeNode x = st.pop();
                if (x.val != -1) {
                    result.add(x.val);
                }
                temp = x.right;
                continue;
            }

            if (temp.left != null) {
                st.push(temp);
                temp = temp.left;
            } else {
                if (temp.val != -1) {
                    result.add(temp.val);
                }
                temp = temp.right;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        // 1135
        int[] arr = { 166, 414, 260, 256, 289, 403, 567, 337, 146, 281, 51, -1, 42, 35, 561, 137, 12, 348, 468, 19, 242,
                52, 113, 487, -1, 428, 175, 118, 3, 13, 535, 259, 437, 563, 389, 500, -1, 38, 8, 207, 221, 265, 238,
                205, 136, -1, -1, 89, 105, 145, 527, -1, 78, 225, 296, 286, 494, 47, 385, 558, 380, 488, 62, -1, 148,
                198, 484, -1, -1, 98, 165, -1, 174, 45, -1, -1, 333, 80, 287, -1, 21, 520, 239, 294, 464, 95, 24, 435,
                72, 463, -1, 134, 450, -1, -1, 97, -1, 291, 345, 445, 30, 550, 537, 413, -1, 379, 185, 279, 276, 109,
                224, 201, -1, 58, 410, -1, -1, -1, -1, 309, -1, 39, 442, 497, 2, -1, -1, -1, -1, 315, -1, 231, 28, 7,
                424, 401, -1, -1, -1, 549, 480, -1, 556, 85, -1, 369, 361, 475, 111, 390, 305, 321, 507, -1, 493, -1,
                64, 16, 135, 167, -1, 444, 318, 150, -1, 179, 350, 212, 529, 176, 261, 504, -1, -1, -1, 384, -1, 297,
                124, -1, -1, 275, 271, 202, -1, 509, 439, -1, -1, 443, 499, -1, -1, -1, -1, 359, 448, 293, 466, 438,
                180, 447, -1, 157, 323, 67, 243, 478, 555, -1, 22, -1, 160, -1, -1, 530, 420, -1, 560, 247, 233, -1,
                409, 142, -1, -1, -1, 50, 262, 96, 37, 88, 184, 329, 382, 5, 27, 31, 43, -1, -1, -1, -1, -1, 104, 15,
                479, -1, -1, 533, 108, 216, 193, -1, 268, 188, 431, 299, 546, -1, -1, 274, 395, 458, 11, 139, -1, 517,
                -1, -1, 474, 177, 483, 194, 473, 393, 112, 441, 140, 523, -1, -1, 524, 460, 302, -1, 23, -1, 521, 235,
                63, 6, 232, 356, 552, -1, 214, 404, 376, 426, 308, -1, -1, -1, 332, -1, -1, -1, -1, -1, -1, -1, -1, 54,
                457, -1, -1, -1, -1, 391, 282, 161, 394, 406, 486, 141, 554, -1, -1, 237, 56, -1, 553, 502, 342, 273,
                417, -1, -1, 462, 336, 526, 392, 325, 208, 158, 311, 152, 181, 534, 387, 277, 240, -1, 485, 48, 351, -1,
                -1, -1, -1, 223, 187, -1, -1, 195, 423, -1, -1, -1, -1, -1, -1, 557, 440, 446, -1, 365, 518, 66, 172,
                -1, 378, 200, 228, -1, 90, -1, 163, -1, -1, -1, -1, -1, -1, 46, 117, 449, 26, 399, 255, 126, 566, -1,
                358, -1, -1, -1, -1, 397, 83, -1, -1, -1, 283, -1, -1, 452, -1, -1, 344, -1, -1, -1, 322, 263, 383, 290,
                -1, 70, -1, 419, 218, -1, -1, 418, -1, -1, 132, -1, -1, 222, 386, -1, 149, -1, -1, -1, -1, -1, 230, 71,
                203, 541, 61, 57, 374, 213, 388, 467, 41, 87, 236, -1, 120, -1, -1, 173, -1, 301, -1, 508, -1, 25, 405,
                -1, 341, 164, 421, 416, 482, -1, 81, -1, -1, -1, -1, -1, -1, 258, 246, 93, 429, 327, 513, 316, 432, 121,
                -1, -1, -1, 116, 522, 559, 73, -1, -1, -1, -1, -1, 257, -1, 491, -1, 324, -1, -1, -1, -1, -1, -1, -1,
                -1, 65, -1, -1, -1, 528, -1, -1, -1, 349, -1, -1, 495, 76, 125, 254, -1, 312, 245, -1, 40, 168, 159,
                138, 408, 162, 505, 425, 503, 169, 55, 471, -1, -1, -1, -1, -1, -1, 562, 288, 86, -1, -1, -1, -1, -1,
                79, 186, -1, -1, -1, -1, -1, -1, 272, 540, -1, -1, -1, 94, -1, -1, 99, -1, 244, -1, -1, 170, -1, 510,
                -1, -1, -1, -1, -1, -1, 267, -1, -1, -1, -1, -1, -1, 407, 531, 74, -1, 434, 264, 330, 215, -1, -1, 353,
                -1, 515, 106, -1, 310, -1, 519, 368, 49, -1, -1, -1, -1, 280, -1, -1, -1, 525, 306, -1, 219, -1, -1, -1,
                -1, -1, -1, -1, -1, 248, -1, 192, 156, 133, 147, 430, -1, 34, -1, -1, 204, 300, 381, 84, 412, 340, 130,
                -1, 551, -1, -1, 206, 498, 366, 331, -1, 266, 459, 123, 326, 122, 270, -1, -1, 68, 251, -1, 115, 506,
                -1, -1, -1, -1, -1, 422, -1, -1, -1, -1, 339, 539, -1, -1, -1, -1, 209, 372, 511, 347, -1, 455, 77, 544,
                -1, -1, -1, 328, -1, -1, -1, -1, 131, -1, 226, -1, -1, -1, -1, -1, -1, 363, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, 364, -1, -1, -1, -1, 211, -1, -1, -1, 461, 252, -1, 227,
                -1, -1, 199, -1, 334, 234, -1, -1, -1, 33, -1, -1, 514, 197, 220, 314, 60, 241, -1, -1, 119, 470, 436,
                -1, -1, -1, 91, -1, -1, -1, 128, 32, -1, 538, 129, -1, -1, -1, -1, -1, 284, 398, 151, 542, 20, 477, -1,
                -1, 469, -1, -1, -1, 101, -1, 17, 196, -1, 191, -1, 303, 210, -1, 371, 253, 82, -1, -1, 171, 317, -1,
                532, -1, -1, 453, -1, 451, -1, -1, -1, -1, -1, -1, -1, -1, -1, 320, 229, -1, 298, -1, -1, -1, -1, 492,
                -1, -1, 92, -1, -1, 114, -1, -1, 360, -1, -1, 465, 433, -1, -1, -1, -1, 352, -1, -1, -1, -1, 127, -1,
                355, 373, -1, 36, 472, -1, -1, -1, 456, -1, -1, 10, -1, -1, -1, 516, -1, -1, -1, -1, -1, 182, -1, -1,
                100, 481, 370, 396, 564, -1, -1, 313, -1, -1, -1, -1, 545, -1, -1, 69, -1, -1, -1, 189, -1, -1, -1, -1,
                512, -1, 400, -1, -1, -1, -1, -1, -1, -1, 53, -1, 343, -1, -1, 346, 411, -1, 190, 18, 307, -1, 4, -1,
                543, 565, -1, -1, -1, -1, 103, -1, 501, -1, 59, -1, -1, -1, 29, -1, 9, -1, -1, -1, -1, 44, -1, -1, 335,
                -1, -1, -1, -1, 278, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 217, 144, -1, -1, -1, -1,
                1, -1, -1, -1, 155, -1, -1, -1, -1, -1, 110, -1, -1, 496, -1, -1, 536, -1, 402, 338, -1, 547, 357, -1,
                -1, -1, -1, 107, -1, -1, 269, -1, -1, 75, -1, -1, -1, -1, -1, 183, -1, -1, -1, -1, -1, 454, -1, -1, -1,
                -1, -1, -1, -1, 362, -1, -1, -1, -1, -1, -1, 143, -1, 178, -1, -1, -1, 367, 102, 490, -1, -1, -1, 377,
                375, 285, -1, 249, 489, 476, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 548, -1, -1, 304, 154, -1,
                -1, 354, -1, 427, 153, -1, 295, -1, -1, -1, -1, -1, -1, -1, 250, -1, -1, -1, -1, -1, -1, 415, -1, -1,
                -1, 319, -1, -1, -1, -1, -1, 292, -1, -1, -1, -1, -1, -1, -1 };

        // IterativeInorderTraversal tree = new IterativeInorderTraversal(1);
        // tree.root.left = new TreeNode(-1);
        // tree.root.right = new TreeNode(2);
        // tree.root.right.left = new TreeNode(3);
        // tree.root.right.right = new TreeNode(-1);

        // IterativeInorderTraversal tree = new IterativeInorderTraversal(1);
        // tree.root.left = new TreeNode(6);
        // tree.root.left.right = new TreeNode(-1);
        // tree.root.left.left = new TreeNode(-1);
        // tree.root.right = new TreeNode(2);
        // tree.root.right.left = new TreeNode(3);
        // tree.root.right.right = new TreeNode(-1);

        // System.out.println(inorderTraversal(tree.root));
        // int[] arr = {1,2,3,-1,-1,4,-1,-1,5,-1,-1};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        TreeNode _root = createTreeFromLevelOrder(A);
        System.out.println(inorderTraversal(_root));
    }

    public static TreeNode createTreeFromLevelOrder(ArrayList<Integer> A) {
        int len = A.size();
        Queue q = new Queue(len);
        TreeNode _root = new TreeNode(A.get(0));
        q.enqueue(_root);

        int i = 1;
        while (i < len) {
            if (!q.isEmpty()) {
                TreeNode x = q.dequeue();
                int left = A.get(i);

                int right = -1;
                if (i + 1 < len) {
                    right = A.get(i + 1);
                }

                if (left != -1) {
                    x.left = new TreeNode(left);
                    q.enqueue(x.left);
                }
                if (right != -1) {
                    x.right = new TreeNode(right);
                    q.enqueue(x.right);
                }
            }
            i += 2;
        }

        // inorder(_root);
        return _root;
    }

    static class Queue {
        int size;
        TreeNode[] temp;
        int front = 0, rear = -1;
        int length;

        Queue(int n) {
            size = n;
            temp = new TreeNode[n];
        }

        public void enqueue(TreeNode a) {
            if (isFull()) {
                System.out.println("Full");
                System.exit(1);
            }
            rear = (rear + 1) % size;
            temp[rear] = a;
            length++;
        }

        public TreeNode dequeue() {
            if (isEmpty()) {
                System.out.println("Empty");
                System.exit(1);
            }
            TreeNode x = temp[front];
            front = (front + 1) % size;
            length--;
            return x;
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public boolean isFull() {
            return length == size;
        }
    }
}