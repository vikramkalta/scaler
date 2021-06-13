import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FactorialArray {
    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        int[] arr = {2, 2, 3, 3};
        // int[] arr = {251, 923, 561, 230, 100, 399, 542, 198, 548, 892, 721, 781, 174, 809, 9, 232, 165, 861, 36, 837, 377, 313, 475, 269, 210, 530, 940, 570, 24, 434, 764, 275, 709, 325, 505, 161, 724, 47, 359, 625, 291, 81, 406, 465, 242, 767, 698, 408, 629, 86, 597, 358, 399, 72, 979, 962, 603, 919, 884, 627, 353, 1, 254, 414, 678, 111, 575, 755, 511, 287, 380, 802, 720, 138, 620, 314, 905, 670, 74, 886, 756, 671, 244, 508, 744, 224, 822, 347, 495, 706, 326, 201, 707, 580, 615, 386, 43, 543, 141, 554 };
        for (int i = 0; i < arr.length; i++) A.add(arr[i]);
        System.out.println(solve(A));
    }
    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int max = Integer.MIN_VALUE;
        int countOne = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (curr == 1) {
                countOne++;
            }
            if (max < curr) {
                max = curr;
            }
        }

        HashMap<Integer, Boolean> sieve = new HashMap<>();
        for (int i = 2; i <= max; i++) {
            sieve.put(i, true);
        }
        sieve(sieve, max);

        int count = len - countOne;
        HashMap<Integer, Integer> primeFactors = new HashMap<>();
        ArrayList<Integer> countOfPrimes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            if (primeFactors.containsKey(curr)) {
                countOfPrimes.add(primeFactors.get(curr));
            } else {
                for (int j = 2; j <= curr; j++) {
                    boolean val = sieve.get(j);
                    if (val) {
                        if (primeFactors.containsKey(curr)) {
                            int countOfPrime = primeFactors.get(curr);
                            countOfPrime++;
                            primeFactors.replace(curr, countOfPrime);
                        } else {
                            primeFactors.put(curr, 1);
                        }
                    }
                }
                countOfPrimes.add(primeFactors.get(curr));
                // if (primeFactors.containsKey(curr)) {
                //     countOfPrimes.add(primeFactors.get(curr));
                // }
            }
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int countOfPrimeLen = countOfPrimes.size();
        try {
            for (int i = 0; i < countOfPrimeLen; i++) {
                Integer curr = countOfPrimes.get(i);
                if (curr == null) {
                    continue;
                }
                if (hm.containsKey(curr)) {
                    int val = hm.get(curr);
                    val++;
                    hm.replace(curr, val);
                } else {
                    hm.put(curr, 1);
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e);
        }
        
        int sum = 0;
        for (Map.Entry mapEl : hm.entrySet()) {
            int val = (int)mapEl.getValue();
            // int key = (int)mapEl.getKey();
            // if (key != 1) {
            sum += getSubsets(val);
            // }
        }
        return count + sum;
    }

    private static int getSubsets(int n) {
        int x = 1 << n;
        return x - 1 - n;
    }

    private static void sieve(HashMap<Integer, Boolean> primes, int max) {
        for (int i = 2; i * i <= max; i++) {
            boolean val = primes.get(i);
            if (val) {
                int product = i;
                int counter = 2;
                while (true) {
                    product = counter * i;
                    if (product > max) {
                        break;
                    }
                    primes.replace(product, false);
                    counter++;
                }
            }
        }
    }
}
