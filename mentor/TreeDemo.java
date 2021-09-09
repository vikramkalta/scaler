public class TreeDemo {
    // Root of the Binary tree
    Node root;
    static class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    // Constructors
    TreeDemo(int key) {
        root = new Node(key);
    }
    TreeDemo() {
        root = null;
    }

    public static void insert(Node root, int data) {
        if (root.key > data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new Node(data);
            }
        } else {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new Node(data);
            }
        }
    }

    public static void traversalInorder(Node root) {
        if (root == null) {
            return;
        }
        traversalInorder(root.left);
        System.out.println("val " + root.key);
        traversalInorder(root.right);
    }

    public static void main(String args[]) {
        TreeDemo tree = new TreeDemo(5);
        insert(tree.root, 2);
        insert(tree.root, 3);
        insert(tree.root, 4);
        /* create root */
        // tree.root = new Node(1);
        /**
         * Following is the tree after the above statement. 1 / \ null null
         */
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(3);/**
        // tree.root.left.left = new Node(4);
        traversalInorder(tree.root);
    }

}

// public void insert(Node node, int value) {
// if (value < node.value) {
// if (node.left != null) {
// insert(node.left, value);
// } else {
// System.out.println(" Inserted " + value + " to left of " + node.value);
// node.left = new Node(value);
// }
// } else if (value > node.value) {
// if (node.right != null) {
// insert(node.right, value);
// } else {
// System.out.println(" Inserted " + value + " to right of "
// + node.value);
// node.right = new Node(value);
// }
// }
// }