import java.util.Stack;

public class DoubleCharTrouble {
    public static void main(String[] args) {
        String A = "abccbc";
        System.out.println(solve(A));
    }

    public static String solve(String A) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new  Stack<>();
        int i = 0;
        int len = A.length();
        while (i < len) {
            char curr = A.charAt(i);
            if (!stack.empty() && stack.peek() == curr) {
                stack.pop();
            } else {
                stack.push(curr);
            }
            i++;
        }
        for (int j = 0; j < stack.size(); j++) {
            ans.append(stack.get(j));
        }
        return new String(ans);
    }
}
