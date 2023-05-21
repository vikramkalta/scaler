package string;
public class Reverse {
    public static void main(String args[]) {
        // String A = "the sky is blue";
        String A="qxkpvo  f   w vdg t wqxy ln mbqmtwwbaegx   mskgtlenfnipsl bddjk znhksoewu zwh bd fqecoskmo";
        System.out.println(reverse(A));
    }

    public static String reverse(String A) {
        A = A.trim();
        int len = A.length();
        
        StringBuilder sb = new StringBuilder(A);

        for (int i = 1; i < len; i++) {
            char curr = sb.charAt(i);
            char prev = sb.charAt(i-1);
            if (curr == ' ' && prev == ' ') {
                sb.deleteCharAt(i);
                i--;
                len--;
            }
        }
        len = sb.length();
        for (int i = 0; i < len / 2; i++) {
            int revLoc = len - 1 - i;
            char temp = sb.charAt(revLoc);
            char curr = sb.charAt(i);
            sb.setCharAt(i, temp);
            sb.setCharAt(revLoc, curr);
        }

        int initStrIndex = 0;

        for (int i = 0; i < len; i++) {
            char curr = sb.charAt(i);

            if (curr == ' ' || i == len - 1) {
                if (i == len -1) i = i + 1;
                int endIndex = (i+initStrIndex)/2;
                for (int j = initStrIndex; j < endIndex; j++) {
                    int revLoc = initStrIndex+(i - 1 - j);
                    char temp = sb.charAt(revLoc);
                    char currJ = sb.charAt(j);
                    sb.setCharAt(j, temp);
                    sb.setCharAt(revLoc, currJ);
                }
                initStrIndex = i + 1;
            }
        }

        return new String(sb);
    }
}