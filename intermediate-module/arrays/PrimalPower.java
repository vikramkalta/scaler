import java.util.ArrayList;

public class PrimalPower {
    public static void main(String args[]) {
        int a[] = { -11, 1, 2, 3, 4, 5 };
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arr.add(a[i]);
        }
        System.out.println(primalPower(arr));
    }

    public static int primalPower(ArrayList<Integer> A) {
        int len = A.size();

        int primalCount = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (curr < 2) {
                continue;
            }
            if (curr == 2) {
                primalCount++;
                continue;
            }
            if (isPrime(curr)) {
                primalCount++;
            }
        }
        return primalCount;
    }

    public static boolean isPrime(Integer a) {
        // int squareRoot = ;
        boolean isPrime = true;
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0 && a != i) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static int getSquareRoot(Integer a) {
        int root = 0;
        for (int i = 0; i < a; i++) {
            if (i * i > a) {
                root = i;
                break;
            }
        }
        return root;
    }
}
