import java.util.ArrayList;

public class ModularInverse {
    public static void main(String args[]) {
        // System.out.println(solve(5, 2, 13));
        // System.out.println(solve(6, 2, 13));
        // System.out.println(solve(3, 2, 33));
        // System.out.println(solve(30, 24, 56));
        System.out.println(solve(41, 27, 143));
    }

    // nCr = (n-1)Cr+(n-1)C(r-1);
    // Create matrix size A+1,B+1
    // matrix[i][i]=1, iCi = 1;
    // matrix[i][j]=matrix[i-1][j]+matrix[i-1][j-1];
    public static int solve(int A, int B, int C) {
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        for (int i = 0; i < A + 1; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < A + 1; j++) {
                arr.add(0);
            }
            pascal.add(arr);
        }
        for (int i = 0; i < A + 1; i++) {
            pascal.get(i).set(0, 1);
        }
        for (int i = 1; i < A + 1; i++) {
            for (int j = 1; j < A + 1; j++) {
                int x = (pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j)) % C;
                pascal.get(i).set(j, x);
            }
        }
        return pascal.get(A).get(B) % C;
    }

    public static int solve1(int A, int B, int C) {
        // A!*B!^p-2*(A-B)!^p-2
        long _x = A - B;
        long x = fact(A, _x, C);
        long y = fact(B, 1, C);
        if (x % y == 0) {
            return (int) ((x / y) % C);
        }
        long inverseMod = powMod(y, C - 2, C);
        long ans = (x * inverseMod) % C;
        return (int) ans;
    }

    private static long fact(long A, long B, long m) {
        long ans = 1;
        for (long i = A; i > B; i--) {
            ans = (ans * i) % m;
            ans *= i;
        }
        return ans;
    }

    private static long powMod(long a, long p, long m) {
        if (p == 1) {
            return a % m;
        }
        long x = powMod(a, p / 2, m);
        if (p % 2 == 0) {
            return (x * x) % m;
        } else {
            return (a * x * x) % m;
        }
    }
}
