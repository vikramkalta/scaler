package stringalgos;

public class MakeStringPalindrome {
    public static void main(String[] args) {
        // String A = "abc";
        // String A = "acb$abca";
        // String A = "abdbab";
        // cdbabdc
        // bdc$abdc
        String A = "aaaa";
        // aaa$aaaa
        // String A = "abab";
        // String A = "eylfpbnpljvrvipyamyehwqnq";
        // String Z = "qnqwheymaypivrvjlpnbpflye";
        // abab$baba
        // bababab
        // String A = "abab";
        // String B = "abab$abab";
        // 0,0,5,0,3,0,1
        System.out.println(solve(A));
    }

    public static int solve(String A) {
        String s = new String(A);
        StringBuilder sb = new StringBuilder(A);
        s += sb.reverse();
        int lps[];
        // lps array contains the longest prefix, which is also a suffix
        lps = computeLPS(s);
        return Math.max(A.length() - lps[s.length() - 1], 0);
    }
    public static int[] computeLPS(String s) {
        int l = 0, i = 1;
        int lps[] = new int[s.length()];
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(l)) {
                lps[i] = ++l;
                i++;
            } else {
                if (l > 0) {
                    l = lps[l - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
