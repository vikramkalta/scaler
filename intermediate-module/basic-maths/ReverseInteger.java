public class ReverseInteger {
    public static void main(String args[]) {
        // System.out.println(reverse(-123));
        // long n = 5827646411L;
        // long n = 5827646411L;
        long n = -1146467285L;
        System.out.println(reverse(n));
    }

    public static int reverse(long A) {
        if (A > Integer.MAX_VALUE || A < Integer.MIN_VALUE) {
            return 0;
        }
        String _str = String.valueOf(A);
        StringBuilder str = new StringBuilder();

        boolean isNegative = false;

        int _strLen = _str.length();
        for (int i = 0; i < _strLen; i++) {
            char curr = _str.charAt(i);
            if (curr == '-') {
                isNegative = true;
            } else {
                str.append(curr);
            }
        }

        int strLen = str.length();

        for (int i = 0; i < strLen / 2; i++) {
            char curr = str.charAt(i);
            char rev = str.charAt(strLen - 1 - i);
            str.setCharAt(strLen - 1 - i, curr);
            str.setCharAt(i, rev);
        }

        int result = 0;
        try {
            result = Integer.parseInt(new String(str));
        } catch (Exception e) {
            //TODO: handle exception
            return 0;
        }
        
        return isNegative ? result * -1 : result;
    }
}
