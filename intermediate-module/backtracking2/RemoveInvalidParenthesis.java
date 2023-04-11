package backtracking2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        String A = "()())()";
        // String A = "(()";
        System.out.println(solve(A));
    }

    public static ArrayList<String> result = new ArrayList<>();
    public static ArrayList<String> solve(String A) {
        int[] arr = new int[A.length()];
        int minToRemove = getMin(A);
        HashSet<String> set = new HashSet<>();
        generatePerm(new StringBuilder(A), 0, arr, minToRemove, set);
        return result;
    }
    public static void generatePerm(StringBuilder A, int i, int[] arr, int minToRemove, HashSet<String> set) {
        if (i >= A.length()) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 1) {
                    str.append(A.charAt(j));
                }
            }
            String x = new String(str);
            if (!set.contains(x)
                && str.length() == A.length() - minToRemove
                && isValidParentheses(x)) {
                set.add(x);
                result.add(x);
            }
            return;
        }
        arr[i] = 0;
        generatePerm(A, i + 1, arr, minToRemove, set);
        arr[i] = 1;
        generatePerm(A, i + 1, arr, minToRemove, set);
    }
    public static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '(') {
                stack.push(curr);
            } else if (curr == ')') {
                if (stack.empty()) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } 
            }
        }
        return stack.empty();
    }
    public static int getMin(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            if (curr == '(') {
                stack.push(curr);
            } else if (curr == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(curr);
                }
            }
        }
        return stack.size();
    }
}
