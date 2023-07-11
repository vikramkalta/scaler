import java.util.Stack;

public class MaximumRectangle {
    public static void main(String[] args) {
        int[][] A = {
            {0, 0, 1},
            {0, 1, 1},
            {1, 1, 1},
        };
        System.out.println(solve(A));
    }

    public static int solve(int[][] A) {
        int ans = 0;
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] != 0 && i != 0) {
                    A[i][j] = A[i-1][j] + A[i][j];
                }
            }
            ans = Math.max(ans, largestRectangleArea(A[i]));
        }
        return ans;
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
