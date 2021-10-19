import java.util.ArrayList;

public class LongestBalancedSubstring {
    public static void main(String args[]) {
        // String A = "[()]";
        // String A = "[()";
        // String A = "[]";
        // String A = "][";
        // String A = "[]]";
        String A = "[[{()}]]";
        // String A = "([[]]()}[]([[]]([[]]))[";
        // String A =
        // "))(}[[[[)[(({))((()]]{][[[][{]]][)[]}]])])]}}[]](]())[[}[]}){[[)[][)(]{)]))[[[]{][([[";
        System.out.println(solve(A));
    }

    public static int solve(String A) {
        int len = A.length();
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            dp.add(0);
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            char curr = A.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                dp.set(i, 0);
            } else {
                if (i - 1 < 0) {
                    dp.set(i, 0);
                    continue;
                }

                char prev = A.charAt(i - 1);
                if ((curr == ')' && prev == '(') || (curr == '}' && prev == '{') || (curr == ']' && prev == '[')) {
                    int prevLen  =0;
                    if (i-2 >= 0) {
                        prevLen = dp.get(i-2);
                    }
                    int m = prevLen + 2;
                    if (max < m) {
                        max = m;
                    }
                    dp.set(i, m);
                } else {
                    int prevLen = dp.get(i-1);
                    int x = i - prevLen - 1;
                    char prevMatch = '.';
                    if (x>=0){
                        prevMatch = A.charAt(x);
                    }
                    
                    int m = 0;
                    if ((prevMatch == '(' && curr == ')') || (prevMatch == '{' && curr == '}') || (prevMatch == '[' && curr == ']')) {
                        int y = 0;
                        if (x-1>=0) {
                            y = dp.get(x - 1);
                        }
                        m = (prevLen + 2) + y;
                        if (max < m) {
                            max = m;
                        }
                        dp.set(i, m);
                    }
                }
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    static class Stack {
        int size;
        int length = 0;
        char[] s;

        Stack(int n) {
            s = new char[n];
            size = n;
        }

        void push(char x) {
            if (isFull()) {
                System.out.println("Illegal op");
                System.exit(1);
            }
            s[length] = x;
            length++;
        }

        char pop() {
            if (isEmpty()) {
                System.out.println("Illegal pop");
                System.exit(1);
            }
            char temp = s[length - 1];
            length--;
            return temp;
        }

        boolean isEmpty() {
            return length == 0;
        }

        boolean isFull() {
            return size == length;
        }
    }

    public static int solve1(String A) {
        int len = A.length();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {

            char curr = A.charAt(i);

            StringBuilder str = new StringBuilder();
            str.append(curr);
            for (int j = i + 1; j < len; j++) {
                char currJ = A.charAt(j);
                str.append(currJ);

                Stack s = new Stack(len);

                boolean isBalanced = true;
                for (int k = 0; k < str.length(); k++) {
                    char currK = str.charAt(k);
                    if (currK == '(' || currK == '{' || currK == '[') {
                        s.push(currK);
                    } else {
                        if (s.isEmpty()) {
                            isBalanced = false;
                            break;
                        }
                        char last = s.pop();
                        if ((currK == '}' && last == '{') || (currK == ')' && last == '(')
                                || (currK == ']' && last == '[')) {
                            continue;
                        } else {
                            isBalanced = false;
                            break;
                        }
                    }
                }
                // if (!isBalanced || !s.isEmpty()) {
                // break;
                // }
                if (s.isEmpty() && isBalanced) {
                    int balancedStringLen = str.length();
                    if (max < balancedStringLen) {
                        max = balancedStringLen;
                    }
                }

            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static boolean isBalanced(String A, int startIndex, String str) {
        int len = A.length();
        Stack s = new Stack(len);

        boolean isBalanced = true;
        for (int i = startIndex; i < len; i++) {
            char curr = A.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                s.push(curr);
            } else {
                char last = s.pop();
                if ((curr == '}' && last == '{') || (curr == ')' && last == '(') || (curr == ']' && last == '[')) {
                    continue;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        return isBalanced;
    }
}
