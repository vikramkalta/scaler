public class RotateString {
    public static void main(String args[]) {
        // String A = "scaler";
        String A = "academy";
        // System.out.println(rotateString(A, 2));
        System.out.println(rotateString(A, 7));
    }
    public static String rotateString(String A, int B) {
        int len = A.length();

        StringBuilder sb = new StringBuilder(A);

        for (int i = 0; i < len /2; i++) {
            char curr = sb.charAt(i);
            char temp = sb.charAt(len - 1 - i);
            sb.setCharAt(i, temp);
            sb.setCharAt(len - 1 - i, curr);
        }

        B = B % len;
        for (int i = 0; i < B / 2; i++) {
            char curr = sb.charAt(i);
            char temp = sb.charAt(B - 1 - i);
            sb.setCharAt(i, temp);
            sb.setCharAt(B - 1 - i, curr);
        }

        int newLen = (B + len) / 2;
        int _i = 0;
        for (int i = B; i <  newLen; i++) {
            char curr = sb.charAt(i);
            char temp = sb.charAt(len - 1 - _i);
            sb.setCharAt(i, temp);
            sb.setCharAt(len - 1 - _i, curr);
            _i++;
        }

        return new String(sb);
    }
}
