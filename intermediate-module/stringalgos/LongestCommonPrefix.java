package stringalgos;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        // String[] A = {"abcdefgh", "aefghijk", "abcefgh"};
        String[] A = {"abab", "ab", "abcd"};
        System.out.println(longestCommonPrefix(A));
    }

    public static String longestCommonPrefix(String[] A) {
        StringBuilder x = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i].length() < minLen) {
                minLen = A[i].length();
            }
        }
        boolean isBreakCondition = false;
        for (int i = 0; i < minLen; i++) {
            char prev = A[0].charAt(i);
            for (int j = 1; j < A.length; j++) {
                char curr = A[j].charAt(i);
                if (prev != curr) {
                    isBreakCondition = true;
                    break;
                }
                prev = curr;
            }
            if (isBreakCondition) {
                break;
            }
            x.append(prev);
        }
        return new String(x);
    }
}