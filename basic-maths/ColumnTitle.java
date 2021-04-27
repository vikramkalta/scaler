public class ColumnTitle {
    public static void main(String args[]) {
        // String A = "AAA";
        // String A = "D";
        // String A= "Z";
        // String A = "AAAA";
        // String A = "AZY";
        // String A = "ZZDL";
        String A = "ZZZ";
        // String A = "ZZZZ";
        System.out.println(columnTitle(A));
    }
    
    public static int columnTitle(String A) {
        int len = A.length();

        int pos = 0;

        for (int i = 0; i < len; i++) {
            int curr = A.charAt(i);
            curr = curr - 65 + 1;
            int num = len - 1 - i;
            int mod = curr % 26;
            if (mod == 0) mod = 26;
            int elPos = calcExp(num);
            pos = pos + (elPos * mod);
        }
        return pos;
    }

    public static int calcExp(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * 26;
        }
        return result;
    }
}
