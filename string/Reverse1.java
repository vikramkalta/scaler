public class Reverse1 {
    public static String reverse(String A) {
        A = A.trim();
        int len = A.length();
        
        StringBuilder sb = new StringBuilder(A);

        len = sb.length();
        for (int i = 0; i < len / 2; i++) {
            int revLoc = len - 1 - i;
            char temp = sb.charAt(revLoc);
            char curr = sb.charAt(i);
            sb.setCharAt(i, temp);
            sb.setCharAt(revLoc, curr);
        }

        return new String(sb);
    }
}
