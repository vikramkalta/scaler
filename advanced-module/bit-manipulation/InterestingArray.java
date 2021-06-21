import java.util.ArrayList;

public class InterestingArray {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println();
    }

    public static String solve(ArrayList<Integer> A) {
        int len = A.size();
        int xor = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            xor ^= curr;
        }
        if (xor % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
