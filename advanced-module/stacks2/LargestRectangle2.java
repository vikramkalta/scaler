import java.util.Stack;

public class LargestRectangle2 {
    public static void main(String[] args) {
        int[] A = { 2, 1, 5, 6, 2, 3 };
        // int[] A = {90,58,69,70,82,100,13,57,47,18};
        // int[] A = {6,2,5,4,5,1,6};
        // int[] A = {1};
        System.out.println(largestRectangleArea(A));
    }
    public static int largestRectangleArea(int[] A) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int curr = A[i];
            if (!stack.empty()) {
                while ( !stack.empty() && A[stack.peek()] > curr ) {
                    int x = stack.pop();
                    int y = (i - x) * A[x];
                    ans = Math.max(ans, y);
                }
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int x = stack.pop();
            int y = (len-1-x) * A[x];
            ans = Math.max(ans, y);
        }
        return ans;
    }
}
