import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        // String A = "((a+b))";
        String A = "(a+(a+b))";
        System.out.println(braces(A));
    }
    public static int braces(String A) {
        int ans = 0;
        Stack<Character> stack = new Stack<Character>();
        int len = A.length();
        int i = 0;
        while (i < len) {
            char curr = A.charAt(i);
            if (curr != ')') {
                stack.push(curr);
            } else {
                int x = 0;
                while (stack.peek() != '(') {
                    if (stack.peek() == '+'
                    || stack.peek() == '-'
                    || stack.peek() =='/'
                    || stack.peek() == '*') {
                        x++;
                    }
                    stack.pop();
                }
                if (x == 0) {
                    ans = 1;
                }
                stack.pop();
            }
            i++;
        }
        return ans;
    }
}
