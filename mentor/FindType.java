public class FindType {
    public static void main(String args[]) {}
    /**
     * class D extends B
     * class B extends A
     * 
     * Object Type Hierarchy Tree
     *          Object
     *      A            G
     *    B   C         H
     *  D    E  F     I   J
     * PL internal representation of Type Hierarchy
     * 
     * Find the best type of 2 objects
     * // Example:
     * D & E = A
     * I & F = Object
     * I & J = H
     * 
     * Several Use cases:
     * x = condition ? st1 : st2;
     * st1 of type D
     * st2 of type F
     * 
     * Type of x -- ?
     * 
     * // Trying to infer the type of an If-Else statement
     * // Ternary (:) operators
     * // Return of a function
     * condition ? statement1 : statement2
     * statement1 is a object of class1
     * statement2 is a object of class2
     * 
     * // Other use cases
     * // Find the common function in hierarchy
     * // to execute on these two objects, for
     * // example +
     */

    /**
     * E = {name: "E"}; 
     * F = {name: "F"}
     * C = {name: "C", left: E, right: F}
     * D = {name: "D"}
     * B = {name: "B", left: D}
     * A = {name: "A", left: B, right: C};
     * 
     * I = {name: "I"}; 
     * J = {name: "J"};
     * H = {name: "H", left: I, right: J};
     * G = {name: "G", left: H};
     * 
     * Object = {name: "Object", left: A, right: };
     * Root = Object;
     *          Root
     *      A           G
     *    B    C      H
     *  D     E   F  I   J
     */

    static class Node {
        String name;
        Node left, right;

        Node(String name) {
            this.name = name;
            this.left = null;
            this.right = null;
        }

        Node(String name, Node a) {
            this.name = name;
            this.left = a;
            this.right = null;
        }

        Node(String name, Node a, Node b) {
            this.name = name;
            this.left = a;
            this.right = b;
        }
    }

    /**
     *          Object
     *      A              G
     *    B   C         H
     * D     E  F     I   J
     */
    static Node e = new Node("E");
    static Node f = new Node("F");
    static Node c = new Node("C", e, f);;

    static Node d = new Node("D");
    static Node b = new Node("B", d);
    static Node a = new Node("A", b, c);
    
    static Node i = new Node("I");
    static Node j = new Node("J");
    static Node h = new Node("H", i, j);
    static Node g = new Node("G", h);

    static Node root = new Node("Object", a, g);

    public static Node dfs(Node root, Node[] nodes, Boolean[] visited) {
        if (root == null) {
            return null;
        }
        return root;
    }

    public static String inferBaseType(Node[] nodes) {
        Boolean[] visited = new Boolean[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            visited[i] = false;
        }
        Node ans = dfs(root, nodes, visited);
        String _ans = ans.name;
        return ans == null ? root.name : _ans;
    }
}