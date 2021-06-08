import java.util.ArrayList;

public class DeleteElements {
    public static void main(String args[]) {
        // int[] arr ={81991, 2549, 7};
        // int[] arr ={2, 3, 4, 5};
        // int[] arr = {13, 1, 8, 10};
        // int[] arr = {6, 2, 13, 4, 13, 9, 13, 3, 5};
        // int[] arr = {15, 30};
        int[] arr = {4, 4, 4, 4, 4, 4};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) A.add(arr[i]);
        System.out.println(deleteElements(A));
    }

    public static int deleteElements(ArrayList<Integer> A) {
        int len = A.size();

        // int count = 0;
        boolean isPrimeFound = false;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            boolean isPrime = true;
            for (int j = 2; j * j <= curr; j++) {
                if (curr % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                isPrimeFound = true;
                break;
            }
        }
        if (isPrimeFound) {
            return 0;
        }
        return -1;
    }

    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
