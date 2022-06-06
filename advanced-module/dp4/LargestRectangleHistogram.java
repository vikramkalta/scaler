public class LargestRectangleHistogram {
    public static void main(String args[]) {
        int[] heights = {2,2,1,4,5,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int max = Integer.MIN_VALUE;
        int[] leftSmaller = new int[len];
        int[] rightSmaller = new int[len];

        Stack stack = new Stack(len);
        
        for (int i = 0; i < len; i++) {
            int curr = heights[i];
            if (stack.isEmpty()) {
                leftSmaller[i] = 0;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.top()] >= curr) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    leftSmaller[i] = 0;
                } else {
                    leftSmaller[i] = stack.top() + 1;
                }
                stack.push(i);
            }
        }

        stack = new Stack(len);
        for (int i = len - 1; i >= 0; i--) {
            int curr = heights[i];
            if (stack.isEmpty()) {
                rightSmaller[i] = len - 1;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.top()] >= curr) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    rightSmaller[i] = len - 1;
                } else {
                    rightSmaller[i] = stack.top() - 1;
                }
                stack.push(i);
            }
        }
        for (int i = 0; i < len; i++) {
            int currLeft = leftSmaller[i];
            int currRight = rightSmaller[i];
            int x = (currRight - currLeft + 1) * heights[i];
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    public static int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int currMin = heights[i];
            if (max < currMin) {
                max = currMin;
            }
            for (int j = i+1; j < len; j++) {
                int currJ = heights[j];
                if (currJ < currMin) {
                    currMin = currJ;
                }
                int x = currMin * (j-i+1);
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
                System.out.println("Err[pop]");
                System.exit(1);
            }
            int temp = stack[top];
            top--;
            return temp;
        }
        public int top() {
            // if (top == -1) {
            //     return Integer.MIN_VALUE;
            // }
            return stack[top];
        }
        public boolean isEmpty() {
            return top == -1;
        }
        public boolean isFull() {
            return top == len - 1;
        }
    }
}