import java.util.ArrayList;

public class WaysToDecode {
    public static void main(String args[]) {
        String A = "121121";
        String B = "345678";
        String C = "345127";
        String D = "341127";
        String E = "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190";
        // System.out.println(countDecodingDP(A, A.length()));
        System.out.println(countDecodingDP(E, E.length()));
        // System.out.println(solve(A));
        // System.out.println(solve(B));
        // System.out.println(solve(C));
        // System.out.println(solve(D));
        // System.out.println(solve(E));
        String F = "1010";
        // System.out.println(solve(F));
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
            if (digits.charAt(i-1) > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (digits.charAt(i-2) == '1' || (digits.charAt(i-2) == '2' && digits.charAt(i-1) < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }
}