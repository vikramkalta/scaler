// package stacks2;

import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        // int[] A = { 2, 1, 5, 6, 2, 3 };
        // int[] A = {90,58,69,70,82,100,13,57,47,18};
        // int[] A = {6,2,5,4,5,1,6};
        int[] A = {1};
        System.out.println(largestRectangleArea(A));
    }

    public static int largestRectangleArea(int[] A) {
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int len = A.length;

        for (int i = 0; i < len; i++) {
            int curr = A[i];
            if (stack.isEmpty() || A[stack.peek()] < curr) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && A[stack.peek()] > curr) {
                    int top = stack.pop();
                    int h = A[top];
                    int y = i - (stack.empty() ? -1 : stack.peek()) - 1;
                    ans = Math.max(ans, h * y);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int h = A[top];
            int y = len - (stack.empty() ? -1 : stack.peek()) - 1;
            ans = Math.max(ans, h * y);
        }
        return ans;
    }
}
