import java.util.ArrayList;

public class LetsParty {
    public static void main(String args[]) {
        System.out.println(letsParty(5));
    }

    public static int letsParty(int A) {
        long mod = 10003l;
        ArrayList<Long> dp = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            if (i == 0) {
                dp.add(1l);
            } else if (i == 1) {
                dp.add(2l);
            } else if (i == 2) {
                dp.add(4l);
            } else {
                dp.add(-1l);
            }
        }

        if (A <= 3) {
            long x = dp.get(A - 1);
            return (int) x;
        }

        long ans = 1l;
        for (int i = 3; i < A; i++) {
            long x = dp.get(i - 1);
            ans = x + (i * dp.get(i - 2));
            ans = ans % mod;
            if (ans < 0) {
                ans += mod;
            }
            dp.set(i, ans);
        }
        return (int) ans;
    }
}