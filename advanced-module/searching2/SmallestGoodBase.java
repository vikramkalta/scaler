public class SmallestGoodBase {
    public static void main(String args[]) {
        // System.out.println(solve("13"));
        // System.out.println(solve("4681"));
        // System.out.println(solve2("4831"));
        // System.out.println(solve("6"));
    }

    // public static String solve(String A) {
    // long num = Long.parseLong(A);

    // long l = 2l, r = num - 1, m = 0l;
    // }

    public static String solve3(String A) {
        long num = Long.parseLong(A);

        // int sqrt = (int) Math.sqrt(num);
        // long l = 2l, r = sqrt, m = (l + r) / 2;
        long l = 2l, r = num - 1, m = 0l;

        boolean isFound = false;
        for (int i = 63; i >= 2; i--) {
            while (l <= r) {
                m = (l + r) / 2;
                long sum = 1l, x = 1l, flag = 0l;
                for (int j = 1; j < i; j++) {
                    if (sum == num) {
                        isFound = true;
                        break;
                    }
                    if (((num - sum) / m) < x) {
                        flag = 1;
                        break;
                    }

                    x *= m;
                    sum += x;
                }

                if (sum == num) {
                    isFound = true;
                    break;
                } else if (sum > num || flag == 1) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
                // m = l + ((r - l) / 2);
            }
            if (isFound) {
                break;
            }
        }

        if (isFound) {
            return String.valueOf(m);
        }
        num--;
        return String.valueOf(num);
    }

    public static String solve2(String A) {
        long num = Long.parseLong(A);
        long l = 0l, r = num, m = (l + r) / 2;

        int i = 2;
        int sqrt = (int) Math.sqrt(num);
        int min = Integer.MAX_VALUE;
        boolean isFound = false;
        while (i <= sqrt) {
            long sum = 1l;
            long count = 1;
            while (sum < num) {
                sum += getExp(i, count);
                count++;
            }
            if (sum == num) {
                if (min > i) {
                    min = i;
                    isFound = true;
                }
            }
            i++;
        }
        if (isFound) {
            return String.valueOf(min);
        }
        num--;
        return String.valueOf(num);
    }

    public static String solve1(String A) {
        long num = Long.parseLong(A);
        long l = 0l, r = num, m = (l + r) / 2;

        StringBuilder ans = new StringBuilder();
        while (l <= r) {
            // long product = 1l;
            long sum = 1l;
            long count = 1;
            while (sum <= num) {
                sum += getExp(m, count);
                count++;
            }
            r = m - 1;
            m = (l + r) / 2;
        }

        return new String(ans);
    }

    public static long getExp(long n, long pow) {
        long ans = 1l;
        while (pow > 0) {
            ans = ans * n;
            pow--;
        }
        return ans;
    }
}
