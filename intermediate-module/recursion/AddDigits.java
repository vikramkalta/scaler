public class AddDigits {
    public static void main(String args[]) {
        int A = 463;
        System.out.println(solve(A));
    }

    public static int solve(int A) {
        String num = String.valueOf(A);

        int sum = 0;
        sum = add(num.length() - 1, num);

        return sum;
    }

    public static int add(int n, String s) {
        if (n < 0) {
            return 0;
        }
        int curr = Character.getNumericValue(s.charAt(n));
        return curr + add(n - 1, s);
    }

}
