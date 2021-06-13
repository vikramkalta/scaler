import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrimeFactors {
    public static void main(String args[]) {
        ArrayList<Integer> B = new ArrayList<>();
        B.add(11);
        System.out.println(solve(1, B));
    }

    public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        HashMap<Integer, Boolean> primeTracker = new HashMap<>();
        int bound = 1000000;
        // int bound = 100;
        // for (int i = 2; i < bound; i++) {
        //     primeTracker.put(i, true);
        // }
        // sieve(primeTracker, bound);

        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < A; i++) {
            int curr = B.get(i);
            count = 0;
            
            ans.add(count);
        }
        
        return ans;
    }

    public static ArrayList<Integer> solve1(int A, ArrayList<Integer> B) {
        HashMap<Integer, Boolean> primeTracker = new HashMap<>();
        int bound = 1000000;
        // int bound = 100;
        for (int i = 2; i < bound; i++) {
            primeTracker.put(i, true);
        }
        sieve(primeTracker, bound);

        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < A; i++) {
            int curr = B.get(i);
            count = 0;
            for (int j = curr; j < bound; j++) {
                if (j % curr != 0) {
                    continue;
                }
                ArrayList<Integer> factors = new ArrayList<>();
                boolean isCurrFound = false;
                for (int k = 1; k * k <= j; k++) {
                    if (j % k == 0) {

                        if (k > curr) {
                            break;
                        }
                        if (k != 1) {
                            if (k == curr) {
                                isCurrFound = true;
                            }
                            factors.add(k);
                        }
                        int otherFactor = j / k;
                        if (otherFactor != k) {
                            if (otherFactor == curr) {
                                isCurrFound = true;
                            }
                            factors.add(otherFactor);
                        }
                    }
                }
                // Eliminating the check if the curr (lowest prime) is not present.
                if (!isCurrFound) {
                    factors.clear();
                }
                int factorLen = factors.size();
                boolean isLowest = true;
                for (int k = 0; k < factorLen; k++) {
                    int currFactor = factors.get(k);
                    boolean val = primeTracker.get(currFactor);
                    if (val) {
                        if (currFactor < curr) {
                            isLowest = false;
                        }
                    }
                }
                if (isLowest && factorLen > 0) {
                    count++;
                }
            }
            ans.add(count);
        }
        
        return ans;
    }

    private static void sieve(HashMap<Integer, Boolean> primeTracker, int bound) {
        for (int i = 2; i * i < bound; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                int counter = 2;
                int product = 1;
                while (true) {
                    product = counter * i;
                    if (product >= bound) {
                        break;
                    }
                    primeTracker.replace(product, false);
                    counter++;
                }
            }
        }
    }
}

// for (Map.Entry mapEl : primeTracker.entrySet()) {
// boolean val = (boolean)mapEl.getValue();
// if (val)System.out.print(mapEl.getKey() + ", ");
// }