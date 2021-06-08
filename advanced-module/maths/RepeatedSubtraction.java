import java.util.ArrayList;

public class RepeatedSubtraction {
    public static void main(String args[]) {
        // int[] arr ={81991, 2549, 7};
        // int[] arr ={2, 3, 4, 5};
        // int[] arr = {4, 4, 4, 4, 4, 4};
        // int[] arr = {3, 9, 6, 8, 3};
        int[] arr = {7, 21};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) A.add(arr[i]);
        System.out.println(repeatedSubtraction(15, 5));
    }

    public static int repeatedSubtraction(int A, int B) {
        long ans = gcd(A, B);
        if (A < B) {
            ans += A;
        } else {
            ans += B;
        }
        return (int)ans;
    }

    private static long gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
