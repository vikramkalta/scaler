import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        // int[] A = {4, 5, 2, 10};
        // int[] A = {3, 2, 1};
        int[] A = {39,27,11,4,24,32,32,1};
        System.out.println(nextGreater(A));
    }

    public static int[] nextGreater(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int len = A.length;
        int[] ans = new int[len];
        for (int i = len-1; i >= 0; i--) {
            int curr = A[i];
            if (stack.empty()) {
                ans[i] = -1;
            } else {
                if (stack.peek() > curr) {
                    ans[i] = stack.peek();
                } else {
                    while (!stack.empty() && stack.peek() <= curr) {
                        stack.pop();
                    }
                    if (stack.empty()) {
                        ans[i] = -1;
                    } else {
                        ans[i] = stack.peek();
                    }
                }
            }
            stack.push(curr);
        }
        return ans;
    }
}
