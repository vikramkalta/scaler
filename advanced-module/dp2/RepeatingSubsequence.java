public class RepeatingSubsequence {
    public static void main(String args[]) {
        // String A = "abab";
        // String A = "abba";
        String A = "QcxJOfXJbd";
        System.out.println(anytwo(A));
    }

    public static int anytwo(String A) {
        int len = A.length();
        int startJ = -1;
        int repeatCount = 0;
        for (int i = 0; i < len; i++) {
            char currI = A.charAt(i);
            startJ = startJ == -1 ? i + 1 : startJ;
            startJ = startJ == i ? startJ + 1 : startJ;
            for (int j = startJ == -1 ? i+1 : startJ; j < len; j++) {
                char currJ = A.charAt(j);
                if (currI == currJ) {
                    startJ = j+1;
                    repeatCount++;
                }
            }
        }
        return repeatCount > 1 ? 1 : 0;
    }
}