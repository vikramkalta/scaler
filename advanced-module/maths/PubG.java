import java.util.ArrayList;

public class PubG {
    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int result = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            result = gcd(curr, result);
        }
        return result;
    }
    private static int gcd(int A, int B) {
        if (B==0){
            return A;
        }
        return gcd(B,A%B);
    }
}
