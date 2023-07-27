import java.util.Stack;

public class MaximumRectangle {
    public static void main(String[] args) {
        // int[][] A = {
        // {0, 0, 1},
        // {0, 1, 1},
        // {1, 1, 1},
        // };
        // char[][] A = {
        // {'0', '0', '1'},
        // {'0', '1', '1'},
        // {'1', '1', '1'},
        // };
        char[][] A = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        // char[][] A = {{ '1' }};
        // char[][] A={{'1','1'}};
        // System.out.println(solve(A));
        System.out.println(maximalRectangle(A));
    }

    public static int maximalRectangle(char[][] A) {
        int ans = 0;
        int row = A.length;
        int col = A[0].length;
        // if (row==1&&col==1){
        //     return A[0][0]=='1' ? 1 : 0;
        // }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] != '0' && i != 0) {
                    int x = A[i - 1][j] - '0';
                    int y = A[i][j] - '0';
                    int z = x + y;

                    A[i][j] = (char) (z + '0');
                }
            }
            ans = Math.max(ans, largestRectangleArea(A[i]));
        }
        return ans;
    }

    public static int largestRectangleArea(char[] A) {
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int len = A.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int curr = A[i] - '0';
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && A[stack.peek()] - '0' > curr) {
                    int top = stack.pop();
                    int h = A[top] - '0';
                    // int y = i - top;
                    // int y = i - (stack.empty() ? -1 : top);
                    // ans = Math.max(ans, h * y);
                    max = Math.max(max, h * (stack.isEmpty() ? i : i - stack.peek() - 1));
                }
                stack.push(i);
            }
        }
        int min = 9999999;
        while (!stack.isEmpty()) {
            int top = stack.pop();
            // int h = A[len-1] - '0'
            min = Math.min(A[len-1] - '0', min);
            // int y = (len - 1 - top) * h;
            // int y = (len - top) * h;
            int y = ((len - 1) - (stack.empty() ? -1 : top)) * min;
            ans = Math.max(ans, y);
        }
        return ans;
    }

    public static int solve(int[][] A) {
        int ans = 0;
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] != 0 && i != 0) {
                    A[i][j] = A[i - 1][j] + A[i][j];
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
