import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String A = "{([])}";
        // String A = "(){";
        System.out.println(solve(A));
    }

    public static int solve(String A) {
        Stack<Character> stack = new Stack<Character>();
        int ans = 1;
        int len = A.length();
        int i = 0;
        while (i < len) {
            char curr = A.charAt(i);
            if (curr == '{' || curr == '(' || curr == '[') {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    ans = 0;
                    break;
                }
                char x = stack.pop();
                if (x == '{' && curr != '}') {
                    ans = 0;
                    break;
                }
                if (x == '(' && curr != ')') {
                    ans = 0;
                    break;
                }
                if (x == '[' && curr != ']') {
                    ans = 0;
                    break;
                }
            }
            i++;
        }
        return !stack.isEmpty() ? 0 : ans;
    }
}