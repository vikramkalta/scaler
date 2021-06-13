import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SumPrime {
    public static void main(String args[]) {
        // System.out.println(solve(4));
        // System.out.println(solve(10));
        // System.out.println(solve(16));
        System.out.println(solve(12));
        // System.out.println(solve(16777214));
    }

    public static ArrayList<Integer> solve(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Boolean> primes = new HashMap<>();

        for (int i = 2; i * i <= A; i++) {
            primes.put(i, true);
        }
        sieve(primes, A);

        for (Map.Entry entry : primes.entrySet()) {
            int key = (int) entry.getKey();
            if (!primes.get(key)) {
                continue;
            }
            int x = A - key;
            boolean isPrime = isPrime(x);
            if (!isPrime) {
                continue;
            }
            if (x < 2 || x >= A) {
                continue;
            }
            if (key <= x) {
                if (result.size() == 0) {
                    result.add(key);
                    result.add(x);
                } else {
                    if (result.get(1) > x && key < result.get(0)) {
                        result.clear();
                        result.add(key);
                        result.add(x);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static ArrayList<Integer> solve2(int A) {
        // long heapMaxSize = Runtime.getRuntime().maxMemory();
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Boolean> primes = new HashMap<>();
        // ArrayList<Boolean> primes = new ArrayList<>();
        // primes.add(false);
        // primes.add(false);
        for (int i = 2; i * i <= A; i++) {
            primes.put(i, true);
        }
        sieve(primes, A);
        for (int i = 2; i < A; i++) {
            boolean exists = primes.containsKey(i);
            if (!exists) {
                primes.put(i, true);
            } else {
                if (!primes.get(i)) {
                    primes.remove(i);
                }
            }
        }

        for (Map.Entry entry : primes.entrySet()) {
            int key = (int) entry.getKey();
            int x = A - key;
            if (!primes.containsKey(x)) {
                continue;
            }
            if (x < 2 || x >= A) {
                continue;
            }
            if (key <= x) {
                if (result.size() == 0) {
                    result.add(key);
                    result.add(x);
                } else {
                    if (result.get(1) > x && key < result.get(0)) {
                        result.clear();
                        result.add(key);
                        result.add(x);
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> solve1(int A) {
        // long heapMaxSize = Runtime.getRuntime().maxMemory();
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Boolean> primes = new HashMap<>();

        for (int i = 2; i <= A; i++) {
            primes.put(i, true);
        }
        sieve(primes, A);

        for (int i = 2; i < A; i++) {
            if (!primes.get(i)) {
                continue;
            }
            int x = A - i;
            if (x < 2 || x >= A) {
                continue;
            }
            boolean val = primes.get(x);
            if (val && i <= x) {
                if (result.size() == 0) {
                    result.add(i);
                    result.add(x);
                } else {
                    if (result.get(1) > x && i < result.get(0)) {
                        result.clear();
                        result.add(i);
                        result.add(x);
                    }
                }
            }
        }
        return result;
    }

    // private static void sieve(ArrayList<Boolean> primes, int num) {

    private static void sieve(HashMap<Integer, Boolean> primes, int num) {
        // ArrayList<Boolean> result = new ArrayList<>();
        for (int i = 2; i * i < num; i++) {
            boolean val = primes.get(i);
            if (val) {
                int count = 2;
                while (true) {
                    int product = i * count;
                    count++;
                    if (product >= num) {
                        break;
                    }
                    primes.put(product, false);
                }
            }
        }
    }
    // private static void sieve(HashMap<Integer, Boolean> primes, int num) {
    // // ArrayList<Boolean> result = new ArrayList<>();
    // // int _num = num / 2;
    // int _num = (int) Math.sqrt(num);
    // for (int i = 2; i * i < num; i++) {
    // boolean val = primes.get(i);
    // if (val) {
    // int count = 2;
    // while (true) {
    // int product = i * count;
    // count++;
    // if (product >= _num) {
    // break;
    // }
    // primes.put(product, false);
    // }
    // }
    // }
    // }
}
// public ArrayList<Integer> primesum(int A) {
// ArrayList<Integer> result = new ArrayList<>();
// HashMap<Integer, Boolean> primes = new HashMap<>();

// for (int i = 2; i * i <= A; i++) {
// primes.put(i, true);
// }
// sieve(primes, A);

// for (Map.Entry entry : primes.entrySet()) {
// int key = (int) entry.getKey();
// if (!primes.get(key)) {
// continue;
// }
// int x = A - key;
// boolean isPrime = isPrime(x);
// if (!isPrime) {
// continue;
// }
// if (x < 2 || x >= A) {
// continue;
// }
// if (key <= x) {
// if (result.size() == 0) {
// result.add(key);
// result.add(x);
// } else {
// if (result.get(1) > x && key < result.get(0)) {
// result.clear();
// result.add(key);
// result.add(x);
// }
// }
// }
// }
// return result;
// }

// private static void sieve(HashMap<Integer, Boolean> primes, int num) {
// // ArrayList<Boolean> result = new ArrayList<>();
// // int _num = num / 2;
// int _num = (int) Math.sqrt(num);
// for (int i = 2; i * i < num; i++) {
// boolean val = primes.get(i);
// if (val) {
// int count = 2;
// while (true) {
// int product = i * count;
// count++;
// if (product >= _num) {
// break;
// }
// primes.put(product, false);
// }
// }
// }
// }

// private static boolean isPrime(int num) {
// boolean isPrime = true;
// for (int i = 2; i * i <= num; i++) {
// if (num % i == 0) {
// isPrime = false;
// break;
// }
// }
// return isPrime;
// }