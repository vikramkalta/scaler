import java.util.ArrayList;
import java.util.HashMap;

public class SumOfDivisor {
    public static void main(String args[]) {
        // System.out.println(solve(5));
        // System.out.println(solve(9));
        // System.out.println(solve(48));
        System.out.println(solve(39));
        // 4*3*2*1
        // 24
        // 4+3+2+1+8+6+12+24=60
        // 5! = 120
        // 1,2,3,4,5,6, 8,10,12,15,20, 24, 30,40,60,120
        // 21, 65, 24, 250
        // 0+1*1, 1+1*2 3+3*3 + 12+12*4 + 60+60*5(360) + 360+360*6
        // 120*6=720
    }

    public static int solve(int A) {
        long mod = 1000000007l;
        HashMap<Integer, Boolean> sieve = new HashMap<>();
        for (int i = 2; i <= A; i++) {
            sieve.put(i, true);
        }
        sieve(sieve, A);
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= A; i++) {
            if (sieve.get(i)) {
                primes.add(i);
            }
        }
        int primeLen = primes.size();
        long result = 1l;
        for (int i = 0; i < primeLen; i++) {
            long curr = primes.get(i);
            long exp = 0l;
            while (curr <= A) {
                exp = exp + (A / curr);
                curr = curr * primes.get(i);
            }
            long pow = ((long) Math.pow(primes.get(i), exp + 1)) % mod;
            if (pow < 0)
                pow += mod;
            long x = pow - 1;
            long y = primes.get(i) - 1;
            long z = x / y;
            // long x = ((long) Math.pow(primes.get(i), exp + 1) - 1) / (primes.get(i) - 1);
            result = (result * z) % mod;
            if (result < 0)
                result += mod;
        }
        result = result % mod;
        // if (result < 0)
        // result += mod;
        // return (int) (result % mod);
        return (int) result;
    }

    private static void sieve(HashMap<Integer, Boolean> primes, int num) {
        for (int i = 2; i <= num; i++) {
            boolean val = primes.get(i);
            if (val) {
                int count = 2;
                while (true) {
                    int product = i * count;
                    count++;
                    primes.replace(product, false);
                    if (product > num) {
                        break;
                    }
                }
            }
        }
    }

    public static int solve2(int A) {
        long sum = 1l;
        long mod = 1000000007l;
        for (int i = 2; i <= A; i++) {
            long product = (sum * i) % mod;
            if (product < 0)
                product += mod;
            sum = (sum + product) % mod;
            if (sum < 0)
                sum += mod;
        }
        int ans = (int) (sum);
        return ans;
    }

    private static long getFactorial(int A) {
        long mod = 1000000007l;
        long a = (long) A;
        long ans = 1;
        for (int i = 1; i <= a; i++) {
            ans = (ans * i) % mod;
            if (ans < 0)
                ans += mod;
        }
        return ans;
    }

    public static int solve1(int A) {
        long mod = 1000000007l;
        long x = A * (A + 1);
        x = x % mod;
        if (x < 0) {
            x += mod;
        }
        long y = x / 2;
        long ans = y % mod;
        if (ans < 0)
            ans += mod;
        return (int) ans;
    }
}
