import java.util.Stack;

public class Passing2 {
    public static void main(String[] args) {
        int A = 10;
        int B = 23;
        int[] C = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
        System.out.println(solve(A, B, C));
    }

    public static int solve(int A, int B, int[] C) {
        Stack<Integer> stack = new Stack<>();
        stack.push(B);
        for (int i = 0; i < C.length; i++) {
            if (C[i] != 0) {
                stack.push(C[i]);
            } else {
                stack.pop();
            }
        }
        int x = (int)stack.peek();
        return x;
    }
}
