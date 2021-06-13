import java.util.ArrayList;
import java.util.HashMap;

public class DistinctPrimes {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 4 };
        int[] arr = { 96, 98, 5, 41, 80 };
        // int[] arr = { 96 };
        // int[] arr = { 315, 955, 544, 389, 877, 52, 128, 852, 328, 781, 71, 467, 135,
        // 713, 545, 529, 121, 192, 144, 262,
        // 928, 950, 766, 405, 934, 447, 786, 465, 831, 435, 307, 512, 662, 378, 33,
        // 988, 341, 570, 818, 114, 49,
        // 522, 700, 81, 392, 237, 304, 916, 581, 413, 659, 409, 258, 807, 633, 946,
        // 233, 466, 582, 576, 371, 809,
        // 235, 890, 958, 403, 697 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
        // System.out.println(factors(140));
    }

    private static ArrayList<Integer> factors(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        // int count = 1;
        for (int i = 2; i * i <= A; i++) {
            if (A % i == 0) {
                result.add(i);
                int x = A / i;
                if (x != i) {
                    result.add(x);
                }
            }
        }
        return result;
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int count = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (max < curr) {
                max = curr;
            }
        }
        HashMap<Integer, Boolean> primes = new HashMap<>();

        for (int i = 2; i <= max; i++) {
            primes.put(i, true);
        }
        sieve(primes, max);

        for (int i = 2; i <= max; i++) {
            if (primes.get(i) && max % i == 0) {
                count++;
            }
        }

        // for (int i = 2; i < len; i++) {
        // int curr = A.get(i);
        // if (primes.get(curr)) {
        // count++;
        // }
        // }
        return count;
    }

    private static void sieve(HashMap<Integer, Boolean> primes, int num) {
        for (int i = 2; i * i <= num; i++) {
            boolean val = primes.get(i);
            if (val) {
                int count = 2;
                while (true) {
                    int product = i * count;
                    count++;
                    if (product > num) {
                        break;
                    }
                    primes.replace(product, false);
                }
            }
        }
    }
}
