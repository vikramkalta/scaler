public class NextGreaterNumber {
    public static void main(String args[]) {
        // int[] nums = { 1, 2, 3, 4, 3 };
        // int[] nums = {1,2,1};
        // int[] nums = {1,2,3,4,5};
        int[] nums = {5,4,3,2,1};
        // int[] nums = {1};
        // int[] nums = {1,1,1,1,1};
        System.out.println(nextGreaterElements(nums));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len == 1) return new int[]{-1};
        int[] ans = new int[len];
        Stack stack = new Stack(len);

        int i = len - 1;
        int currPointer = i;
        while (i >= 0) {
            int originalNum = nums[i];
            if (currPointer != i) {
                int currNum = nums[currPointer];
                if (currNum > originalNum) {
                    ans[i] = currNum;
                    i--;
                    currPointer = i;
                    continue;
                }
                currPointer = (currPointer + 1) % len;
                if (currPointer == i) {
                    ans[i] = -1;
                    i--;
                    currPointer = i;
                    continue;
                }
                continue;
            }
            int greaterElement = Integer.MIN_VALUE;
            while (stack.seek() <= originalNum) {
                greaterElement = stack.pop();
            }
            if (stack.isEmpty() && greaterElement <= originalNum ) {
                currPointer = (currPointer + 1) % len;
                stack.push(originalNum);
                continue;
            } else {
                ans[i] = stack.seek();
                stack.push(originalNum);
            }
            i--;
            currPointer--;
        }
        return ans;
    }

    // Answer for regular array. Not circular.
    // if (i == len - 1) {
    //     stack.push(curr);
    //     ans[i] = -1;
    // } else {
    //     if (curr < stack.seek()) {
    //     ans[i] = stack.seek();
    //     stack.push(curr);
    //     } else {
    //     while (stack.seek() < curr) {
    //         stack.pop();
    //     }
    //     if (stack.isEmpty()) {
    //         ans[i] = -1;
    //     } else {
    //         ans[i] = stack.seek();
    //     }
    //     stack.push(curr);
    //     }
    // }

    static class Stack {
        int len = 0, top = -1;
        int[] _stack;

        Stack(int n) {
            len = n;
            _stack = new int[n];
        }

        public void push(int n) {
            if (isFull()) {
                System.out.println("Err[push]");
                System.exit(1);
            }
            top++;
            _stack[top] = n;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Err[pop]");
                System.exit(1);
            }
            int temp = _stack[top];
            top--;
            return temp;
        }

        public int seek() {
            if (top == -1) {
                return Integer.MAX_VALUE;
            }
            return _stack[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == len;
        }
    }
}