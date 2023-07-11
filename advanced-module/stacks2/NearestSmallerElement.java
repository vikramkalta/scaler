import java.util.Stack;

public class NearestSmallerElement {
    public static void main(String[] args) {
        // int[] A = {4, 5, 2, 10, 8};
        int[] A = {39,27,11,4,24,32,32,1};
        System.out.println(prevSmaller(A));
    }

    public static int[] prevSmaller(int[] A) {
        int len = A.length;
        int[] G = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int curr = A[i];
            if (stack.empty()) {
                G[i] = -1;
            } else {
                while( !stack.empty() ) {
                    if ( stack.peek() < curr ) {
                        G[i] = stack.peek();
                        break;
                    } else if ( stack.peek() >= curr ) {
                        stack.pop();
                    }
                }
                if (stack.empty()) {
                    G[i] = -1;
                }
            }
            stack.push(curr);
        }
        return G;
    }
}