import java.util.HashMap;

public class AthMagicalNumber {
    public static void main(String args[]) {
        System.out.println(solve(10, 2, 3));
        System.out.println(solve(8, 4, 3));
        // System.out.println(solve(14, 2, 16));
        System.out.println(solve(140921682, 23805, 9022));
        System.out.println(solve(11, 12, 13));
    }

    public static int solve(int A, int B, int C) {
        int mod = 1000000007;
        if (B == C) {
            return A * B;
        }

        long min = Math.min(B, C);
        long n = A * min;

        long lcm = (B * C) / gcd(B, C);

        long l = 0, r = n, m = 0l;
        while (l <= r) {
            m = (l + r) / 2;
            long x = (m / B) + (m / C) - (m / lcm);
            if (x > A) {
                r = m - 1;
            } else if (x < A) {
                l = m + 1;
            } else {
                break;
            }
        }
        if (m % B != 0 || m % C != 0) {
            long divisorB = m / B;
            long x = B * divisorB;
            long divisorC = m / C;
            long y = C * divisorC;
            if (x > y) {
                m = x;
            } else {
                m = y;
            }
        }
        m = m % mod;
        if (m < 0)
            m += mod;
        return (int) m;
    }

    public static int solve2(int A, int B, int C) {
        if (B == C) {
            return A * B;
        }
        long min = Math.min(B, C);
        long max = Math.max(B, C);
        long n = A * min;

        long x = n / B;
        long y = n / C;

        long lcm = (B * C) / gcd(B, C);
        long z = n / lcm;
        long totalMagicalNumbers = x + y - z;

        if (totalMagicalNumbers == A) {
            return (int) n;
        }

        long _min = n / min, _max = n / max;
        _min--;
        if (max * _max == n) {
            _max--;
        }

        long ans = 0l;
        while (totalMagicalNumbers >= A) {
            long b = min * _min;
            long c = max * _max;

            if (b > c) {
                _min--;
                totalMagicalNumbers--;
                if (A == totalMagicalNumbers) {
                    ans = b;
                }
            } else if (b < c) {
                _max--;
                totalMagicalNumbers--;
                if (A == totalMagicalNumbers) {
                    ans = c;
                }
            } else {
                // equal case
                _min--;
                _max--;
                totalMagicalNumbers--;
                if (A == totalMagicalNumbers) {
                    ans = c;
                }
            }

        }
        return (int) ans;
    }

    public static long gcd(long A, long B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    // BRUTE FORCE
    public static int solve1(int A, int B, int C) {
        int count = 0;
        int ans = 0, b = 1, c = 1, x = B * b, y = C * c;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (count < A) {
            if (x < y) {
                if (!hm.containsKey(x)) {
                    hm.put(x, count);
                    count++;
                    if (count == A) {
                        ans = x;
                    }
                }
                b++;
                x = B * b;
            } else if (y < x) {
                if (!hm.containsKey(y)) {
                    hm.put(y, count);
                    count++;
                    if (count == A) {
                        ans = y;
                    }
                }
                c++;
                y = C * c;
            } else {
                // x==y equal condition
                if (!hm.containsKey(x)) {
                    hm.put(x, count);
                    count++;
                    if (count == A) {
                        ans = x;
                    }
                }
                if (b < c) {
                    b++;
                    x = B * b;
                } else {
                    c++;
                    y = C * c;
                }
            }

        }

        return ans;
    }
}
