import java.util.ArrayList;

public class LuckyNumbers {
    public static void main(String args[]) {
        // System.out.println(solve(16));
        // System.out.println(solve(6));
        System.out.println(solve(8));
    }

    public static int solve(int A) {
        int count = 0;
        for (int i = 3; i <= A; i++) {
            ArrayList<Integer> factors = new ArrayList<>();
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    factors.add(j);
                    if (i / j != j) {
                        factors.add(i/j);
                    }
                }
            }
            int factorLen = factors.size();
            int primeCount = 0;
            for (int j = 0; j < factorLen; j++) {
                int curr = factors.get(j);
                boolean isPrime = true;
                for (int k = 2; k < curr; k++) {
                    if (curr % k == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primeCount++;
                    if (primeCount > 2) {
                        break;
                    }
                }
            }
            if (primeCount == 2) {
                count++;
            }
        }
        return count;
    }
}
