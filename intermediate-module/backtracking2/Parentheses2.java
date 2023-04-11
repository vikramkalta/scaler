package backtracking2;

import java.util.ArrayList;
import java.util.HashSet;

public class Parentheses2 {
    public static void main(String[] args) {
        int A = 3;
        // int A = 4;
        System.out.println(generateParenthesis(A));
    }

    public static ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        generatePStrings(A, 0, 0, result, new StringBuilder());
        return result;
    }
    public static void generatePStrings(int A, int open, int close, ArrayList<String> result, StringBuilder str) {
        if (str.length() == A*2) {
            result.add(new String(str));
            return;
        }
        if (open < A) {
            str.append('(');
            generatePStrings(A, open + 1, close, result, str);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            str.append(')');
            generatePStrings(A, open, close + 1, result, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static ArrayList<String> generateParenthesis1(int A) {
        StringBuilder str = new StringBuilder();
        int len = A * 2;
        for (int i = 0; i < len; i++) {
            if (i < A) {
                str.append('(');
            } else {
                str.append(')');
            }
        }
        ArrayList<String> result = new ArrayList<>();
        // HashSet<String> set = new HashSet<>();
        generatePerm(0, result, str, new HashSet<String>());
        return result;
    }

    public static void generatePerm(int i, ArrayList<String> result, StringBuilder str, HashSet<String> set) {
        if (i >= str.length()) {
            String _str = new String(str);
            // if (isParentheses(_str) && !set.contains(_str)) {
            if (!set.contains(_str)) {
                set.add(_str);
                result.add(new String(str));
            }
            return;
        }
        for (int j = i; j < str.length(); j++) {
            // i != j &&
            if (!isParentheses(new String(str))) {
                continue;
            }
            // swap elements for generating perm
            swap(str, i, j);
            
            generatePerm(i + 1, result, str, set);
            // backtrack
            swap(str, i, j);
        }
    }

    public static void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    public static boolean isParentheses(String str) {
        Stack stack = new Stack(1000000);
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '(') {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top != '(') {
                    return false;
                }
            }
        }
        return true;
    }

    static class Stack {
        int len = 0;
        int top = -1;
        char[] stack;

        Stack(int n) {
            stack = new char[n];
            len = n;
        }

        public void push(char x) {
            if (isFull()) {
                System.out.println("Err push");
                System.exit(1);
            }
            top++;
            stack[top] = x;
        }

        public char pop() {
            if (isEmpty()) {
                System.out.println("Err pop");
                System.exit(1);
            }
            char x = stack[top];
            top--;
            return x;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == len - 1;
        }
    }
}
