public class TrailingZeroes {
    public static void main(String args[]) {
        // System.out.println(solve(5));
        System.out.println(solve(9247));
        // System.out.println(solve(1000));
    }
    // Reference: https://www.purplemath.com/modules/factzero.htm
    public static int solve(int A) {
        int count = 0;
        int mul = 5;
        int div = 1;
        while (div >= 1) {
            int x = A / mul;
            div = x;
            count += x;
            mul *= 5;
        }
        
        return count;
    }

    // 5*4*3*2 -> 120
    // 6*5*4*3*2 -> 720
    public static int solve1(int A) {
        long ans = 1l;
        for (int i = A; i >= 2; i--) {
            ans *= i;
        }
        int count = 0;
        int mod = 10;
        while (ans > 0) {
            if (ans % mod == 0) {
                count++;
            } else {
                break;
            }
            mod *= 10;
            ans /= mod;
        }
        return count;
    }
}
