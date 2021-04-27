public class ReverseColumnTitle {
    public static void main(String args[]) {
        // int A = 26;
        // int A = 27;
        // int A = 676;
        // int A = 677;
        // int A = 701;
        // int A = 702;
        // int A = 703;
        // int A = 1377;
        int A = 474668;
        // int A = 52;
        // int A = 18278;
        // int A = 475254;
        System.out.println(reverseColumnTitle(A));
    }

    public static String reverseColumnTitle(int A) {
        StringBuilder sb = new StringBuilder();
        int mod = 0;
        while (A > 0) {
            mod = A % 26;
            if (mod == 0)
                mod = 26;
            char curr = (char) (64 + mod);
            sb.append(curr);
            A = ((A - 1) / 26);
        }

        int sbLen = sb.length();
        for (int i = 0; i < sbLen / 2; i++) {
            char curr = sb.charAt(i);
            char rev = sb.charAt(sbLen - 1 - i);
            sb.setCharAt(i, rev);
            sb.setCharAt(sbLen - 1 - i, curr);
        }
        return new String(sb);
    }

    // public static String reverseColumnTitle(int A) {
    //     int totalEls = calcExp(A);

    //     StringBuilder sb = new StringBuilder();
    //     int mod = 0;
    //     for (int i = 0; i < totalEls; i++) {
    //         mod = A % 26;
    //         if (mod == 0)
    //             mod = 26;
    //         char curr = (char) (64 + mod);
    //         sb.append(curr);
    //         A = ((A - 1) / 26);
    //     }

    //     for (int i = 0; i < totalEls / 2; i++) {
    //         char curr = sb.charAt(i);
    //         char rev = sb.charAt(totalEls - 1 - i);
    //         sb.setCharAt(i, rev);
    //         sb.setCharAt(totalEls - 1 - i, curr);
    //     }
    //     return new String(sb);
    // }

    public static int calcExp(int n) {
        if (n <= 26) {
            return 1;
        }
        int result = 0;
        int b = n;
        int init = 1;
        int strange = 0;
        while (init + strange + 26 < b) {
            init = init * 26;
            // n = n / 26;
            result++;
            strange = calcExp1(result - 1);
        }

        return result;
    }

    public static int calcExp1(int n) {
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

// public static String reverseColumnTitle(int A) {
// int totalEls = calcExp(A-1);
// StringBuilder sb = new StringBuilder();
// int mod = 0;
// A = A - 1;
// int B = A;
// while (B / 26 > 0) {
// A = A % 26;
// char curr = (char)(65+A);
// sb.append(curr);
// B = B / 26;
// }
// // for (int i = 0; i < totalEls / 2; i++) {
// // char curr = sb.charAt(i);
// // char rev = sb.charAt(totalEls - 1 - i);
// // sb.setCharAt(i, rev);
// // sb.setCharAt(totalEls - 1 - i, curr);
// // }
// return new String(sb);
// }
