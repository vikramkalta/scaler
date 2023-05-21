package string;
import java.util.Arrays;
import java.util.Collections;

public class LexicographicallyLargest {
    public static void main(String args[]) {
        // String A = "abb_c";
        // String A = "psafelqnoe_eflqypyqecbrvxyoagogravxvlmrirxitihomztvjmenihqvfu";
        String A = "ittmcsvmoa_jktvvblefw";
        System.out.println(lexicoLargest(A));
    }

    public static String lexicoLargest(String A) {
        String[] B = A.split("_", 2);

        StringBuilder str = new StringBuilder(B[0]);
        int strLen = str.length();

        String[] tStr = B[1].split("", 0);
        Arrays.sort(tStr, Collections.reverseOrder());
        StringBuilder T = new StringBuilder();
        int tLen = tStr.length;
        for (int i = 0; i < tLen; i++) {
            T.append(tStr[i]);
        }

        for (int i = 0; i < strLen; i++) {
            char currI = str.charAt(i);

            for (int j = 0; j < T.length(); j++) {
                char currJ = T.charAt(j);

                if (currI < currJ) {
                    str.setCharAt(i, currJ);
                    T.deleteCharAt(j);
                    break;
                }
            }
        }

        return new String(str);
    }
}
