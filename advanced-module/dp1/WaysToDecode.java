import java.util.ArrayList;

public class WaysToDecode {
    public static void main(String args[]) {
        // String A = "121121";
        // String A = "22630";
        // String A = "06";
        // String A =
        // "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190";
        // String A = "345678";
        // String A = "345127";
        String A = "341127";
        // String A = "1010";
        System.out.println(numDecodings(A));
    }

    public static int numDecodings(String A) {
        long mod = 1000000007l;
        ArrayList<Long> dp = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            dp.add(-1l);
        }
        return (int)(getValidDecodedStrings(A, 0, dp) % mod);
    }

    public static long getValidDecodedStrings(String A, int i, ArrayList<Long> dp) {
        long mod = 1000000007l;
        if (i >= A.length()) {
            return 1;
        }
        if (dp.get(i) != -1l){
            return dp.get(i);
        }
        char curr = A.charAt(i);
        if (Integer.parseInt(new String(new char[] { curr })) == 0) {
            return 0l;
        }
        long x = getValidDecodedStrings(A, i + 1, dp);
        if (i + 1 >= A.length()) {
            return x;
        }
        char next = A.charAt(i + 1);
        int encoded = Integer.parseInt(new String(new char[] { curr, next }));
        if (encoded == 0 || encoded > 26) {
            return x;
        }
        long y = getValidDecodedStrings(A, i + 2, dp);
        dp.set(i, (x+y) % mod);
        return x + y;
    }

    public static int numDecodings2(String A) {
        int len = A.length();
        if (len <= 1) {
            return len;
        }
        long mod = 1000000007l;
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            dp.add(-1);
        }
        char prev = A.charAt(0);
        dp.set(0, getDecodedStrings(Integer.parseInt(new String(new char[] { prev }))));
        char curr = A.charAt(1);
        int x = Integer.parseInt(new String(new char[] { prev, curr }));
        dp.set(1, dp.get(0) + getDecodedStrings(x));

        prev = A.charAt(1);
        for (int i = 2; i < len; i++) {
            curr = A.charAt(i);
            char[] charArr = { prev, curr };
            String strI = new String(charArr);
            int xI = Integer.parseInt(strI);
            long sum = (dp.get(i - 1) * 1l) + (getDecodedStrings(xI) * 1l);
            sum = sum % mod;
            if (sum < 0) {
                sum += mod;
            }
            dp.set(i, (int) sum);
        }
        return dp.get(len - 1);
    }

    public static int getDecodedStrings(int A) {
        if (A > 26 || A == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int solve(String A) {
        long mod = 1000000007l;
        int len = A.length();
        ArrayList<Long> dp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                dp.add(1l);
            } else {
                dp.add(-1l);
            }
        }
        char prev = A.charAt(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            char curr = A.charAt(i);
            String mix = curr + "" + prev;
            int a = Integer.parseInt(String.valueOf(mix));
            if (a <= 26) {
                long combinationsNM2 = 1l;
                if (curr == '0' || prev == '0') {
                    combinationsNM2 = 0l;
                } else {
                    if (i + 2 <= len - 1) {
                        combinationsNM2 = dp.get(i + 2);
                        char secondLastChar = A.charAt(i + 2);
                        int secondLastInt = Integer.parseInt(String.valueOf(secondLastChar));
                        if (combinationsNM2 == 1 && secondLastInt > 2) {
                            combinationsNM2 = 1l;
                        }
                    } else {
                        combinationsNM2 = 1l;
                    }
                }
                dp.set(i, dp.get(i + 1) + combinationsNM2);
            } else {
                dp.set(i, dp.get(i + 1));
            }
            prev = A.charAt(i);
        }
        long ans = dp.get(0);
        ans = ans % mod;
        if (ans < 0) {
            ans += mod;
        }
        return (int) ans;
    }

    static int countDecodingDP(String digits, int n) {
        // A table to store results of subproblems
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        if (digits.charAt(0) == '0') // for base condition "01123" should return 0
            return 0;
        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (digits.charAt(i - 1) > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (digits.charAt(i - 2) == '1' || (digits.charAt(i - 2) == '2' && digits.charAt(i - 1) < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }
}