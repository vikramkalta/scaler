import java.util.Stack;

public class AllSubarrays {
    public static void main(String[] args) {
        // int[] A = { 2, 3, 1, 4 };
        // int[] A = {5,2,1,4,3};
        // int[] A = {9684070,8434295,5257262,2548570,2302579,7388791,3806526,6533330,5381853,4544656};
        int[] A = {11,10,8};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int ans = 0;
        int n = A.length;
        // create a stack to store the maximum value of all subarrays
        Stack < Integer > s = new Stack < Integer > ();
        for (int i = 0; i < n; i++) {
            // while stack is not emepty take xor of its top and current element
            while (!s.empty()) {
                // strore the maximum value of xor
                int topElement = s.peek();
                ans = Math.max(ans, (A[topElement] ^ A[i]));
                // if top of the stack is greater than current element than break the loop
                if (A[topElement] > A[i]) break;
                else s.pop(); //pop out the top of the stack
            }
            // push the current element into the stack
            s.push(i);
        }
        // return the answer
        return ans;
    }

    public static int solve1(int[] A) {
        int len = A.length;
        Stack<Integer> stack = new Stack<>();
        int maxXor = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            while (!stack.empty() && A[stack.peek()] < A[i]) {
                maxXor = Math.max(maxXor, A[stack.peek()] ^ A[i]);
                stack.pop();
            }
            if (!stack.empty()) {
                maxXor = Math.max(maxXor, A[stack.peek()] ^ A[i]);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            maxXor = Math.max(maxXor, A[stack.peek()] ^ A[len-1]);
            stack.pop();
        }
        return maxXor;
    }
}