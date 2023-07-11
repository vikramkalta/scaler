import java.util.Stack;

public class EvalExpression {
    public static void main(String[] args) {
        // String[] A = { "2", "1", "+", "3", "*" };
        // String[] A = {"4", "13", "5", "/", "+"};
        // String[] A = {"-1"};
        String[] A = {"-500","-10","/"};
        System.out.println(evalRPN(A));
    }

    public static int evalRPN(String[] A) {
        int len = A.length;
        if (len==1) {
            return Integer.valueOf(A[0]);
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < len) {
            int curr = 0;
            char currChar = '|';
            try {
                curr = Integer.valueOf(A[i]);
            } catch (Exception e) {
                currChar = A[i].charAt(0);
            }
            if (currChar == '/' || currChar == '*' || currChar == '-' || currChar == '+') {
                int x = stack.pop();
                int y = stack.pop();
                int z;
                if (currChar == '/') {
                    z = y / x;
                } else if (currChar == '*') {
                    z = y * x;
                } else if (currChar == '-') {
                    z = y - x;
                } else {
                    z = y + x;
                }
                stack.push(z);
            } else {
                stack.push(curr);
            }
            i++;
        }
        return stack.pop();
    }
}