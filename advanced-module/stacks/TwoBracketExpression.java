import java.util.Stack;

public class TwoBracketExpression {
    public static void main(String[] args) {
        // String A = "-(a+b+c)";
        // String B = "-a-b-c";
        // String A = "a-b-(c-d)";
        // String B = "a-b-c-d";
        // String A = "(a+b-c-d+e-f+g+h+i)";
        // String B = "a+b-c-d+e-f+g+h+i";
        String A = "-(-(-(-a+b)-d+c)-q)";
        String B = "a-b-d+c+q";
        System.out.println(solve(A, B));
    }
    public static int solve(String A, String B) {
        int ans = 0;
        Stack<Character> stack1 = new Stack<Character>();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            if (curr == ')') {
                StringBuilder x1 = new StringBuilder();
                while (!stack1.isEmpty()) {
                    char x = stack1.pop();
                    if (x == '+' || x == '-') {
                        x1.append(x == '+' ? '-' : '+');
                    } else {
                        if (x != '(') {
                            x1.append(x);
                        }
                    }
                }
                for (int j = x1.length() - 1; j >= 0; j--) {
                    s1.append(x1.charAt(j));
                }
            }
            if (!stack1.isEmpty()) {
                stack1.push(curr);
            }
            if (stack1.isEmpty()) {
                if (curr == '(' && i > 0 && A.charAt(i-1) == '-') {
                    stack1.push(curr);
                } else {
                    if (curr != ')' && curr != '(')
                        s1.append(curr);
                }
            }
        }
        
        Stack<Character> stack2 = new Stack<Character>();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < B.length(); i++) {
            char curr = B.charAt(i);
            if (curr == ')') {
                StringBuilder x1 = new StringBuilder();
                while (!stack2.isEmpty()) {
                    char x = stack2.pop();
                    if (x == '+' || x == '-') {
                        x1.append(x == '+' ? '-' : '+');
                    } else {
                        if (x != '(') {
                            x1.append(x);
                        }
                    }
                }
                for (int j = x1.length() - 1; j >= 0; j--) {
                    s2.append(x1.charAt(j));
                }
            }
            if (!stack2.isEmpty()) {
                stack2.push(curr);
            }
            if (stack2.isEmpty()) {
                if (curr == '(' && i > 0 && B.charAt(i-1) == '-') {
                    stack2.push(curr);
                } else {
                    if (curr != ')' && curr != '(')
                        s2.append(curr);
                }
            }
        }
        ans = (new String(s1)).equals(new String(s2)) ? 1: 0;
        return ans;
    }
}