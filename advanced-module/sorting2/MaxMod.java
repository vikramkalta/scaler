import java.util.ArrayList;
import java.util.Collections;

public class MaxMod {
    public static void main(String args[]) {
        int[] arr = { 927, 707, 374, 394, 279, 799, 878, 937, 431, 112 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        Collections.sort(A);
        int num = A.get(len - 1);
        for (int i = len - 1; i >= 0; i--) {
            int curr = A.get(i);
            if (num != curr) {
                num = curr;
                break;
            }
        }
        return num % A.get(len - 1);
    }
}
