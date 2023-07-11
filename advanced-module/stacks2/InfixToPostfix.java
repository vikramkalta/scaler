import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        // String A = "x^y/(a*z)+b";
        String A = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(solve(A));
    }
    public static String solve(String A) {
        int len = A.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('/', 2);
        map.put('*', 2);
        map.put('+', 1);
        map.put('-', 1);
        map.put('(', 999);
        map.put(')', 999);

        for (int i = 0; i < len; i++) {
            char curr = A.charAt(i);
            if (!map.containsKey(curr)) {
                ans.append(curr);
            } else if (curr == ')') {
                while (stack.peek() != '(') {
                    char x = stack.pop();
                    ans.append(x);
                }
                stack.pop();
            } else if (map.containsKey(curr))  {
                while (!stack.empty() && map.get(stack.peek()) >= map.get(curr) && curr != '(' && stack.peek() != '(') {
                    char x = stack.pop();
                    ans.append(x);
                }
                stack.push(curr);
            }
        }
        while(!stack.empty()) {
            ans.append(stack.pop());
        }
        return new String(ans);
    }
    public static String solve2(String A) {
        int len = A.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            char curr = A.charAt(i);
            if (stack.empty()) {
                stack.push(curr);
            } else {
                if (stack.peek() == '^' || stack.peek() == '*') {
                    char operator = stack.pop();
                    char firstOperand = stack.pop();
                    ans.append(firstOperand);
                    ans.append(curr);
                    ans.append(operator);
                } else if (curr == ')') {
                    while (!stack.empty()) {
                        char x = stack.pop();
                        if (x == '/') {
                            ans.append(x);
                        }
                    }
                } else if (stack.peek() == '+' || stack.peek() == '-') {
                    char operator = stack.pop();
                    ans.append(curr);
                    ans.append(operator);
                }
                stack.push(curr);
            }
        }
        return new String(ans);
    }

    public static String solve1(String A) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int len = A.length();
        while( i < len ) {
            // char curr = A.charAt(i);
            // if (curr == '^') {
            //     char next = A.charAt(i + 1);
            //     StringBuilder s = stack.pop();
            //     s.append(next);
            //     stack.push(s);
            //     i++;
            // } else if (curr == '/' || curr == '*') {
            //     i++;
            //     char next = A.charAt(i);
            //     if ( next == '(' ) {
            //         while ( i < len && A.charAt(i) !=')' ) {
            //             char innerCurr = A.charAt(i);
            //             StringBuilder x = new StringBuilder();
            //             x.append(innerCurr);
            //             stack.push(x);
            //             i++;
            //         }
            //         int j = i;
            //         // while () {}
            //     }

            // } else {
            //     StringBuilder s = new StringBuilder();
            //     s.append(curr);
            //     stack.push(s);
            // }
            // i++;
        }
        return new String(ans);
    }
}
