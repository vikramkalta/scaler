public class CountOfDigit1 {
    public static void main(String args[]) {
        System.out.println(countOfDig1(110));
    }

    public static int countOfDig1(int A) {
        int countOf1 = 0;

        if (A < 10) {
            return 1;
        }

        // int count1 = A / 10;
        // int count2 = 9 * 2;
        // int count3 = A < 200 ? A - 100 : 99;

        while (A > 10) {
            countOf1++;
            A = A - 10;
        }

        return countOf1 + 1;
    }
}

// for (int i = 0; i <= A; i++) {
// String s = String.valueOf(i);
// if (s.contains("1")) {
// countOf1++;
// }
// }
// return countOf1;
// int ans = 0;
// for (int i = 1; i <= A; i *= 10) {
// int divider = i * 10;
// ans += (A / divider) * i + Math.min(Math.max(A % divider - i + 1, 0), i);
// }
// return ans;