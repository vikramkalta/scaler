public class MaximalRectangle {
    public static void main(String args[]) {
        // char[][] matrix = {{'1','0','1','0','0'},
        //                     {'1','0','1','1','1'},
        //                     {'1','1','1','1','1'},
        //                     {'1','0','0','1','1'}};
        char[][] matrix = {
            {'0','0','1','0'},
            {'0','0','1','0'},
            {'0','0','1','0'},
            {'0','0','1','1'},
            {'0','1','1','1'},
            {'0','1','1','1'},
            {'1','1','1','1'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char curr = matrix[i][j];
                if (curr == '1') {
                    int x = matrix[i-1][j] - '0';
                    matrix[i][j] = (char)(x + 1 + '0');
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            int[] leftMin = new int[cols];
            int[] rightMin = new int[cols];

            Stack stack = new Stack(cols);
            for (int j = 0; j < cols; j++) {
                int curr = matrix[i][j] - '0';
                if (stack.isEmpty()) {
                    leftMin[j] = 0;
                } else {
                    while (!stack.isEmpty() && matrix[i][stack.top()] - '0' >= curr) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        leftMin[j] = 0;
                    } else {
                        leftMin[j] = stack.top() + 1;
                    }
                }
                stack.push(j);
            }
            stack = new Stack(cols);
            for (int j = cols-1; j >= 0; j--) {
                int curr = matrix[i][j] - '0';
                if (stack.isEmpty()) {
                    rightMin[j] = cols - 1;
                } else {
                    while (!stack.isEmpty() && matrix[i][stack.top()] - '0' >= curr) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        rightMin[j] = cols - 1;
                    } else {
                        rightMin[j] = stack.top() - 1;
                    }
                }
                stack.push(j);
            }
            for (int j = 0; j < cols; j++) {
                int x = (rightMin[j] - leftMin[j] + 1) * (matrix[i][j] - '0');
                if (x > max) {
                    max = x;
                }
            }
        }
        return max;
    }

    static class Stack {
        int len = 0, top = -1;
        int[] stack;
        Stack(int n) {
            stack = new int[n];
            len = n;
        }
        public void push(int n) {
            if (isFull()) {
                System.out.println("Err[push]");
                System.exit(1);
            }
            top++;
            stack[top] = n;
        }
        public int pop() {
            if (isEmpty()) {
                System.out.println("Err[push]");
                System.exit(1);
            }
            int temp = stack[top];
            top--;
            return temp;
        }
        public boolean isFull() {
            return top == len - 1;
        }
        public boolean isEmpty() {
            return top == -1;
        }
        public int top() {
            return stack[top];
        }
    }
}
