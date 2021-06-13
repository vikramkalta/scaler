import java.util.ArrayList;
import java.util.HashMap;

public class PrimeDivisors {
    public static void main(String args[]) {
        int[] arr = { 315, 955, 544, 389, 877, 52, 128, 852, 328, 781, 71, 467, 135, 713, 545, 529, 121, 192, 144, 262,
                928, 950, 766, 405, 934, 447, 786, 465, 831, 435, 307, 512, 662, 378, 33, 988, 341, 570, 818, 114, 49,
                522, 700, 81, 392, 237, 304, 916, 581, 413, 659, 409, 258, 807, 633, 946, 233, 466, 582, 576, 371, 809,
                235, 890, 958, 403, 697 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A, 733));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        int count = 0;

        HashMap<Integer, Boolean> primes = new HashMap<>();
        for (int i = 2; i <= B; i++) {
            primes.put(i, true);
        }
        sieve(primes, B);
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (primes.containsKey(curr) && primes.get(curr) && B % curr == 0) {
                count++;
            }
        }
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