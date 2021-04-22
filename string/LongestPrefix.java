import java.util.ArrayList;

public class LongestPrefix {
    public static void main(String args[]) {
        // String[] arr = {"abcdefgh", "aefghijk", "abcefgh"};
        // String[] arr = {"abab", "ab", "abcd"};
        String[] arr = {"ABCD"};
        ArrayList<String> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(longestPrefix(A));
    }

    public static String longestPrefix(ArrayList<String> A) {
        int len = A.size();

        if (len == 1) {
            return A.get(0);
        }

        int minLen = A.get(0).length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {

            for (int j = 1; j < len; j++) {
                String currJ = A.get(j);
                String prevJ = A.get(j - 1);

                int currLen = currJ.length();
                if (minLen > currLen) {
                    minLen = currLen;
                }

                char currCh = currJ.charAt(i);
                char prevCh = prevJ.charAt(i);
                if (currCh == prevCh && j == len - 1) {
                    sb.append(currCh);
                }
                if (currCh != prevCh) {
                    break;
                }
            }
        }

        return new String(sb);
    }
}
