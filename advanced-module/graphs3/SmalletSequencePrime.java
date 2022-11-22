import java.util.HashMap;

public class SmalletSequencePrime {
    public static void main(String args[]) {
        // int A = 2;
        // int B = 3;
        // int C = 5;
        // int D = 5;
        int A = 3;
        int B = 11;
        int C = 7;
        int D = 50;
        System.out.println(solve(A, B, C, D));
    }

    public static int[] solve(int A, int B, int C, int D) {
        int[] result = new int[D];
        HashMap<Integer, Integer> set = new HashMap<>();
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int x = A;
        int y = B;
        int z = C;
        while(l < D) {
            int min = Math.min(Math.min(x, y), z);
            if (!set.containsKey(min)) {
                result[l++] = min;
                set.put(min, 1);
            }
            if (min == x) {
                x = result[i++] * A;
            } else if (min == y) {
                y = result[j++] * B;
            } else if (min == z) {
                z = result[k++] * C;
            }
        }
        return result;
    }
}
