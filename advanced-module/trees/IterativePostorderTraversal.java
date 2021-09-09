import java.util.ArrayList;

public class IterativePostorderTraversal {
    TreeNode root;
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
    IterativePostorderTraversal(int x) {
        root = new TreeNode(x);
    }
    public static void insert(TreeNode _root, int data) {
        if (_root.val > data) {
            if (_root.left != null) {
                insert(_root.left, data);
            }else{
                _root.left=new TreeNode(data);
            }
        }else{
            if (_root.right != null) {
                insert(_root.right, data);
            }else{
                _root.right=new TreeNode(data);
            }
        }
    }
    static class Stack {
        int size=0;
        int length = 0;
        TreeNode[] stack;
        Stack(int n){
            stack=new TreeNode[n];
            size = n;
        }
        public void push(TreeNode x){
            if (isFull()){
                System.out.println("full");
                System.exit(1);
            }
            stack[length]=x;
            length++;
        }
        public TreeNode pop() {
            if (isEmpty()){
                System.out.println("empty");
                System.exit(1); 
            }
            TreeNode temp = stack[length-1];
            length--;
            return temp;
        }
        public boolean isEmpty(){
            return length == 0;
        }
        public boolean isFull() {
            return size == length;
        }
    }
    public static ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result =new ArrayList<>();
        Stack stack = new Stack(100000);
        TreeNode temp = A;
        while(temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                result.add(temp.val);
                temp = temp.right;
            } else {
                TreeNode x = stack.pop();
                temp = x.left;
            }
        }
        int len = result.size();
        for (int i = 0; i < len/2; i++) {
            int curr = result.get(i);
            int rev = result.get(len - i - 1);
            result.set(i, rev);
            result.set(len-i-1, curr);
        }
        return result;
    }

    public static void main(String args[]) {
        // int[] arr = {1,2,3,-1,-1,4,-1,-1,5,-1,-1};
        // int[] arr = {1,2,3,4,5};
        // int[] arr = {1,3,2,5,4};
        int[]arr={5,3,8,2,4,7,9};
        // ArrayList<Integer> A = new ArrayList<>();
        IterativePostorderTraversal t = new IterativePostorderTraversal(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            // A.add(arr[i]);
            insert(t.root, arr[i]);
        }
        System.out.println(postorderTraversal(t.root));
    }
}
