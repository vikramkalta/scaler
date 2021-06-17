public class TestMagicNumber {
    public static void main(String args[]) {
        for (int i = 1; i <= 32; i++) {
            System.out.println(solve(i));
        }
        // System.out.println(solve(30));
        // System.out.println(solve(29));
    }

    static int solve(int n) {
        int pow = 1, answer = 0;

        // Go through every bit of n
        while (n != 0) {
            pow = pow * 5;

            // If last bit of n is set
            if ((int) (n & 1) == 1)
                answer += pow;

            // proceed to next bit
            // or n = n/2
            n >>= 1;
        }
        return answer;
    }

}
