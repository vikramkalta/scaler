import java.util.ArrayList;

public class Stairs {
    private static int count = 0;

    public static void main(String args[]) {
        System.out.println(climbStairs(36));
        System.out.println(count);
    }

    public static int climbStairs(int A) {
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            B.add(-1);
        }
        return stair(A, B);
    }

    public static int stair(int A, ArrayList<Integer> B) {
        // count++;
        if (A <= 3) {
            B.set(A - 1, A);
            return A;
        }
        if (B.get(A - 1) != -1) {
            return B.get(A - 1);
        }
        int x = stair(A - 1, B);
        int y = stair(A - 2, B);
        int z = x + y;
        B.set(A - 1, z);
        return z;
    }
}
