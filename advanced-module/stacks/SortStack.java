import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        // int[] A = {5, 4, 3, 2, 1};
        // int[] A = { 5, 17, 100, 11 };
        int[] A = { 1, 4, 6, 11, 12, 14, 22, 28, 41, 42, 43, 43, 66, 70, 70, 76, 78, 81, 88, 90, 96 };
        System.out.println(solve(A));
    }

    public static int[] solve(int[] A) {
        int[] ans = new int[A.length];
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        for (int i = 0; i < A.length; i++) {
            stack1.push(A[i]);
        }
        stack2.push(stack1.pop());
        while (!stack1.isEmpty()) {
            if (stack1.peek() > stack2.peek()) {
                while (stack1.peek() > stack2.peek()) {
                    int x = stack1.pop();
                    stack2.push(x);
                    if (stack1.isEmpty()) {
                        break;
                    }
                }
            } else {
                int x = stack1.pop();
                while (stack2.peek() > x) {
                    int y = stack2.pop();
                    stack1.push(y);
                    if (stack2.isEmpty()) {
                        break;
                    }
                }
                stack2.push(x);
            }
        }
        for (int i = 0; i < stack2.size(); i++) {
            ans[i] = stack2.get(i);
        }
        return ans;
    }
}